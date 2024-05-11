package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.UtilView;

public class ControllerMochila {
    @FXML
    public void anillo() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void baston() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void chaleco() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void pesa() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void eter() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void pila() {
        // Método para capturar pokemon, aún no implementado
    }
    
    @FXML
    public void pluma() {
        // Método para capturar pokemon, aún no implementado
    }
    

    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
    }

}
