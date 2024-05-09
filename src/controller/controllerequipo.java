package controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import util.UtilView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import bbd.BD;
import bbd.PokemonBD;
import controller.ControllerPc.ManejaMousePokemon;



public class controllerequipo {

	@FXML private AnchorPane tablero;

    private ImageView[] pokemonImages = new ImageView[6];    
    private PokemonBD pkBD = new PokemonBD(BD.getConnetion());
    
    
    public void initialize() {
    	if (tablero==null) return;
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
    	limpiaTablero();
        try {
        	Pokemon pc[] = Entrenador.getEntrenadorActual().getListaPokemons().getEquipo();
        	for (int index=0; index < pc.length; index++) {
        		Image image = UtilView.getImagenDelante(pc[index].getNombre());
            	pokemonImages[index].setImage(image);
        		pokemonImages[index].setOnMouseClicked(new ManejaMousePokemon(pc[index]));
        	}
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Pokémon images: " + e.getMessage());
        }
    }
    
    private void limpiaTablero() {
    	for (int i=0; i<pokemonImages.length; i++) {
    		pokemonImages[i].setImage(null);
    		pokemonImages[i].setOnMouseClicked(null);
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

    
	public void mostrarEstadisticas(Pokemon pokemon) {
		Entrenador.getEntrenadorActual().setPokemonElegido(pokemon);
		System.out.println("mostrando: "+pokemon.getNombre());
		UtilView.loadSceneModal("../vistas/pantalla_estadisticas.fxml","Estadísticas",pokemon,1);
    	loadPokemonImages();    			
	}        
	  
    // Maneja los clicks en los ImageViews
    class ManejaMousePokemon implements EventHandler<MouseEvent> {    	
    	
    	Pokemon pokemon = null;    	    	
    	
    	public ManejaMousePokemon(Pokemon pokemon) {
			this.pokemon = pokemon;
		}

        @Override
        public void handle(MouseEvent event) {
        	if (pokemon == null) return;
            System.out.println("Se ha pulsado el pokemon "+pokemon.getNombre());
            mostrarEstadisticas(pokemon);
            event.consume();
        }
    };        			
	
	  
}

