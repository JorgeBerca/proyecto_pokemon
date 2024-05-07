package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controllermochila {
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
        try {
            // Cargar la vista del menú
            Parent menuView = FXMLLoader.load(getClass().getResource("/vistas/menu_final.fxml"));
            
            // Obtener el escenario actual y establecer la nueva escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(menuView));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla del menú: " + e.getMessage());
        }
    }

}
