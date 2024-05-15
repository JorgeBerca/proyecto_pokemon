package controller;

import java.io.IOException;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.UtilView;
import modelo.Entrenador;
import modelo.Objeto;
import modelo.Pokemon;
import modelo.ObjetoEntrenador;
import bbd.MochilaTiendaBD;
import bbd.PokemonBD;

public class ControllerMochila {
    
	MochilaTiendaBD mtBD = new MochilaTiendaBD();
	
	@FXML private AnchorPane padre;
    @FXML private Label txtDinero;
	
	Label labels[] = new Label[7];
	
	public void initialize() {		
		txtDinero.setAlignment(Pos.CENTER);
        padre.getChildren().forEach((nodo) -> {
        	String nodoId = nodo.getId();
        	if (nodoId!=null && nodoId.startsWith("label")) {
        		int numero =  Integer.parseInt(nodoId.replaceAll("label", ""));
        		labels[numero-1] = (Label)nodo;        		
        	}
        });
        refrescaDatos();
		
	}
		
	
	private void refrescaDatos() {
    	
		int dinero = Entrenador.getEntrenadorActual().getDinero();
    	txtDinero.setText("PokeDólares: "+UtilView.formateaDinero(dinero));
    	
    	for (int i=0; i<labels.length; i++) {
			labels[i].setText("0");
		}
		for (ObjetoEntrenador obj : Entrenador.getEntrenadorActual().getMochila()) {
			labels[obj.getIdObjeto()-1].setText(""+obj.getCantidad());
		}
	}

	private void click(int idObjeto) {
		Objeto obj = mtBD.getObjeto(idObjeto);
		boolean resultado = Entrenador.getEntrenadorActual().comprar(obj);
	    if (resultado) {
	        System.out.println("Compra realizada. Dinero restante: " + Entrenador.getEntrenadorActual().getDinero());
	    } else {
	    	UtilView.showError("Tienda", "Compra no realizada. ¿Fondos insuficientes?");
	        System.out.println("Compra no realizada. ¿Fondos insuficientes?");
	    }		
        refrescaDatos();
	}
	
    @FXML
	public void anillo() {
		click(1);
	}
   
    
    @FXML
    public void baston() {
		click(2);	
    }
    
    @FXML
    public void chaleco() {
		click(3);	
    }
    
    @FXML
    public void pesa() {
		click(4);	
    }
    
    @FXML
    public void eter() {
		click(5);	
    }
    
    @FXML
    public void pila() {
		click(6);	
    }
    
    @FXML
    public void pluma() {
		click(7);	
    }
    

    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
    }

}
