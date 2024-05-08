package bbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Movimiento;

public class MovimientosPokemonBD {

	private Connection connection;
		
	public MovimientosPokemonBD(Connection connetion) {
		this.connection = connetion;
	}
	
	public Movimiento[] getMovimientosPokemon(int idPokemon) {
	    try {
	    	ArrayList<Movimiento>  lista = new ArrayList();
	    	Statement stmt = connection.createStatement();
	    	String sql = "SELECT movimientos.* FROM movimientos "
	    			+ "INNER JOIN movimiento_pokemon ON movimiento_pokemon.ID_MOVIMIENTO = movimientos.ID_MOVIMIENTO "
	    			+ "WHERE movimiento_pokemon.ID_POKEMON="+ idPokemon+ " "
	    			+ "ORDER BY movimientos.ID_MOVIMIENTO "
	    			+ "";
	    	// 	    			+ "  AND movimiento_pokemon.ACTIVO='N "
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
           System.out.println("Error al obtener los movimientos del pokemon " + idPokemon);
           return null;
       }
	}
	
	public Movimiento[] getMovimientosActivosPokemon(int idPokemon) {
	    try {
	    	ArrayList<Movimiento>  lista = new ArrayList();
	    	Statement stmt = connection.createStatement();
	    	String sql = "SELECT movimientos.* FROM movimientos "
	    			+ "INNER JOIN movimiento_pokemon ON movimiento_pokemon.ID_MOVIMIENTO = movimientos.ID_MOVIMIENTO "
	    			+ "WHERE movimiento_pokemon.ID_POKEMON="+ idPokemon+ " "
	    			+ "  AND movimiento_pokemon.ACTIVO='S' "
	    			+ "ORDER BY movimientos.ID_MOVIMIENTO "
	    			+ "";
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
           System.out.println("Error al obtener los movimientos del pokemon " + idPokemon);
           return null;
       }
	}


}
