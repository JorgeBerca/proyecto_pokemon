package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import modelo.Entrenador;
import modelo.Pokemon;
import util.UtilView;

public class ControllerCrianzaSecundario {

	Pokemon madre;
	Pokemon padre;
	
	@FXML
	public void criarHembra() {
		Pokemon[] parametros=new Pokemon[1];
		UtilView.loadSceneModal("/vistas/PantallaElegirEquipo.fxml", "Elige un Pokémon",parametros);
		if (parametros[0]!=null) {
			if (!parametros[0].getSexo().equals("H")) {
				UtilView.showAlert("Crianza", "El pokémon seleccionado no es Hembra.");
			} else {
				madre=parametros[0];				
				System.out.println("Madre: "+madre.getMote());
			}
		}
	}
	
	@FXML
	public void criarMacho() {
		Pokemon[] parametros=new Pokemon[1];
		UtilView.loadSceneModal("/vistas/PantallaElegirEquipo.fxml", "Elige un Pokémon",parametros);		 
		if (parametros[0]!=null) {
			if (!parametros[0].getSexo().equals("M")) {
				UtilView.showAlert("Crianza", "El pokémon seleccionado no es Macho.");
			} else {
				padre=parametros[0];
				System.out.println("Padre: "+padre.getMote());				
			}
		}
	}
	
	@FXML
	public void botonHuevo() {
		if (madre==null || padre==null) return;
		String mote = UtilView.getText("Nombre del hijo/a:",madre.getNombre()+" cria");
		Pokemon hijo = Entrenador.getEntrenadorActual().criar(padre, madre, mote);
		if (hijo==null) {
			UtilView.showError("Crianza", "No se ha podido criar el pokémon.");
		} else {
			UtilView.showInfo("Crianza", "Has criado un nuevo "+hijo.getNombre());
		}
	}

    @FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarPantalla("../vistas/PantallaCrianza.fxml",((Node) event.getSource()).getScene());
    }

}
