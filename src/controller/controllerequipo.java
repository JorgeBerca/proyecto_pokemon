package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class controllerequipo {
    @FXML private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    public void initialize() {
        System.out.println("Iniciando carga de imágenes...");
        if (imageView1 == null || imageView2 == null || imageView3 == null) {
            System.out.println("Algunos ImageView son nulos");
        }
        loadPokemonImages();
    }

    
    private void loadPokemonImages() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_pokemon", "root", "");
            Statement stmt = conn.createStatement();
            String query = "SELECT NOMBRE FROM pokemon WHERE ID_ENTRENADOR = 3";
            ResultSet rs = stmt.executeQuery(query);
            ImageView[] imageViews = {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6};
            int index = 0;

            while (rs.next() && index < imageViews.length) {
                String imageName = rs.getString("NOMBRE");
                String fullPath = "/imagenes/pokemon_delante/" + imageName + "_delante.png";
                System.out.println("Cargando imagen desde: " + fullPath);
                InputStream is = getClass().getResourceAsStream(fullPath);
                if (is == null) {
                    System.out.println("No se pudo encontrar la imagen: " + fullPath);
                } else {
                    Image image = new Image(is);
                    imageViews[index++].setImage(image);
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Pokémon images: " + e.getMessage());
        }
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
}

