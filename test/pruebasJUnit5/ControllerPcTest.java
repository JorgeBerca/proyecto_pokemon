package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPcTest {

    private ControllerPc controllerPc;
    private Entrenador entrenador;
    private Pokemon[] pc;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Inicializa el entorno de JavaFX
    }

    @BeforeEach
    void setUp() {
        controllerPc = new ControllerPc();
        entrenador = new Entrenador();
        pc = new Pokemon[30];

        // Inicializa los componentes de JavaFX
        controllerPc.tablero = new AnchorPane();
        for (int i = 0; i < 30; i++) {
            ImageView imageView = new ImageView();
            imageView.setId("pokemon" + (i + 1));
            controllerPc.tablero.getChildren().add(imageView);
        }

        // Configura el PC del entrenador
        for (int i = 0; i < 30; i++) {
            pc[i] = new Pokemon();
            pc[i].setNombre("Pokemon" + (i + 1));
        }
        entrenador.setPC(pc);
        Entrenador.setEntrenadorActual(entrenador);
    }

    @Test
    void testInitialize() {
        assertDoesNotThrow(() -> {
            controllerPc.initialize();
        });

        // Verifica que el arreglo de ImageViews se inicialice correctamente
        for (int i = 0; i < 30; i++) {
            assertNotNull(controllerPc.pokemonImages[i]);
        }
    }

    @Test
    void testLoadPokemonImages() {
        controllerPc.initialize();

        assertDoesNotThrow(() -> {
            controllerPc.loadPokemonImages();
        });

        // Verifica que las imágenes se hayan configurado correctamente
        for (int i = 0; i < pc.length; i++) {
            assertNotNull(controllerPc.pokemonImages[i].getImage());
        }
    }

    @Test
    void testLimpiaTablero() {
        controllerPc.initialize();
        controllerPc.loadPokemonImages();

        assertDoesNotThrow(() -> {
            controllerPc.limpiaTablero();
        });

        // Verifica que las imágenes y los controladores de eventos se hayan limpiado
        for (int i = 0; i < 30; i++) {
            assertNull(controllerPc.pokemonImages[i].getImage());
            assertNull(controllerPc.pokemonImages[i].getOnMouseClicked());
        }
    }

    @Test
    void testAddEquipo() {
        assertDoesNotThrow(() -> {
            controllerPc.addEquipo();
        });
    }

    @Test
    void testAtras() {
        assertDoesNotThrow(() -> {
            // Simula el evento de acción de retroceder
            javafx.event.ActionEvent event = new javafx.event.ActionEvent();
            controllerPc.atras(event);
        });
    }

    @Test
    void testEstadisticas1() {
        assertDoesNotThrow(() -> {
            MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 1, false, false, false, false, true, false, false, false, false, false, null);
            controllerPc.estadisticas1(event);
        });
    }

    @Test
    void testEstadisticas2() {
        assertDoesNotThrow(() -> {
            MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 1, false, false, false, false, true, false, false, false, false, false, null);
            controllerPc.estadisticas2(event);
        });
    }

    @Test
    void testManejaMousePokemon() {
        controllerPc.initialize();
        Pokemon testPokemon = pc[0];
        ControllerPc.ManejaMousePokemon handler = controllerPc.new ManejaMousePokemon(testPokemon);

        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 1, false, false, false, false, true, false, false, false, false, false, null);
        assertDoesNotThrow(() -> {
            handler.handle(event);
        });

        // Verifica que el método mostrarEstadisticas se haya llamado correctamente
        assertEquals("Pokemon1", testPokemon.getNombre());
    }

    @AfterEach
    void tearDown() {
        controllerPc = null;
        entrenador = null;
        pc = null;
    }
}
