package controller;

import javafx.fxml.FXML;
import java.util.List;
import java.util.Random;
import bbd.bbd;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;

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
    Pokemon pokemon = null;


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
        boolean capturado = rand.nextBoolean();
        
        if (capturado) {
        	Entrenador entrenador = Entrenador.getEntrenadorActual();
        	try {
                String mote = this.getText("Mote del pokémon:", pokemon.getNombre());
        		Connection connection = bbd.getInstance().getConnetion();
                String sql = "INSERT INTO POKEMON (NUM_POKEDEX,ID_ENTRENADOR, CAJA, NOMBRE, MOTE, SALUD, ATAQUE, DEFENSA, VELOCIDAD, AT_ESPECIAL, DEF_ESPECIAL, NIVEL, FERTILIDAD, SEXO, EXPERIENCIA ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, pokemon.getId()); 					// NUM_POKEDEX 
                    statement.setInt(2, entrenador.getId());				// ID_ENTRENADOR
                    statement.setInt(3, 1);									// CAJA
                    statement.setString(4, pokemon.getNombre());			// NOMBRE
                    statement.setString(5, mote);							// MOTE
                    statement.setInt(6, rand.nextInt(26) + 25); 			// SALUD (entre 25 y 50) 
                    statement.setInt(7, rand.nextInt(11) + 10); 			// ATAQUE (entre 10 y 20) 
                    statement.setInt(8, rand.nextInt(21) + 10); 			// DEFENSA (entre 20 y 30) 
                    statement.setInt(9, rand.nextInt(16) + 5); 				// VELOCIDAD (entre 15 y 20) 
                    statement.setInt(10, rand.nextInt(11) + 10); 			// AT_ESPECIAL (entre 15 y 20) 
                    statement.setInt(11, rand.nextInt(21) + 10); 			// DEF_ESPECIAL (entre 20 y 30) 
                    statement.setInt(12, 1); 								// NIVEL (1) 
                    statement.setInt(13, 0); 								// FERTILIDAD (0)
                    statement.setString (14, (rand.nextInt(2)==0)?"M":"H"); // SEXO (entre 'M' y 'H') 
                    statement.setInt(15, 0); 								// EXPERIENCIA (0) 
                    statement.executeUpdate();
                    showAlert(AlertType.INFORMATION, "¡Captura exitosa!", "Has capturado exitosamente al Pokémon " + pokemon.getNombre() + " y ha sido guardado en la base de datos.");
                }
            } catch (SQLException e) {
                showAlert(AlertType.ERROR, "Error de base de datos", "No se pudo guardar el Pokémon en la base de datos: " + e.getMessage());
                e.printStackTrace();
            }

        	
        	
        } else {
            showAlert(AlertType.ERROR, "Captura fallida", "El Pokémon ha escapado.");
            // Hacer que el Pokémon 'desaparezca' al escapar
        }
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
    
    private Pokemon getRadomPokemon() {
    	bbd bd = bbd.getInstance();
    	int cuantos = bd.getCuantosPokemonsHay();
    	
    	Random rand = new Random();
    	int seleccionado = rand.nextInt(cuantos);

    	return bd.getPokemonById(seleccionado);
    }
}

