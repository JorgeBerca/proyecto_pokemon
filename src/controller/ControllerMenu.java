package controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.Entrenador;
import util.UtilView;

public class ControllerMenu {

    // Asumiendo que tienes un BorderPane en tu archivo FXML principal que actuará como contenedor principal
    @FXML
    private BorderPane mainContainer;
    
    @FXML
    private Label txtDinero;

    public void initialize() {
    	int dinero = Entrenador.getEntrenadorActual().getDinero();
    	txtDinero.setText("PokeDólares: "+UtilView.formateaDinero(dinero));
    }
    	
    public void playMusic() {
        try {
            String path = "C:/Users/jorge/Documents/GitHub/proyecto_pokemon/sonidos/coralChorus.mp3";
            File file = new File(path);
            String mediaURL = file.toURI().toString();
            Media sound = new Media(mediaURL);
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al reproducir música: " + e.getMessage());
        }
    }

    
    @FXML
    public void captura() {
        loadScene("../vistas/PantallaCaptura.fxml");
    }

    @FXML
    public void equipo() {
    	UtilView.loadSceneInPanel("../vistas/PantallaEquipo.fxml", mainContainer);
        //loadScene("../vistas/pantalla equipo.fxml");
    }

    @FXML
    public void centropokemon() {
        loadScene("../vistas/PantallaCentroPokemon.fxml");
    }

    @FXML
    public void combate() {
        loadScene("../vistas/PantallaCombate.fxml");
    }

    @FXML
    public void entrenamiento() {
        loadScene("../vistas/PantallaEntrenamiento.fxml");
    }

    @FXML
    public void crianza() {
        loadScene("../vistas/PantallaCrianza.fxml");
    }

    @FXML
    public void mochila() {
        loadScene("../vistas/PantallaMochilaTienda.fxml");
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
