package bbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	
}
