package bbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.PokemonFromDex;

public class PokedexBD {
	
	private Connection connection;
	
	public PokedexBD(Connection connetion) {
		this.connection = connetion;
	}

	public int getCuantosPokemonsHay() {
		int cuantos = 0;
        try {
            String query = "SELECT COUNT(*) FROM POKEDEX";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                	resultSet.next();
                    cuantos = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; 
        }		
        return cuantos;
	}
	
	public PokemonFromDex getPokemonById(int id) {
        try {
            String query = "SELECT NUM_POKEDEX, NOM_POKEMON, TIPO1, TIPO2, NIVEL_EVOLUCION FROM POKEDEX WHERE NUM_POKEDEX=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                	if (!resultSet.next()) {
                		System.out.println("Pokemon "+id+" no encontrado.");
                		return null;
                	};
                	              	
                	
                	PokemonFromDex pokemon = new PokemonFromDex(
                			resultSet.getInt(1),
                			resultSet.getString(2),
                			resultSet.getString(3),
                			resultSet.getString(4),
                			resultSet.getInt(5) 
                		);
                	return pokemon;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; 
        }		
	}
	
	
	
}
