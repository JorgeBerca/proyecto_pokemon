package util;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

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
	
	
	
	
}
