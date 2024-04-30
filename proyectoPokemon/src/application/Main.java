package application;
	
import java.sql.Connection;

import bd.DataBaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Cargar la vista FXML desde el archivo
        Parent root = FXMLLoader.load(getClass().getResource("/view/login_medio.fxml"));
        
        // Configurar la escena
        Scene scene = new Scene(root);
        
        // Configurar el escenario principal (ventana)
        primaryStage.setTitle("Proyecto Pokemon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
    	DataBaseConnection db = new DataBaseConnection();
    	Connection con = db.getConnection();
    	
    }
}
