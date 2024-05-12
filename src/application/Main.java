package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import modelo.Musica;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        try {
        	//Musica musica = new Musica();
        	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/PantallaLogin.fxml"));
            Parent root = loader.load();
    		Scene scene = new Scene(root);
            primaryStage.setScene(scene);
    		primaryStage.setTitle("Proyecto Pokemon");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }		
	
	public static void main(String[] args) {
		launch(args);
	}
}
