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
import modelo.Pokemon;
import util.UtilView;
 
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
        public void estadisticas1() {
        	try {
                Parent secondaryView = FXMLLoader.load(getClass().getResource("../vistas/pantalla_estadisticas.fxml"));
                Scene secondaryScene = new Scene(secondaryView);

                // Obtiene la ventana actual y establece la nueva escena
                Stage window = (Stage) ((Node) secondaryView).getScene().getWindow();
                window.setScene(secondaryScene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        @FXML
        public void estadisticas2() {
        }
        
        @FXML
        public void estadisticas3() {
        }
        
        @FXML
        public void estadisticas4() {
        }
        
        @FXML
        public void estadisticas5() {
        }
        
        @FXML
        public void estadisticas6() {
        }
        
        @FXML
        public void estadisticas7() {
        }
        
        @FXML
        public void estadisticas8() {
        }
        
        @FXML
        public void estadisticas9() {
        }
        
        @FXML
        public void estadisticas10() {
        }
        
        @FXML
        public void estadisticas11() {
        }
        
        @FXML
        public void estadisticas12() {
        }
        
        @FXML
        public void estadisticas13() {
        }
        
        @FXML
        public void estadisticas14() {
        }
        
        @FXML
        public void estadisticas15() {
        }
        
        @FXML
        public void estadisticas16() {
        }
        
        @FXML
        public void estadisticas17() {
        }
        
        @FXML
        public void estadisticas18() {
        }
        
        @FXML
        public void estadisticas19() {
        }
        
        @FXML
        public void estadisticas20() {
        }
        
        @FXML
        public void estadisticas21() {
        }
        
        @FXML
        public void estadisticas22() {
        }
        
        @FXML
        public void estadisticas23() {
        }
        
        @FXML
        public void estadisticas24() {
        }
        
        @FXML
        public void estadisticas25() {
        }
        
        @FXML
        public void estadisticas26() {
        }
        
        @FXML
        public void estadisticas27() {
        }
        
        @FXML
        public void estadisticas28() {
        }
        
        @FXML
        public void estadisticas29() {
        }
        
        @FXML
        public void estadisticas30() {
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
 
