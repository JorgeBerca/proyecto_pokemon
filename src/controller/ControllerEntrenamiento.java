package controller;

import bbd.BD;
import bbd.PokemonBD;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import modelo.Entrenador;
import modelo.Pokedex;
import modelo.Pokemon;
import util.UtilView;

public class ControllerEntrenamiento {

	Pokemon pokemon;
	Pokedex rival;
	
	@FXML ImageView pokemonEquipo;
	@FXML ImageView pokemonRival;

	PokemonBD pkBD = new PokemonBD();
	
	public void initialize() {
		if (Entrenador.getEntrenadorActual().getCuantosEquipo()<=0) return;
		pokemon = Entrenador.getEntrenadorActual().getEquipo()[0];
		System.out.println("DEBUG - initialize - experencia: "+pokemon.getExperiencia());
		refrescaVista();
	}
	
	private void refrescaVista() {
		if (pokemon!=null)
			pokemonEquipo.setImage(UtilView.getImagenDetras(pokemon.getNombre()));
		else
			pokemonRival.setImage(null);

		
		if (rival!=null)
			pokemonRival.setImage(UtilView.getImagenDelante(rival.getNombre()));
		else
			pokemonRival.setImage(null);
	}
	
	@FXML
    public void entrenar() {
		if (rival==null || pokemon==null) return;
		pokemon.entrenar();
		System.out.println("DEBUG - entrenar 1 - experencia: "+pokemon.getExperiencia());
		pkBD.guarda(pokemon);
		System.out.println("DEBUG - entrenar 2 - experencia: "+pokemon.getExperiencia());
		System.out.println("Nueva experiencia: "+pokemon.getExperiencia());
		UtilView.showInfo("Resultado del Entrenamiento","Tu "+pokemon.getMote()+" ha matado a "+rival.getNombre()+".\nHa ganado experiencia.");
		rival = null;
		refrescaVista();
    }
    
    @FXML
    public void cambiarPokemon() {
    	rival = Entrenador.getEntrenadorActual().getRandomPokedex();
    	refrescaVista();    	
    }
 
    @FXML
    public void equipo() {
    	Pokemon[] resultado=new Pokemon[1];
    	UtilView.loadSceneModal("/vistas/PantallaElegirEquipo.fxml", "Elige un Pokémon",resultado);
    	pokemon=resultado[0];
		System.out.println("DEBUG - equipo - experencia: "+pokemon.getExperiencia());
    	refrescaVista();
    }
    

    
	
    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
    }
}
