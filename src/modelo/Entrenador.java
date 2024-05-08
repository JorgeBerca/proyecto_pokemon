package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import bbd.BD;
import bbd.MovimientoBD;
import bbd.PokemonBD;
import javafx.scene.control.Alert.AlertType;

public class Entrenador {
	
	private static Entrenador entrenadorActual = null;
	
	PokemonBD pkBD = new PokemonBD(BD.getConnetion());
	MovimientoBD mvBD = new MovimientoBD(BD.getConnetion());
	
	public static Entrenador getEntrenadorActual() {
		return entrenadorActual;
	}
	
	public static void setEntrenadorActual(int id, String nombre, int dinero) {
		entrenadorActual = new Entrenador(id, nombre, dinero);		
	}

	
	
	int id;
	String nombre;
	int dinero;
	ListaPokemon listaPokemons;


	public Entrenador(int id, String nombre, int dinero) {
		this.id = id;
		this.nombre = nombre;
		this.dinero = dinero;
	}
	
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero;
		
	}

	public ListaPokemon getListaPokemons() {
		return listaPokemons;
	}

	public void setListaPokemons(ListaPokemon listaPokemons) {
		this.listaPokemons = listaPokemons;
	}
	
	public boolean capturaPokemon(PokemonFromDex pokemonCapturado, String mote) {
		int pokemonId = 0;
		Random rand = new Random();
		int cuantosEquipo = this.getListaPokemons().getEquipo().length;
		int cuantosPc = this.getListaPokemons().getPc().length;
		int valorCaja;
		
		if (cuantosEquipo<6) {
			valorCaja=0;
		} else if (cuantosPc<30) {
			valorCaja=1;			
		} else {
			return false; // Demasiados pokemon
		}
		
		
	
        String sql = "INSERT INTO POKEMON (NUM_POKEDEX,ID_ENTRENADOR, CAJA, NOMBRE, MOTE, SALUD, ATAQUE, DEFENSA, VELOCIDAD, AT_ESPECIAL, DEF_ESPECIAL, NIVEL, FERTILIDAD, SEXO, EXPERIENCIA ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = BD.getConnetion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, pokemonCapturado.getId()); 			// NUM_POKEDEX 
            statement.setInt(2, this.getId());						// ID_ENTRENADOR
            statement.setInt(3, valorCaja);							// CAJA
            statement.setString(4, pokemonCapturado.getNombre());			// NOMBRE
            statement.setString(5, mote);							// MOTE
            statement.setInt(6, rand.nextInt(26) + 25); 			// SALUD (entre 25 y 50) 
            statement.setInt(7, rand.nextInt(11) + 10); 			// ATAQUE (entre 10 y 20) 
            statement.setInt(8, rand.nextInt(21) + 10); 			// DEFENSA (entre 20 y 30) 
            statement.setInt(9, rand.nextInt(16) + 5); 				// VELOCIDAD (entre 15 y 20) 
            statement.setInt(10, rand.nextInt(11) + 10); 			// AT_ESPECIAL (entre 15 y 20) 
            statement.setInt(11, rand.nextInt(21) + 10); 			// DEF_ESPECIAL (entre 20 y 30) 
            statement.setInt(12, 1); 								// NIVEL (1) 
            statement.setInt(13, 0); 								// FERTILIDAD (0)
            statement.setString (14, (rand.nextInt(2)==0)?"M":"H"); // SEXO (entre 'M' y 'H') 
            statement.setInt(15, 0);          						//nivel
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            pokemonId=keys.getInt(1);
            
            guardaMovimientosNuevoPokemon(pokemonId);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (pokemonId>0) {
        	this.recargaListaPokemon();
    		return true;
        } else {
        	return false;
        }
				
	}
	
	public void recargaListaPokemon() {
		Pokemon[] misPokemons = pkBD.getListaPokemonEntrenador(Entrenador.getEntrenadorActual().getId());
		ListaPokemon lista = new ListaPokemon(misPokemons);
		Entrenador.getEntrenadorActual().setListaPokemons(lista);		
	}
	
	public void switchPokemon(int id) {
		Pokemon pokemon = pkBD.getPokemon(id);
		if (pokemon==null) return;
		int nuevaCaja=0;
		if (pokemon.getCaja()==0) nuevaCaja=1;
		pokemon.setCaja(nuevaCaja);
		pkBD.guarda(pokemon);
		recargaListaPokemon();
	}
	
	public void soltarPokemon(int id) {
		Pokemon pokemon = pkBD.getPokemon(id);
		pkBD.borra(pokemon);
		recargaListaPokemon();
	}
	
	public void guardaMovimientosNuevoPokemon(int id) {
		Pokemon pokemon = this.pkBD.getPokemon(id);
		Movimiento movNormales[] = mvBD.getMovimientosNivel(pokemon.getNivel(), "Normal");
		Movimiento movTipo1[] = mvBD.getMovimientosNivel(pokemon.getNivel(), pokemon.getTipo1() );
		if ("Normal".equals(pokemon.getTipo1())) movTipo1 = new Movimiento[0];
		Movimiento movTipo2[] = mvBD.getMovimientosNivel(pokemon.getNivel(), pokemon.getTipo2() );
		if ("Normal".equals(pokemon.getTipo2())) movTipo2 = new Movimiento[0];
		Movimiento movimientos[] = Stream.concat(Stream.concat(Arrays.stream(movNormales), Arrays.stream(movTipo1)), Arrays.stream(movTipo2)).toArray(Movimiento[]::new);
		for (int i=0; i<movimientos.length; i++) {
			String activo = (i<4)? "S" : "N";
			guardaMovimientoPokemon(movimientos[i].getIdMovimiento(), id, activo );			
		}
	}
	
	public void guardaMovimientoPokemon(int idMovimiento, int idPokemon, String activo) {
        String sql = "INSERT INTO movimiento_pokemon (ID_MOVIMIENTO,ID_POKEMON, ACTIVO) VALUES (?,?,?)";
        try (PreparedStatement statement = BD.getConnetion().prepareStatement(sql)) {
            statement.setInt(1, idMovimiento); 
            statement.setInt(2, idPokemon);
            statement.setString(3, activo);
            statement.executeUpdate();                        
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
}


