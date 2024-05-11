package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import util.UtilView;

public class ControllerRecuerdaMovimientos {    
	@FXML
    public void atras(javafx.event.ActionEvent event) {
    	UtilView.mostrarMenuPrincipal(((Node) event.getSource()).getScene());
	}
}
