package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
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

class ControllerElegirEquipoTest {

    private ControllerElegirEquipo controllerElegirEquipo;
    private Pokemon[] lista;
    private Pokemon[] equipo;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerElegirEquipo = new ControllerElegirEquipo();
        lista = new Pokemon[1];
        equipo = new Pokemon[3];

        // Initialize JavaFX components
        controllerElegirEquipo.selector = new AnchorPane();

        // Mock the entrenador's team
        Entrenador entrenador = new Entrenador();
        equipo[0] = new Pokemon(); // Create dummy Pokemon objects
        equipo[1] = new Pokemon();
        equipo[2] = new Pokemon();
        entrenador.setEquipo(equipo);
        Entrenador.setEntrenadorActual(entrenador);
    }

    @Test
    void testInitialize() {
        assertDoesNotThrow(() -> {
            controllerElegirEquipo.initialize();
        });
    }

    @Test
    void testMostrarEquipo() {
        // Mock some ImageViews in the selector
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView();
            controllerElegirEquipo.selector.getChildren().add(imageView);
        }

        assertDoesNotThrow(() -> {
            controllerElegirEquipo.mostrarEquipo();
        });

        // Verify that the ImageViews have been set with images
        for (Node node : controllerElegirEquipo.selector.getChildren()) {
            ImageView imageView = (ImageView) node;
            assertNotNull(imageView.getImage());
        }
    }

    @Test
    void testCerrar() {
        Stage stage = new Stage();
        controllerElegirEquipo.selector = new AnchorPane();
        controllerElegirEquipo.selector.setScene(new javafx.scene.Scene(new javafx.scene.Group()));
        stage.setScene(controllerElegirEquipo.selector.getScene());

        assertDoesNotThrow(() -> {
            controllerElegirEquipo.cerrar();
        });

        assertFalse(stage.isShowing());
    }

    @Test
    void testManejaMousePokemon() {
        controllerElegirEquipo.equipo = equipo;
        controllerElegirEquipo.lista = lista;

        ControllerElegirEquipo.ManejaMousePokemon handler = controllerElegirEquipo.new ManejaMousePokemon(0);

        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, null, 1, false, false, false, false, true, false, false, false, false, false, null);
        assertDoesNotThrow(() -> {
            handler.handle(event);
        });

        assertEquals(equipo[0], lista[0]);
    }

    @AfterEach
    void tearDown() {
        controllerElegirEquipo = null;
        lista = null;
        equipo = null;
    }
}
