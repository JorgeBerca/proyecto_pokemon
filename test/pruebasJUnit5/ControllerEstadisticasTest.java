package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Entrenador;
import modelo.Pokemon;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEstadisticasTest {

    private ControllerEstadisticas controllerEstadisticas;
    private Pokemon pokemon;
    private Entrenador entrenador;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerEstadisticas = new ControllerEstadisticas();
        entrenador = new Entrenador();
        pokemon = new Pokemon();

        // Initialize JavaFX components
        controllerEstadisticas.box = new VBox();
        controllerEstadisticas.nombre = new Label();
        controllerEstadisticas.mote = new Label();
        controllerEstadisticas.nivel = new Label();
        controllerEstadisticas.vida = new Label();
        controllerEstadisticas.ataque = new Label();
        controllerEstadisticas.defensa = new Label();
        controllerEstadisticas.velocidad = new Label();
        controllerEstadisticas.atEspecial = new Label();
        controllerEstadisticas.deEspecial = new Label();
        controllerEstadisticas.sexo = new Label();

        // Set up the Pokémon details
        pokemon.setNombre("Pikachu");
        pokemon.setMote("Sparky");
        pokemon.setNivel(10);
        pokemon.setSalud(35);
        pokemon.setAtaque(55);
        pokemon.setDefensa(40);
        pokemon.setVelocidad(90);
        pokemon.setAtEspecial(50);
        pokemon.setDefEspecial(50);
        pokemon.setSexo("M");

        entrenador.setEquipo(new Pokemon[]{pokemon});
        Entrenador.setEntrenadorActual(entrenador);
    }

    @Test
    void testInitialize() {
        assertDoesNotThrow(() -> {
            controllerEstadisticas.initialize();
        });
    }

    @Test
    void testInitializeAttributes() {
        assertDoesNotThrow(() -> {
            controllerEstadisticas.initializeAttributes(pokemon);
        });

        // Verify the Pokémon details are set correctly
        assertEquals("Pikachu", controllerEstadisticas.nombre.getText());
        assertEquals("Sparky", controllerEstadisticas.mote.getText());
        assertEquals("10", controllerEstadisticas.nivel.getText());
        assertEquals("35", controllerEstadisticas.vida.getText());
        assertEquals("55", controllerEstadisticas.ataque.getText());
        assertEquals("40", controllerEstadisticas.defensa.getText());
        assertEquals("90", controllerEstadisticas.velocidad.getText());
        assertEquals("50", controllerEstadisticas.atEspecial.getText());
        assertEquals("50", controllerEstadisticas.deEspecial.getText());
        assertEquals("M", controllerEstadisticas.sexo.getText());
    }

    @Test
    void testCerrar() {
        Stage stage = new Stage();
        controllerEstadisticas.box = new VBox();
        controllerEstadisticas.box.setScene(new javafx.scene.Scene(new javafx.scene.Group()));
        stage.setScene(controllerEstadisticas.box.getScene());

        assertDoesNotThrow(() -> {
            controllerEstadisticas.cerrar();
        });

        assertFalse(stage.isShowing());
    }

    @Test
    void testAddEquipo() {
        assertDoesNotThrow(() -> {
            controllerEstadisticas.initializeAttributes(pokemon);
            controllerEstadisticas.addEquipo();
        });

        // Verify that the Pokémon has been switched
        assertTrue(Entrenador.getEntrenadorActual().getEquipo().length > 0);
    }

    @Test
    void testVender() {
        assertDoesNotThrow(() -> {
            controllerEstadisticas.initializeAttributes(pokemon);
            controllerEstadisticas.vender();
        });

        // Verify that the Pokémon has been sold
        assertEquals(0, entrenador.getEquipo().length);
    }

    @Test
    void testLiberar() {
        assertDoesNotThrow(() -> {
            controllerEstadisticas.initializeAttributes(pokemon);
            controllerEstadisticas.liberar();
        });

        // Verify that the Pokémon has been released
        assertEquals(0, entrenador.getEquipo().length);
    }

    @Test
    void testActualizaDatos() {
        controllerEstadisticas.pokemon = pokemon;

        assertDoesNotThrow(() -> {
            controllerEstadisticas.actualizaDatos();
        });

        // Verify the Pokémon details are updated correctly
        assertEquals("Pikachu", controllerEstadisticas.nombre.getText());
        assertEquals("Sparky", controllerEstadisticas.mote.getText());
        assertEquals("10", controllerEstadisticas.nivel.getText());
        assertEquals("35", controllerEstadisticas.vida.getText());
        assertEquals("55", controllerEstadisticas.ataque.getText());
        assertEquals("40", controllerEstadisticas.defensa.getText());
        assertEquals("90", controllerEstadisticas.velocidad.getText());
        assertEquals("50", controllerEstadisticas.atEspecial.getText());
        assertEquals("50", controllerEstadisticas.deEspecial.getText());
        assertEquals("M", controllerEstadisticas.sexo.getText());
    }

    @AfterEach
    void tearDown() {
        controllerEstadisticas = null;
        pokemon = null;
        entrenador = null;
    }
}
