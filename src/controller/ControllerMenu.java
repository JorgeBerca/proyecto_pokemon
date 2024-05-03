package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerMenu {

    @FXML
    public void captura() {
        loadScene("../vistas/pantalla captura.fxml");
    }
    
    public void equipo() {
        loadScene("../vistas/pantalla equipo.fxml");
    }

    public void centropokemon() {
        loadScene("../vistas/pantalla centro pokemon 1.fxml");
    }
    
    public void combate() {
        loadScene("../vistas/Pantalla combate.fxml");
    }
    
    public void entrenamiento() {
        loadScene("../vistas/pantalla_entrenamiento.fxml");
    }
    
    public void crianza() {
        loadScene("../vistas/pantalla crianza.fxml");
    }
    
    public void mochila() {
        loadScene("../vistas/pantalla mochila tienda.fxml");
    }
    

    private void loadScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage(); // Crea un nuevo Stage o usa uno existente
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Añade aquí otros métodos de acción para los botones
}
