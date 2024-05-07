package bbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.ListaPokemon;
import modelo.Pokemon;
import modelo.PokemonFromDex;

public class PokemonBD {

	private Connection connection;
	
	public PokemonBD(Connection connetion) {
		this.connection = connetion;
	}
	
	public String[] getByEntrenador(int idEntrenador, int cuantos) {
	    String[] resultado = new String[cuantos];
	    try {
	    	Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT NOMBRE FROM pokemon WHERE ID_ENTRENADOR = "+idEntrenador+" ORDER BY ID_POKEMON LIMIT "+cuantos);
		    int index = 0; 
		    while (rs.next()) {
		    	if (index>=cuantos) continue;
		    	resultado[index++]=rs.getString(1);		    
		    }		    
		    return resultado;
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al obtener los pokemons del entrenador " + e.getMessage());
           resultado=null;
       }
	   return resultado;		
	}
	

	public Pokemon[] getListaPokemonEntrenador(int idEntrenador) {
	    try {
	    	ArrayList<Pokemon>  lista = new ArrayList();
	    	Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon WHERE ID_ENTRENADOR = "+idEntrenador+" ORDER BY ID_POKEMON");		    		    
		    while (rs.next()) {
		    	Pokemon pokemon = new Pokemon(
		    			rs.getInt("ID_POKEMON"),
		    			rs.getInt("NUM_POKEDEX"),
		    			rs.getInt("ID_ENTRENADOR"),
		    			rs.getInt("CAJA"),
		    			rs.getString("NOMBRE"),
		    			rs.getString("MOTE"),
		    			rs.getInt("SALUD"),
		    			rs.getInt("ATAQUE"),
		    			rs.getInt("DEFENSA"),
		    			rs.getInt("VELOCIDAD"),
		    			rs.getInt("AT_ESPECIAL"),
		    			rs.getInt("DEF_ESPECIAL"),
		    			rs.getInt("NIVEL"),
		    			rs.getInt("FERTILIDAD"),
		    			rs.getString("SEXO"),
		    			rs.getInt("ESTADO")		    			
     			);		    			
		    	lista.add(pokemon);
		    }		    
		    Pokemon[] resultado = new Pokemon[lista.size()];
		    return lista.toArray(resultado);
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al obtener los pokemons del entrenador " + e.getMessage());
           return null;
       }
	}
	

	public Pokemon getPokemon(int idPokemon) {
	    try {
	    	Statement stmt = connection.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon WHERE ID_POKEMON = "+idPokemon);		    		    
		    if (!rs.next()) return null;
	    	Pokemon pokemon = new Pokemon(
	    			rs.getInt("ID_POKEMON"),
	    			rs.getInt("NUM_POKEDEX"),
	    			rs.getInt("ID_ENTRENADOR"),
	    			rs.getInt("CAJA"),
	    			rs.getString("NOMBRE"),
	    			rs.getString("MOTE"),
	    			rs.getInt("SALUD"),
	    			rs.getInt("ATAQUE"),
	    			rs.getInt("DEFENSA"),
	    			rs.getInt("VELOCIDAD"),
	    			rs.getInt("AT_ESPECIAL"),
	    			rs.getInt("DEF_ESPECIAL"),
	    			rs.getInt("NIVEL"),
	    			rs.getInt("FERTILIDAD"),
	    			rs.getString("SEXO"),
	    			rs.getInt("ESTADO")		    			
 			);		    			
		    return pokemon;
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al obtener el pokemon por id " + e.getMessage());
           return null;
       }
	}
	
	public void guarda(Pokemon pokemon) {
        String sql = "UPDATE POKEMON SET NUM_POKEDEX=?, ID_ENTRENADOR=?, CAJA=?, NOMBRE=?, MOTE=?, SALUD=?, ATAQUE=?, DEFENSA=?, VELOCIDAD=?, AT_ESPECIAL=?, DEF_ESPECIAL=?, NIVEL=?, FERTILIDAD=?, SEXO=?, EXPERIENCIA=? WHERE POKEMON_ID=?";
        try (PreparedStatement statement = BD.getConnetion().prepareStatement(sql)) {
            statement.setInt(1, pokemon.getNumPokedex() ); 			// NUM_POKEDEX 
            statement.setInt(2, pokemon.getIdEntrenador());						// ID_ENTRENADOR
            statement.setInt(3, pokemon.getCaja());							// CAJA
            statement.setString(4, pokemon.getNombre());			// NOMBRE
            statement.setString(5, pokemon.getMote());							// MOTE
            statement.setInt(6, pokemon.getSalud()); 			// SALUD (entre 25 y 50) 
            statement.setInt(7, pokemon.getAtaque()); 			// ATAQUE (entre 10 y 20) 
            statement.setInt(8, pokemon.getDefensa()); 			// DEFENSA (entre 20 y 30) 
            statement.setInt(9, pokemon.getVelocidad()); 				// VELOCIDAD (entre 15 y 20) 
            statement.setInt(10, pokemon.getAtEspecial()); 			// AT_ESPECIAL (entre 15 y 20) 
            statement.setInt(11, pokemon.getDefEspecial()); 			// DEF_ESPECIAL (entre 20 y 30) 
            statement.setInt(12, pokemon.getNivel()); 								// NIVEL (1) 
            statement.setInt(13, pokemon.getFertilidad()); 								// FERTILIDAD (0)
            statement.setString (14, pokemon.getSexo()); 				// SEXO (entre 'M' y 'H') 
            statement.setInt(15, pokemon.getNivel());					// NIVEL            
            statement.setInt(16, pokemon.getIdPokemon() );					// POKEMON_ID            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	public void borra(Pokemon pokemon) {
        String sql = "DELETE FROM POKEMON WHERE POKEMON_ID=?";
        try (PreparedStatement statement = BD.getConnetion().prepareStatement(sql)) {
            statement.setInt(1, pokemon.getIdPokemon() );	            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}
	
	
}
