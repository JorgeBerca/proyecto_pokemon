package controller;

import java.util.ArrayList;

import application.Main;
import bbd.PokemonBD;
import javafx.application.Application;
import javafx.event.ActionEvent;
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


/**
 * Controlador para el combate de nuestro juego de Pokémon.
 * Inicializa los componentes de la vista de usuario y maneja las acciones durante el combate entre dos Pokémon,
 * gestionando los estados y la interacción del usuario a través de la interfaz gráfica.
 *
 * @version 1.0
 * @author JorgeDiego
 * @see modelo.Combate
 * @see modelo.Pokemon
 */

public class ControllerCombate {

	PokemonBD pkBD = new PokemonBD();
	
	Combate combate;
	
	@FXML ImageView tupokemon;
	@FXML ImageView pokemonenemigo;
	@FXML AnchorPane selector;		
	@FXML AnchorPane botonera;
	@FXML ProgressBar vidatupokemon;	
	@FXML ProgressBar vidaenemigo;
	@FXML Label nombreTu;
	@FXML Label nombreRival;
	
	
	/**
	 * Inicializa los componentes necesarios al cargar la vista de combate.
	 *
	 * @version 1.0
	 * @author JorgeDiego
	 */
	
    public void initialize() {
    	if (Entrenador.getEntrenadorActual().getCuantosEquipo()<=0) {
    		UtilView.showError("Combate", "No tienes pokemons en tu equipo.\nNo puedes iniciar un combate.");
    		UtilView.mostrarMenuPrincipal();    		
    	}
    	combate = new Combate(Entrenador.getEntrenadorActual());
    	refrescaEntrenador();
    	refrescaEnemigo();
    }
    
	
    private void refrescaEntrenador() {
    	if (combate.getPaladin()==null) return;
    	tupokemon.setImage(UtilView.getImagenDetras(combate.getPaladin().getNombre()));
    	nombreTu.setText(combate.getPaladin().getMote());
    	vidatupokemon.setProgress(combate.getPorcentajeSaludEntrenador());
    }

    
    private void refrescaEnemigo() {
    	pokemonenemigo.setImage(UtilView.getImagenDelante(combate.getRival().getNombre()));
    	vidaenemigo.setProgress(combate.getPorcentajeSaludRival());
    	nombreRival.setText(combate.getRival().getNombre());    	
    }

    
	@FXML
	public void mostrarEquipo() {
		int cuantos = 0;
		int index = 0;
		for (Node nodo : selector.getChildren()) {
        	String nodoId = nodo.getId();
        	if (nodoId == null) { // es hueco para mostrar un pokemon
        		ImageView imageView = ((ImageView)nodo);
        		Pokemon equipo[] = combate.getEntrenador().getEquipo();
        		imageView.setImage(null);
        		imageView.setOnMouseClicked(null);
        		if (index <= equipo.length -1) {
        			Pokemon pokemon = equipo[index];
        			Image image;
    				image = UtilView.getImagenDelante(pokemon.getNombre());
        			if (pokemon.getSalud()>=0) { // está vivo
	        			imageView.setImage(image);
	        			imageView.setOnMouseClicked(new ManejaMousePokemon(index));
	        			cuantos++;
        			}
        		}        			
        		index++;
        	}			
		} 		
		if (cuantos>0){
			selector.toFront();
			selector.setVisible(true);			
		} else {
			UtilView.showAlert("Combate", "No tienes pokemons con vida en tu equipo.");
		}
	}
		
	public void setPaladin(int index) {
		Pokemon equipo[] = combate.getEntrenador().getEquipo();
		if (index >= equipo.length) return;
		Pokemon nuevoPaladin = equipo[index];
		if (nuevoPaladin.getSalud()<=0) {
			UtilView.showError("Combate", "Tu pokémon "+nuevoPaladin.getMote()+" está muerto.\nNo lo puedes volver a utilizar.");
		}
    	combate.setPaladin(nuevoPaladin);
    	refrescaEntrenador();
    	//TODO: Hacer imagen más grande    	
	}
	
	public void eligeNuevoPaladin(int index) {		
		setPaladin(index);
		selector.toBack();
		selector.setVisible(false);
	}
	
	
    @FXML
    public void lucha() {
		if (combate.getPaladin()==null) {
			UtilView.showAlert("Combate", "Debes seleccionar un pokémon de tu equipo");
			return;
		}
		botonera.toFront();
		botonera.setVisible(true);
		ArrayList<Movimiento> movimientos = combate.getPaladin().getMovimientosActivos();
		int index = 0;
		for (Node nodo : botonera.getChildren()) {
       		Button boton = (Button)nodo;
    		if (index < movimientos.size() ) {
    			Movimiento movimiento = movimientos.get(index);
    			boton.setText(movimiento.getNomMovimiento());
    			boton.setVisible(true);
    			boton.setOnAction(new ManejaMovimientoLucha(movimiento));
    		} else {
    			boton.setVisible(false);
    		}
    		index++;
      	}			
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
    
    private void turno(Movimiento movimiento) {
		System.out.println("Has elegido el movimiento "+movimiento.getNomMovimiento());	            
        combate.movimientoEntrenador(movimiento);
        refrescaEnemigo();
        if (combate.getPorcentajeSaludRival()<=0) {
        	UtilView.showInfo("Combate", "Has matado a "+combate.getRival().getNombre());
        	if (combate.getGanador()==null) {
        		combate.siguientePokemonRival();
        		refrescaEnemigo();
        	}
        } else {	           
            Movimiento movimientoRival = combate.getMovimientoRival();
            System.out.println("El rival ha elegido el movimiento "+movimiento.getNomMovimiento());	            
            combate.movimientoRival(movimientoRival);
            pkBD.guarda(combate.getPaladin());
            refrescaEntrenador();
            if (combate.getPorcentajeSaludEntrenador()<=0) {
            	UtilView.showInfo("Combate", "Tu pokémon "+combate.getPaladin().getMote()+" ha muerto.");
            	if (combate.getGanador()==null)
            		mostrarEquipo();
            }
        }
        Entrenador ganador = combate.getGanador();
        if (ganador!=null) {
        	if (ganador.getId() == -1) {
        		UtilView.showInfo("Combate", "\n\nHas perdido :(\n\n");
        	} else {
        		combate.subirExperienciaEntrenador();
        		combate.robarCartera();
        		UtilView.showInfo("Combate", "\n¡¡¡ Has gandado y robado la cartera a tu rival !!!\n\nLos pokemon de tu equipo han ganado experiencia.\nComprueba en las estadísticas si han subido de nivel.\n");	            		
        	}
        	UtilView.mostrarMenuPrincipal(botonera.getScene());
        }
    	
    }
    
    // Maneja los clicks en los botones de movimientos de lucha
    class ManejaMovimientoLucha implements EventHandler<ActionEvent> {
    	
    	Movimiento movimiento;    	
    	
    	public ManejaMovimientoLucha(Movimiento movimiento) {
			this.movimiento = movimiento;
		}

		@Override
		public void handle(ActionEvent event) {
				turno(movimiento);
	            event.consume();			
		}
    };        			

}
