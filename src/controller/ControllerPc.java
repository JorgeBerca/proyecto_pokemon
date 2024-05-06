package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerPc {
	 public void atras(javafx.event.ActionEvent event) {
	        try {
	            // Cargar la vista del menú
	            Parent menuView = FXMLLoader.load(getClass().getResource("/vistas/pantalla centro pokemon.fxml"));
	            
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
