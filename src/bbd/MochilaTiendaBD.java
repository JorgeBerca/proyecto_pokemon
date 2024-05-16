package bbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Objeto;
import modelo.ObjetoEntrenador;
import modelo.Pokedex;

public class MochilaTiendaBD {

	public ArrayList<ObjetoEntrenador> getObjetosEntrenador(int idEntrenador){
	    try {
	    	ArrayList<ObjetoEntrenador>  lista = new ArrayList();
	    	Statement stmt = BD.getConnetion().createStatement();
	    	String sql = "SELECT objeto.*, objeto_entrenador.CANTIDAD FROM objeto_entrenador "
	    			+ "INNER JOIN objeto ON objeto.ID_OBJETO = objeto_entrenador.ID_OBJETO "
	    			+ "WHERE ID_ENTRENADOR="+ idEntrenador+ " "
	    			+ "ORDER BY objeto.ID_OBJETO "
	    			+ "";
	    	// 	    			+ "  AND movimiento_pokemon.ACTIVO='N "
		    ResultSet rs = stmt.executeQuery(sql);		    		    
		    while (rs.next()) {
		    	ObjetoEntrenador objeto = new ObjetoEntrenador(
		    			rs.getInt("ID_OBJETO"),
		    			rs.getString("NOMBRE"),
		    			rs.getInt("CANTIDAD")
     			);		    			
		    	lista.add(objeto);
		    }		    
		    return lista;
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al obtener los objetos del entrenador " + idEntrenador);
           return null;
       }
	}
	
	public Objeto getObjeto(int id) {
        try {
            String query = "SELECT ID_OBJETO, NOMBRE, PRECIO FROM OBJETO WHERE ID_OBJETO=?";
            try (PreparedStatement statement = BD.getConnetion().prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                	if (!resultSet.next()) {
                		System.out.println("Objeto "+id+" no encontrado.");
                		return null;
                	};
                	Objeto objeto = new Objeto(
                			resultSet.getInt("ID_OBJETO"),
                			resultSet.getString("NOMBRE"),
                  			resultSet.getInt("PRECIO")
                		);                		
                	return objeto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; 
        }	
	}

	public void insertaObjetoMochila(int idEntrenador, ObjetoEntrenador obj) {
        try {
            String query = "INSERT INTO OBJETO_ENTRENADOR(ID_OBJETO, ID_ENTRENADOR, CANTIDAD) VALUES (?,?,?)";
            try (PreparedStatement smt = BD.getConnetion().prepareStatement(query)) {
                smt.setInt(1, obj.getIdObjeto());
                smt.setInt(2, idEntrenador);
                smt.setInt(3, obj.getCantidad());
                smt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}

	public void actualizaObjetoMochila(int idEntrenador, ObjetoEntrenador obj) {
        try {
            String query = "UPDATE OBJETO_ENTRENADOR SET CANTIDAD=? WHERE ID_OBJETO=? AND ID_ENTRENADOR=? ";
            try (PreparedStatement smt = BD.getConnetion().prepareStatement(query)) {
                smt.setInt(1, obj.getCantidad());
                smt.setInt(2, obj.getIdObjeto());
                smt.setInt(3, idEntrenador);
                smt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	
}
	

