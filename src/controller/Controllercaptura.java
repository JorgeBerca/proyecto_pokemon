package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controllercaptura {
	  @FXML
	  public void cambiar() {
		  
	  }
	  @FXML
	  public void capturar() {
		  
	  }
	  @FXML
	  public void atras() {
		  
	  }

	      private static final String[] images = {
	          "abra_delante.png", "alakazam_delante.png", "arcanine_delante.png", "arceus_delante.png",
	          "beedrill_frente.png", "blastoise_frente.png", "Bulbasaur_frente.png", "butterfree_frente.png",
	          "caterpie_frente.png", "charizard_frente.png", "Charmander_frente.png", "charmeleon_frente.png",
	          "diglett_delante.png", "dugtrio_delante.png", "exeggcute_frente.png", "exeggutor_frente.png",
	          "gastly_delante.png", "gengar_delante.png", "gloom_delante.png", "growlithe_delante.png",
	          "gyarados_delante.png", "haunter_delante.png", "ivysaur_frente.png", "kadabra_delante.png",
	          "kakuna_frente.png", "lapras_delante.png", "machamp_delante.png", "machoke_delante.png",
	          "machop_delante.png", "magikarp_delante.png", "meowth_delante.png", "metapod_frente.png",
	          "ninetales_delante.png", "oddish_delante.png", "persian_delante.png", "pidgeot_frente.png",
	          "pidgeotto_frente.png", "pidgey_frente.png", "pikachu_delante.png", "psyduck_delante.png",
	          "raichu_delante.png", "raticate_frente.png", "rattata_frente.png", "scyther_delante.png",
	          "snorlax_delante.png", "squirtle_frente.png", "venusaur_frente.png", "vulpix_delante.png",
	          "wartortle_frente.png", "weedle_frente.png"
	      };

	      public Image getRandomPokemonImage() {
	          int index = new Random().nextInt(images.length);
	          String imagePath = "file:src/imagenes/pokemon_delante/" + images[index];
	          return new Image(imagePath);
	      }
	      
	      public void updatePokemonImage(ImageView imageView) {
	          imageView.setImage(getRandomPokemonImage());
	      }
	  }
