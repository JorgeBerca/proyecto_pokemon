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
import modelo.PokemonFromDex;
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
    PokemonFromDex pokemon = null;


    @FXML
    public void cambiar() {   	
        try {
        	pokemon = this.getRadomPokemon();
        	System.out.println("Pokemon encontado: "+pokemon.getId() + " - "+ pokemon.getNombre());
        	String randomImage=pokemon.getNombre().toLowerCase()+"_delante.png";

            // Actualizar la imagen en la interfaz
            pokemonrandom.setImage(new Image("file:src/imagenes/pokemon_delante/" + randomImage));
        } catch (Exception e) {
            System.out.println("Error accessing image files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void capturar() {
        Random rand = new Random();
        boolean capturado = (rand.nextInt(101) <= 60); // 60 %
        
        if (capturado) {
        	String mote = this.getText("Mote del pokémon:", pokemon.getNombre());
        	boolean resu = Entrenador.getEntrenadorActual().capturaPokemon(pokemon,mote);
        	if (resu)
        		showAlert(AlertType.INFORMATION, "¡Captura exitosa!", "Has capturado exitosamente al Pokémon " + pokemon.getNombre() + " y ha sido guardado en la base de datos.");
        	else
                showAlert(AlertType.ERROR, "Captura fallida", "No se ha podido guardar el pokémon, ¿demasiados pokémons?.");
        	
        } else {
            showAlert(AlertType.ERROR, "Captura fallida", "El Pokémon ha escapado.");
            // Hacer que el Pokémon 'desaparezca' al escapar
        }
        pokemon = null;
        pokemonrandom.setImage(null);  // Esto borrará la imagen actual mostrada
     
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private String getText(String title, String defaultValue) {
    	TextInputDialog td = new TextInputDialog(defaultValue);
    	td.setTitle(title);
    	td.setHeaderText("");
        td.showAndWait(); 
        return td.getEditor().getText();         		
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
    
    private PokemonFromDex getRadomPokemon() {

    	PokedexBD pokedex = new PokedexBD(BD.getConnetion());
    	
    	int cuantos = pokedex.getCuantosPokemonsHay();
    	
    	Random rand = new Random();
    	int seleccionado = rand.nextInt(cuantos);

    	return pokedex.getPokemonById(seleccionado);
    }
}

