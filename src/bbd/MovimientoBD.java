package bbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Movimiento;
import modelo.Pokemon;

public class MovimientoBD {
	
	private Connection connection;
	
	public MovimientoBD( Connection connetion ) {
		this.connection = connetion;
	}
	

	public Movimiento[] getMovimientosNivel(int nivel, String tipo) {
	    try {
	    	ArrayList<Movimiento>  lista = new ArrayList();
	    	Statement stmt = connection.createStatement();
	    	String sql = "SELECT * FROM movimientos WHERE TIPO='"+tipo+"' AND NIVEL_APRENDIZAJE<="+nivel+" AND ESTADO IS NULL ORDER BY ID_MOVIMIENTO";
		    ResultSet rs = stmt.executeQuery(sql);		    		    
		    while (rs.next()) {
		    	Movimiento movimiento = new Movimiento(
		    			rs.getInt("ID_MOVIMIENTO"),
		    			rs.getString("NOM_MOVIMIENTO"),
		    			rs.getInt("POTENCIA"),
		    			rs.getString("TIPO"),
		    			rs.getString("ESTADO"),
		    			rs.getInt("QUITA"),
		    			rs.getInt("TURNOS"),
		    			rs.getString("MEJORA"),
		    			rs.getInt("CANT_MEJORA"),
		    			rs.getInt("NIVEL_APRENDIZAJE")
     			);		    			
		    	lista.add(movimiento);
		    }		    
		    Movimiento[] resultado = new Movimiento[lista.size()];
		    return lista.toArray(resultado);
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al obtener los movimientos del tipo " + tipo + " y nivel "+nivel);
           return null;
       }
	}

	
}
