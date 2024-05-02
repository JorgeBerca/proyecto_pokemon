package application;	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/login_mediano_final.fxml"));
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