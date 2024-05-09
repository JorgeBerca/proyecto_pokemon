package util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Optional;

import controller.PokemonModalController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Entrenador;


public class UtilView {

	// TODO: Reutilizar código no repetir
	
	public static Image getImagenDelante(String nombre) {
	    String fullPath = "/imagenes/pokemon_delante/" + nombre.toLowerCase() + "_delante.png";
	    //System.out.println("Cargando imagen desde: " + fullPath);
	    InputStream is = Entrenador.getEntrenadorActual().getClass().getResourceAsStream(fullPath);
	    if (is == null) {
	        System.out.println("No se pudo encontrar la imagen: " + fullPath);
	        return null;
	    }
		Image image = new Image(is);
	    return image;		
	}

	
	public static Image getImagenDetras(String nombre) {
	    String fullPath = "/imagenes/pokemon_detras/" + nombre.toLowerCase() + "_detras.png";
	    //System.out.println("Cargando imagen desde: " + fullPath);
	    InputStream is = Entrenador.getEntrenadorActual().getClass().getResourceAsStream(fullPath);
	    if (is == null) {
	        System.out.println("No se pudo encontrar la imagen: " + fullPath);
	        return null;
	    }
		Image image = new Image(is);
	    return image;		
	}
	
    public static void loadSceneInPanel(String fxml, Pane pane ) {
        try {
            FXMLLoader loader = new FXMLLoader(Entrenador.getEntrenadorActual().getClass().getResource(fxml));
            Parent newRoot = loader.load();
            pane.getChildren().clear(); 
            pane.getChildren().add(newRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadSceneModal(String fxml, String title, Object data, int flag) {
        try {
        	FXMLLoader fxmlLoader = new FXMLLoader(Entrenador.getEntrenadorActual().getClass().getResource(fxml));
            Parent pcView = fxmlLoader.load();
            PokemonModalController controller = (PokemonModalController)fxmlLoader.getController();
            controller.setData(data);
            controller.setFlag(flag);
            Stage stage = new Stage();
            stage.setScene(new Scene(pcView));
    		stage.setTitle(title);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla: " + e.getMessage());
        }    	
    }
    
    public static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public static boolean confirmAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
            return true;
        }        
        return false;
    }
    
    
    public static String formateaDinero(int dinero) {
    	DecimalFormat formatter = new DecimalFormat("#,##0");
    	return formatter.format(dinero);    	    	
    }

    
	
	
	
	
}
