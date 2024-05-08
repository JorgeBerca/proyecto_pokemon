package controller;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Movimiento;
import modelo.Pokemon;
import modelo.PokemonFromDex;
import util.UtilView;



public class controllercombate {
	
	PokemonFromDex pokemon = null;
	
	Pokemon equipo[];
	Pokemon paladin;
	Pokemon oponente;
	
	@FXML ImageView tupokemon;
	@FXML AnchorPane selector;		
	@FXML AnchorPane botonera;
	
	
    public void initialize() {
    	equipo = Entrenador.getEntrenadorActual().getListaPokemons().getEquipo();
    	setPaladin(0);
    }
	
	
	@FXML
	public void mostrarEquipo() {
		selector.toFront();
		selector.setVisible(true);
		int index = 0;
		for (Node nodo : selector.getChildren()) {
        	String nodoId = nodo.getId();
        	if (nodoId == null) { // es hueco para mostrar un pokemon
        		ImageView imageView = ((ImageView)nodo);
        		if (index <= equipo.length -1) {
        			Pokemon pokemon = equipo[index];
        			Image image = UtilView.getImagenDelante(pokemon.getNombre());
        			imageView.setImage(image);
        			imageView.setUserData(index);
        			imageView.setOnMouseClicked(new ManejaMousePokemon(index));
        		}
        		index++;
        	}			
		} 		
	}
		
	public void setPaladin(int index) {
		if (index >= equipo.length) return;
    	paladin = equipo[index];
    	Image image = UtilView.getImagenDetras(paladin.getNombre());    	    	
    	tupokemon.setImage(image); 
    	//TODO: Hacer imagen más grande    	
	}
	
	public void eligeNuevoPaladin(int index) {
		setPaladin(index);
		selector.toBack();
		selector.setVisible(false);
	}
	
    @FXML
    public void lucha() {
		botonera.toFront();
		botonera.setVisible(true);
		Movimiento movimientos[] = paladin.getMovimientosActivos();
		int index = 0;
		for (Node nodo : botonera.getChildren()) {
       		Button boton = (Button)nodo;
    		if (index < movimientos.length ) {
    			boton.setText(movimientos[index].getNomMovimiento());
    			boton.setVisible(true);
    		} else {
    			boton.setVisible(false);
    		}
    		index++;
      	}			
	}     
    
    
    @FXML
    public void pokemon() {
    	
    }
    @FXML
    public void mochila() {
    	
    }
    
    @FXML
    public void estadisticas() {
    	
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
    
    // Maneja los clicks en los ImageViews
    class ManejaMousePokemon implements EventHandler<MouseEvent> {
    	
    	int index = -1;    	
    	
    	public ManejaMousePokemon(int index) {
			this.index = index;
		}

        @Override
        public void handle(MouseEvent event) {
            System.out.println("Se ha pulsado el pokemon "+index);
            eligeNuevoPaladin(index);
            event.consume();
        }
    };        			
    

}
