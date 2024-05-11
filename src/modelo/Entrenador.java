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
import bbd.PokedexBD;
import javafx.scene.control.Alert.AlertType;

public class Entrenador {
	
	private static Entrenador entrenadorActual = null;
	
	PokedexBD pdBD = new PokedexBD(BD.getConnetion());
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
	Pokemon pokemonElegido;


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
	
	public Pokemon getPokemonElegido() {
		return pokemonElegido;
	}

	public void setPokemonElegido(Pokemon pokemonElegido) {
		this.pokemonElegido = pokemonElegido;
	}
	
	public int getCuantosEquipo() {
		return this.getListaPokemons().getEquipo().length;
	}
	
	public int getCuantosPC() {
		return this.getListaPokemons().getPc().length;		
	}
	
	
	public Pokemon nuevoPokemon(Pokedex pokemonCapturado, String mote) {		
		int cuantosEquipo = this.getListaPokemons().getEquipo().length;
		int cuantosPc = this.getListaPokemons().getPc().length;
		int valorCaja;
		
		if (cuantosEquipo<6) {
			valorCaja=0;
		} else if (cuantosPc<30) {
			valorCaja=1;			
		} else {
			System.out.println("No caben más pokémons");
			return null; // Demasiados pokemon
		}
		
		Pokemon pokemon = this.creaPokemonAleatorio(pokemonCapturado);
		pokemon.setIdEntrenador(id);
		pokemon.setCaja(valorCaja);
		pokemon.setMote(mote);
		System.out.println(pokemon);
		int pokemonId = pkBD.crea(pokemon);
		if (pokemonId<=0) {
			System.out.println("Error al guardar el nuevo pokémon en la base de datos");
			return null;
		}
		
		System.out.println("Capturado: "+pokemonId+" es un "+pokemon.getNombre()+" y lo has llamado "+pokemon.getMote());
		pokemon.setIdPokemon(pokemonId);
		guardaMovimientosNuevoPokemon(pokemonId);
            
        if (pokemonId>0) {
        	this.recargaListaPokemon();
    		return pokemon;
        } else {
        	return null;
        }
				
	}
	
	
	// Optiene un pokemon aleatorio desde pokedex
	public Pokedex getRandomPokedex() {
		Pokedex pokedexCompleto[] = pdBD.getAllPokedex();				
		Random rnd = new Random();
		int aleatorio = rnd.nextInt(pokedexCompleto.length);
		return pokedexCompleto[aleatorio];
	}


	// Genera un pokemon con valores aleatorios
	private Pokemon creaPokemonAleatorio(Pokedex pokedex) {
		Random rand = new Random();
		Pokemon pokemon = new Pokemon();
		pokemon.setNumPokedex(pokedex.getId());
		pokemon.setNombre(pokedex.getNombre());
		pokemon.setMote(pokedex.getNombre());
		pokemon.setSalud(rand.nextInt(26) + 25);
		pokemon.setAtaque(rand.nextInt(11) + 10);
		pokemon.setDefensa(rand.nextInt(21) + 10);
		pokemon.setVelocidad(rand.nextInt(16) + 5);
		pokemon.setAtEspecial(rand.nextInt(11) + 10);
		pokemon.setDefEspecial(rand.nextInt(21) + 10);
		pokemon.setSexo((rand.nextInt(2)==0)?"M":"H");		
		pokemon.setNivel(1);		
		pokemon.setFertilidad(5);		
		return pokemon;
	}

	private void guardaMovimientosNuevoPokemon(int id) {
		Pokemon pokemon = this.pkBD.getPokemon(id);
		Movimiento movNormales[] = mvBD.getMovimientosNivel(pokemon.getNivel(), "Normal");
		Movimiento movTipo1[] = mvBD.getMovimientosNivel(pokemon.getNivel(), pokemon.getTipo1() );
		if ("Normal".equals(pokemon.getTipo1())) movTipo1 = new Movimiento[0];
		Movimiento movTipo2[] = mvBD.getMovimientosNivel(pokemon.getNivel(), pokemon.getTipo2() );
		if ("Normal".equals(pokemon.getTipo2())) movTipo2 = new Movimiento[0];
		Movimiento movimientos[] = Stream.concat(Stream.concat(Arrays.stream(movNormales), Arrays.stream(movTipo1)), Arrays.stream(movTipo2)).toArray(Movimiento[]::new);
		for (int i=0; i<movimientos.length; i++) {
			String activo = (i<4)? "S" : "N";
			pkBD.guardaMovimientoPokemon(movimientos[i].getIdMovimiento(), id, activo );			
		}
	}
		
	public void recargaListaPokemon() {
		Pokemon[] misPokemons = pkBD.getListaPokemonEntrenador(Entrenador.getEntrenadorActual().getId());
		ListaPokemon lista = new ListaPokemon(misPokemons);
		Entrenador.getEntrenadorActual().setListaPokemons(lista);		
	}
	
	public boolean switchPokemon(int id) {
		Pokemon pokemon = pkBD.getPokemon(id);
		if (pokemon==null) return false;
		int caja = pokemon.getCaja();
		int nuevaCaja=0;
		if (caja==0) nuevaCaja=1;		
		if (nuevaCaja==0 && this.getCuantosEquipo()>=6) return false;
		if (nuevaCaja==1 && this.getCuantosPC()>=30) return false;
		pokemon.setCaja(nuevaCaja);
		pkBD.guarda(pokemon);
		recargaListaPokemon();
		return true;
	}
	
	public void liberarPokemon(int id) {
		Pokemon pokemon = pkBD.getPokemon(id);
		pkBD.borra(pokemon);
		recargaListaPokemon();
	}

	public int venderPokemon(int id) {
		
		Pokemon pokemon = pkBD.getPokemon(id);
		pkBD.borra(pokemon);
		recargaListaPokemon();

		int precio = 1000;
		this.dinero = this.dinero + precio;
		
		pkBD.actualizaDineroEntrenador(this.id, this.dinero);
		return precio;
		
	}
	
	
	public void moverPC(Pokemon pokemon) {
		
	}
	
	public void moverEquipo(Pokemon pokemon) {
		
	}
	
	public void entrenar(Pokemon pokemon) {
		
	}
	
	public Pokemon capturar(Pokedex pokemonCapturado, String mote) {
		return nuevoPokemon(pokemonCapturado, mote);
	}
	
	public void combatir() {
		
	}
	
	public Pokemon criar(Pokemon padre, Pokemon madre, String moteHijo) {
		
		// comprobar requisitos para criar
		if (padre==null || madre==null) {
			System.out.println("El padre o la madre no pueden ser nulos.");
			return null;
		}
		if (padre.getFertilidad()<=0 || padre.getFertilidad()<=0) {
			System.out.println("El padre y la madre tienen que tener puntos de fertilidad.");
			return null;
		}
		if (padre.getSexo() == madre.getSexo()) {
			System.out.println("El padre y la madre tienen que tener distinto sexo.");
			return null;
		}
		if (padre.getNombre() != madre.getNombre()) {
			System.out.println("El padre y la madre tienen que ser de la misma especie.");
			return null;
		}
		
		// generar nuevo pokemon aleatorio de la misma especie es lo mismo que capturar
		Pokedex pokedex = pdBD.getPokedexPorNombre(padre.getNombre());
		Pokemon hijo = nuevoPokemon(pokedex, moteHijo);		
		
		// quitar un punto de fertilidad al padre y a la madre
		padre.setFertilidad(padre.getFertilidad()-1);
		madre.setFertilidad(madre.getFertilidad()-1);
		
		return hijo;
		
	}
	
		
}


