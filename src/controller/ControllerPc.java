package controller;
 
import java.awt.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import util.UtilView;

 
public class ControllerPc {
	
	@FXML
	private AnchorPane tablero;
    
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
        	Pokemon pc[] = Entrenador.getEntrenadorActual().getListaPokemons().getPc();
        	for (int index=0; index < pc.length; index++) {
        		Image image = UtilView.getImagenDelante(pc[index].getNombre());
            	pokemonImages[index].setImage(image);
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
        public void estadisticas1(MouseEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/pantalla_estadisticas.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        public void estadisticas2(MouseEvent event) {
            try {
                Parent secondaryView = FXMLLoader.load(getClass().getResource("../vistas/pantalla_estadisticas.fxml"));
                Scene secondaryScene = new Scene(secondaryView);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(secondaryScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
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
 
