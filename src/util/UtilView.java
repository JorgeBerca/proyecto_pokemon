package util;

import java.io.InputStream;
import javafx.scene.image.Image;
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
	
	
	
}
