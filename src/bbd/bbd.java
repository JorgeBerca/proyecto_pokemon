package bbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert.AlertType;
import modelo.Entrenador;
import modelo.Pokemon;

// bbd.getInstance().getConnection()

public class bbd {
	
	private static bbd singleInstance;
	private Connection connection;
	
	public bbd() {
		connection = conexionBbd();
	}
	
	public static bbd getInstance() {
        if (singleInstance == null) {
        	singleInstance = new bbd();
        }
        try {
	        if (singleInstance.connection.isClosed()) {
	        	singleInstance.connection = conexionBbd();
	        }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return singleInstance;
	}	
	
	
	public Connection getConnetion() {
		return connection;
	}
	
	private static Connection conexionBbd() {
        // Datos de la conexión a BBD
        String url = "jdbc:mysql://localhost:3306/proyecto_pokemon";
        String usuario = "root";
        String contraseña = "";

        Connection conexion = null;
        try {
            // Establecer la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return conexion;
    }
	
	public int getCuantosPokemonsHay() {
		int cuantos = 0;
        try {
            String query = "SELECT COUNT(*) FROM POKEDEX";
            try (PreparedStatement statement = this.connection.prepareStatement(query)) {
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
	
	public Pokemon getPokemonById(int id) {
        try {
            String query = "SELECT NUM_POKEDEX, NOM_POKEMON, TIPO1, TIPO2, NIVEL_EVOLUCION FROM POKEDEX WHERE NUM_POKEDEX=?";
            try (PreparedStatement statement = this.connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                	if (!resultSet.next()) {
                		System.out.println("Pokemon "+id+" no encontrado.");
                		return null;
                	};
                	Pokemon pokemon = new Pokemon(
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