package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.UtilView;

public class ControllerEntrenamiento {
    @FXML
    public void lucha() {
        // Método para capturar pokemon, aún no implementado
    }
    @FXML
    public void pokemon() {
        // Método para capturar pokemon, aún no implementado
    }
 
	
    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
    }
}
