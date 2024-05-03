package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ControllerMenu {

    // Asumiendo que tienes un BorderPane en tu archivo FXML principal que actuará como contenedor principal
    @FXML
    private BorderPane mainContainer;

    @FXML
    public void captura() {
        loadScene("../vistas/pantalla captura.fxml");
    }

    @FXML
    public void equipo() {
        loadScene("../vistas/pantalla equipo.fxml");
    }

    @FXML
    public void centropokemon() {
        loadScene("../vistas/pantalla centro pokemon.fxml");
    }

    @FXML
    public void combate() {
        loadScene("../vistas/Pantalla combate.fxml");
    }

    @FXML
    public void entrenamiento() {
        loadScene("../vistas/pantalla_entrenamiento.fxml");
    }

    @FXML
    public void crianza() {
        loadScene("../vistas/pantalla crianza.fxml");
    }

    @FXML
    public void mochila() {
        loadScene("../vistas/pantalla mochila tienda.fxml");
    }
    
    private void loadScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent newRoot = loader.load();
            mainContainer.setCenter(newRoot); // Cambia el contenido del centro del BorderPane
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
