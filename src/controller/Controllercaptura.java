package controller;
import javafx.fxml.FXML;
import java.util.Random;
import bbd.BD;
import bbd.PokedexBD;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokedex;
import modelo.Pokemon;
import util.UtilView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;


public class Controllercaptura {
    @FXML
    private ImageView pokemonrandom;
    Pokedex pokedex = null;


    @FXML
    public void cambiar() {   	
        try {
        	pokedex = this.getRadomPokemon();
        	System.out.println("Pokemon encontado: "+pokedex.getId() + " - "+ pokedex.getNombre());
        	String randomImage=pokedex.getNombre().toLowerCase()+"_delante.png";

            // Actualizar la imagen en la interfaz
            pokemonrandom.setImage(new Image("file:src/imagenes/pokemon_delante/" + randomImage));
        } catch (Exception e) {
            System.out.println("Error accessing image files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void capturar() {
    	if (pokedex == null) return;
        Random rand = new Random();
        boolean capturado = ((rand.nextInt(100)+1) <= 60); // 60 %
        
        if (capturado) {
        	String mote = UtilView.getText("Mote del pokémon:", pokedex.getNombre());
        	Entrenador.getEntrenadorActual().capturar(pokedex,mote);
        	if (capturado)
        		UtilView.showInfo("¡Captura exitosa!", "Has capturado exitosamente al Pokémon " + pokedex.getNombre() + " y ha sido guardado en la base de datos.");
        	else
                UtilView.showError("Captura fallida", "No se ha podido guardar el pokémon, ¿demasiados pokémons?.");
        	
        } else {
        	UtilView.showError("Captura fallida", "El Pokémon ha escapado.");
            // Hacer que el Pokémon 'desaparezca' al escapar
        }
        pokedex = null;
        pokemonrandom.setImage(null);  // Esto borrará la imagen actual mostrada
     
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
    
    private Pokedex getRadomPokemon() {
    	return Entrenador.getEntrenadorActual().getRandomPokedex();
    }
}

