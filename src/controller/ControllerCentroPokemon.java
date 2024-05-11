package controller;

import java.io.IOException;
import java.io.File;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControllerCentroPokemon {
	
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
    public void curar() {
        // Método para capturar pokemon, aún no implementado
    }
    @FXML
    public void pc(ActionEvent event) {
        try {
            // Cargar la vista para el PC de almacenamiento Pokémon
            Parent pcView = FXMLLoader.load(getClass().getResource("../vistas/pantalla pc.fxml"));
            
            // Obtener el escenario actual y establecer la nueva escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(pcView));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla del PC: " + e.getMessage());
        }
    	
    }
    
    @FXML
    public void recuerdaMovimientos(ActionEvent event) {
        try {
            Parent menuView = FXMLLoader.load(getClass().getResource("/vistas/pantalla recuerda_movimientos.fxml"));
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(menuView));
            stage.show();

            playMusic(); // Llama a la música aquí
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla del menú: " + e.getMessage());
        }
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
