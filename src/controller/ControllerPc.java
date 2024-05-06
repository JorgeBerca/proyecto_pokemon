package controller;

import java.io.IOException;
import java.io.InputStream;

import bbd.BD;
import bbd.PokemonBD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;

public class ControllerPc {
    
    @FXML private AnchorPane tablero;
   
    private ImageView[] pokemonImages = new ImageView[30];

    private PokemonBD pokemon = new PokemonBD(BD.getConnetion());

    
    public void initialize() {
        System.out.println("Initializing image loading...");

        tablero.getChildren().forEach((nodo) -> {
        	String nodoId = nodo.getId();
        	if (nodoId!=null && nodoId.startsWith("pokemon")) {
        		int numero =  Integer.parseInt(nodoId.replaceAll("pokemon", ""));
        		pokemonImages[numero-1] = (ImageView)nodo;
        	}
        });
        loadPokemonImages();
    }

    private void loadPokemonImages() {
        try {
        	int MAX_POKEMONS = 36;
        	String[] misPokemons = pokemon.getByEntrenador(Entrenador.getEntrenadorActual().getId(), MAX_POKEMONS);        		
        	for (int i = 6; i<MAX_POKEMONS; i++) {
        		if (misPokemons[i] == null) continue;
                String fullPath = "/imagenes/pokemon_delante/" + misPokemons[i] + "_delante.png";
                InputStream is = getClass().getResourceAsStream(fullPath);
                System.out.println("Cargado pokemon "+i);
                if (is == null) {
                    System.out.println("Image not found: " + fullPath);
                } else {
                	pokemonImages[-6+i].setImage(new Image(is));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Pokémon images: " + e.getMessage());
        }
    }
    
    public class StateManager {
        public static boolean isEquipoFull = false;
    }
        public void update() {
            if (StateManager.isEquipoFull) {
                // Código para "llenar" el PC
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

