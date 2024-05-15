package bbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Entrenador;
import modelo.ObjetoEntrenador;
import modelo.Pokemon;

public class LoginBD {

	
	private PokemonBD pkBD;
	private MochilaTiendaBD mtBD;
	
	public LoginBD() {
		this.pkBD = new PokemonBD();
		this.mtBD = new MochilaTiendaBD();
	}
	
    public boolean checkCredentials(String username, String password) {
        try {
            String query = "SELECT ID_ENTRENADOR, NOM_ENTRENADOR, POKEDOLLARS FROM ENTRENADOR WHERE NOM_ENTRENADOR = ? AND PASS = ?";
            try (PreparedStatement statement = BD.getConnetion().prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                	boolean resultado = resultSet.next();
                	if (resultado) {
                		Entrenador.setEntrenadorActual(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                		Pokemon[] misPokemons = pkBD.getListaPokemonEntrenador(Entrenador.getEntrenadorActual().getId());
                		Entrenador.getEntrenadorActual().setListaPokemon(misPokemons);
                		ArrayList<ObjetoEntrenador> misObjetos = mtBD.getObjetosEntrenador(Entrenador.getEntrenadorActual().getId());
                		Entrenador.getEntrenadorActual().setMochila(misObjetos);
                	}
                    return resultado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public boolean exists(String username) {
        try {
            String query = "SELECT * FROM ENTRENADOR WHERE UPPER(TRIM(NOM_ENTRENADOR)) = UPPER(TRIM(?))";
            try (PreparedStatement statement = BD.getConnetion().prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                	boolean resultado = resultSet.next();
                	if (resultado) return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    
    public boolean registerUser(String username, String password) {
    	if (username==null || password==null) {
    		System.out.println("El usuario o el password no pueden ser nulos.");
    		return false;    	
    	}
    	if (username.trim().length()==0 || password.trim().length()==0) {
    		System.out.println("El usuario o el password no pueden estar en blanco.");
    		return false;
    	}
    	if (exists(username.trim())) {
    		System.out.println("El usuario ya existe.");
    		return false;
    	}
        try {
            String query = "INSERT INTO ENTRENADOR (NOM_ENTRENADOR, PASS) VALUES (?, ?)";
            try (PreparedStatement statement = BD.getConnetion().prepareStatement(query)) {
                statement.setString(1, username.trim());
                statement.setString(2, password.trim());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    

	
}
