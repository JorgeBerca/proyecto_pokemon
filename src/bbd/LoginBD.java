package bbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entrenador;

public class LoginBD {

	
	private Connection connection;
	
	public LoginBD(Connection connetion) {
		this.connection = connetion;
	}
	
    public boolean checkCredentials(String username, String password) {
        try {
            String query = "SELECT ID_ENTRENADOR, NOM_ENTRENADOR, POKEDOLLARS FROM ENTRENADOR WHERE NOM_ENTRENADOR = ? AND PASS = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                	boolean resultado = resultSet.next();
                	if (resultado) {
                		Entrenador.setEntrenadorActual(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                	}
                    return resultado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
	
    
    public boolean registerUser(String username, String password) {
        try {
            String query = "INSERT INTO ENTRENADOR (NOM_ENTRENADOR, PASS) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    

	
}
