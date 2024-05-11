package bbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert.AlertType;
import modelo.Entrenador;
import modelo.Pokedex;

// bbd.getInstance().getConnection()

public class BD {
	
	private static Connection connection = null;
	
	
	public static Connection getConnetion() {
		if (connection == null) {
			connection = nuevaConexionBD();
		}
		return connection;
	}
	
	private static Connection nuevaConexionBD() {
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
	
	
}