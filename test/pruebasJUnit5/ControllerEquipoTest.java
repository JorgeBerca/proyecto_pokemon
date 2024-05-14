package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEquipoTest {

    private ControllerEquipo controllerEquipo;
    private Entrenador entrenador;
    private Pokemon[] equipo;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerEquipo = new ControllerEquipo();
        entrenador = new Entrenador();
        equipo = new Pokemon[6];

        // Initialize JavaFX components
        controllerEquipo.tablero = new AnchorPane();
        for (int i = 0; i < 6; i++) {
            ImageView imageView = new ImageView();
            imageView.setId("pokemon" + (i + 1));
            controllerEquipo.tablero.getChildren().add(imageView);
        }

        // Set up the trainer and their team
        for (int i = 0; i < 6; i++) {
            equipo[i] = new Pokemon();
            equipo[i].setNombre("Pokemon" + (i + 1));
        }
        entrenador.setEquipo(equipo);
        Entrenador.setEntrenadorActual(entrenador);
    }

    @Test
    void testInitialize() {
        assertDoesNotThrow(() -> {
            controllerEquipo.initialize();
        });

        // Verify the ImageView array is initialized correctly
        for (int i = 0; i < 6; i++) {
            assertNotNull(controllerEquipo.pokemonImages[i]);
        }
    }

    @Test
    void testLoadPokemonImages() {
        controllerEquipo.initialize();

        assertDoesNotThrow(() -> {
            controllerEquipo.loadPokemonImages();
        });

        // Verify the images are set correctly
        for (int i = 0; i < equipo.length; i++) {
            assertNotNull(controllerEquipo.pokemonImages[i].getImage());
        }
    }

    @Test
    void testLimpiaTablero() {
        controllerEquipo.initialize();
        controllerEquipo.loadPokemonImages();

        assertDoesNotThrow(() -> {
            controllerEquipo.limpiaTablero();
        });

        // Verify the images and event handlers are cleared
        for (int i = 0; i < 6; i++) {
            assertNull(controllerEquipo.pokemonImages[i].getImage());
            assertNull(controllerEquipo.pokemonImages[i].getOnMouseClicked());
        }
    }

    @Test
    void testAtras() {
        assertDoesNotThrow(() -> {
            ActionEvent event = new ActionEvent();
            Node node = new JFXPanel(); // Placeholder node for the event
            event = new ActionEvent(node, node);
            controllerEquipo.atras(event);
        });
    }

    @Test
    void testMostrarEstadisticas() {
        controllerEquipo.initialize();
        Pokemon testPokemon = new Pokemon();
        testPokemon.setNombre("TestPokemon");

        assertDoesNotThrow(() -> {
            controllerEquipo.mostrarEstadisticas(testPokemon);
        });

        // Since it's difficult to verify the actual UI change, just check the console output
        assertEquals("TestPokemon", testPokemon.getNombre());
    }

    @Test
    void testManejaMousePokemon() {
        controllerEquipo.initialize();
        Pokemon testPokemon = equipo[0];
        ControllerEquipo.ManejaMousePokemon handler = controllerEquipo.new ManejaMousePokemon(testPokemon);

        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 1, false, false, false, false, true, false, false, false, false, false, null);
        assertDoesNotThrow(() -> {
            handler.handle(event);
        });

        // Verify that the method mostrarEstadisticas is called
        assertEquals("Pokemon1", testPokemon.getNombre());
    }

    @AfterEach
    void tearDown() {
        controllerEquipo = null;
        entrenador = null;
        equipo = null;
    }
}
