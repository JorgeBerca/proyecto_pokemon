package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.UtilView;

public class ControllerCrianzaSecundario {
	
	@FXML
	public void criarHembra() {
		
	}
	
	@FXML
	public void criarMacho() {
		
	}
	
	@FXML
	public void botonHuevo() {
		
	}

    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarPantalla("../vistas/PantallaCrianza.fxml",((Node) event.getSource()).getScene());
    }
}
