package controller;

import javafx.fxml.FXML;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerCaptura {
    @FXML
    private ImageView pokemonrandom; 

    @FXML
    public void cambiar() {
        try {
            // Lista de nombres de imágenes codificados directamente
            List<String> allImages = List.of(
                "abra_delante.png", "alakazam_delante.png", "arcanine_delante.png", 
                "arceus_delante.png", "beedrill_frente.png", "blastoise_frente.png",
                "Bulbasaur_frente.png", "butterfree_frente.png", "caterpie_frente.png",
                "charizard_frente.png", "Charmander_frente.png", "charmeleon_frente.png",
                "diglett_delante.png", "dugtrio_delante.png",
                "exeggcute_frente.png", "exeggutor_frente.png", "gastly_delante.png",
                "gengar_delante.png", "gloom_delante.png", "growlithe_delante.png",
                "gyarados_delante.png", "haunter_delante.png", "ivysaur_frente.png",
                "kadabra_delante.png", "kakuna_frente.png", "lapras_delante.png",
                "machamp_delante.png", "machoke_delante.png", "machop_delante.png",
                "magikarp_delante.png", "meowth_delante.png", "metapod_frente.png",
                "ninetales_delante.png", "oddish_delante.png", "persian_delante.png",
                "pidgeot_frente.png", "pidgeotto_frente.png", "pidgey_frente.png",
                "pikachu_delante.png", "psyduck_delante.png", "raichu_delante.png",
                "raticate_frente.png", "rattata_frente.png", "scyther_delante.png",
                "snorlax_delante.png", "squirtle_frente.png", "venusaur_frente.png",
                "vulpix_delante.png", "wartortle_frente.png", "weedle_frente.png"
            );
            Random rand = new Random();

            // Seleccionar un nombre de archivo al azar
            String randomImage = allImages.get(rand.nextInt(allImages.size()));

            // Actualizar la imagen en la interfaz
            pokemonrandom.setImage(new Image("file:src/imagenes/pokemon_delante/" + randomImage));
        } catch (Exception e) {
            System.out.println("Error accessing image files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void capturar() {
        // Método para capturar pokemon, aún no implementado
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

