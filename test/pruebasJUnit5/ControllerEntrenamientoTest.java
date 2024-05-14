package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import modelo.Entrenador;
import modelo.Pokedex;
import modelo.Pokemon;
import org.junit.jupiter.api.*;
import util.UtilView;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEntrenamientoTest {

    private ControllerEntrenamiento controllerEntrenamiento;
    private Pokemon pokemon;
    private Pokedex rival;
    private Entrenador entrenador;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerEntrenamiento = new ControllerEntrenamiento();
        entrenador = new Entrenador();
        pokemon = new Pokemon();
        rival = new Pokedex();

        // Initialize JavaFX components
        controllerEntrenamiento.pokemonEquipo = new ImageView();
        controllerEntrenamiento.pokemonRival = new ImageView();

        // Set up the trainer and their team
        entrenador.setEquipo(new Pokemon[]{pokemon});
        Entrenador.setEntrenadorActual(entrenador);

        // Initialize Pokémon details
        pokemon.setNombre("Pikachu");
        pokemon.setExperiencia(100);
        pokemon.setMote("Sparky");

        rival.setNombre("Charmander");
    }

    @Test
    void testInitialize() {
        assertDoesNotThrow(() -> {
            controllerEntrenamiento.initialize();
        });

        assertNotNull(controllerEntrenamiento.pokemon);
        assertEquals("Pikachu", controllerEntrenamiento.pokemon.getNombre());
    }

    @Test
    void testRefrescaVista() {
        // Set up the Pokémon and rival
        controllerEntrenamiento.pokemon = pokemon;
        controllerEntrenamiento.rival = rival;

        assertDoesNotThrow(() -> {
            controllerEntrenamiento.refrescaVista();
        });

        // Verify the images are set correctly
        assertNotNull(controllerEntrenamiento.pokemonEquipo.getImage());
        assertNotNull(controllerEntrenamiento.pokemonRival.getImage());
    }

    @Test
    void testEntrenar() {
        controllerEntrenamiento.pokemon = pokemon;
        controllerEntrenamiento.rival = rival;

        assertDoesNotThrow(() -> {
            controllerEntrenamiento.entrenar();
        });

        // Verify the Pokémon's experience has increased
        assertTrue(controllerEntrenamiento.pokemon.getExperiencia() > 100);
        assertNull(controllerEntrenamiento.rival);
    }

    @Test
    void testCambiarPokemon() {
        assertDoesNotThrow(() -> {
            controllerEntrenamiento.cambiarPokemon();
        });

        // Verify the rival Pokémon is set
        assertNotNull(controllerEntrenamiento.rival);
    }

    @Test
    void testEquipo() {
        assertDoesNotThrow(() -> {
            controllerEntrenamiento.equipo();
        });

        // Verify the selected Pokémon is set
        assertNotNull(controllerEntrenamiento.pokemon);
    }

    @Test
    void testAtras() {
        assertDoesNotThrow(() -> {
           
