package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Combate;
import modelo.Entrenador;
import modelo.Movimiento;
import modelo.Pokemon;
import util.UtilView;



public class ControllerCombate {

	Combate combate;
	
	@FXML ImageView tupokemon;
	@FXML ImageView pokemonenemigo;
	@FXML AnchorPane selector;		
	@FXML AnchorPane botonera;
	@FXML ProgressBar vidatupokemon;	
	@FXML ProgressBar vidaenemigo;
	@FXML Label nombreTu;
	@FXML Label nombreRival;
	
	
	
    public void initialize() {
    	combate = new Combate(Entrenador.getEntrenadorActual());
    	tupokemon.setImage(UtilView.getImagenDetras(combate.getPaladin().getNombre()));
    	pokemonenemigo.setImage(UtilView.getImagenDelante(combate.getRival().getNombre()));
    	refrescaPorcentajeSalud();
    	nombreTu.setText(combate.getPaladin().getMote());
    	nombreRival.setText(combate.getRival().getNombre());
    }
	
    private void refrescaPorcentajeSalud() {
    	vidatupokemon.setProgress(combate.getPorcentajeSaludEntrenador());
    	vidaenemigo.setProgress(combate.getPorcentajeSaludRival());
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
        		Pokemon equipo[] = combate.getEntrenador().getEquipo();
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
		Pokemon equipo[] = combate.getEntrenador().getEquipo();
		if (index >= equipo.length) return;
    	combate.setPaladin(equipo[index]);
    	Image image = UtilView.getImagenDetras(equipo[index].getNombre());    	    	
    	tupokemon.setImage(image); 
    	nombreTu.setText(combate.getPaladin().getMote());
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
		Movimiento movimientos[] = combate.getPaladin().getMovimientosActivos();
		int index = 0;
		for (Node nodo : botonera.getChildren()) {
       		Button boton = (Button)nodo;
    		if (index < movimientos.length ) {
    			boton.setText(movimientos[index].getNomMovimiento());
    			boton.setVisible(true);
    			//boton.setOnAction();
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
   		UtilView.loadSceneModal("/vistas/PantallaEstadisticas.fxml","Estadísticas",combate.getPaladin());
    }
    
 
	
    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
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
