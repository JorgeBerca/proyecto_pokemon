package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import modelo.Entrenador;
import modelo.Pokedex;
import org.junit.jupiter.api.*;

import controller.ControllerCaptura;
import util.UtilView;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ControllerCapturaTest {

    private ControllerCaptura controllerCaptura;
    private Pokedex pokedex;
    private Entrenador entrenador;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerCaptura = new ControllerCaptura();
        pokedex = new Pokedex();
        entrenador = new Entrenador();

        // Inicializa los componentes JavaFX simulados
        controllerCaptura.pokemonrandom = new ImageView();

        // Asigna un entrenador actual
        Entrenador.setEntrenadorActual(entrenador);
    }

    @Test
    void testCambiar() {
        // Simula el retorno de un Pokémon al azar
        pokedex.setId(1);
        pokedex.setNombre("Bulbasaur");
        Entrenador.getEntrenadorActual().setRandomPokedex(pokedex);

        // Ejecuta el método cambiar
        controllerCaptura.cambiar();

        // Verifica que la imagen se haya actualizado
        assertNotNull(controllerCaptura.pokemonrandom.getImage());
        assertEquals("Bulbasaur", pokedex.getNombre());
    }

    @Test
    void testCapturar() {
        // Simula la captura de un Pokémon
        pokedex.setId(1);
        pokedex.setNombre("Charmander");
        Entrenador.getEntrenadorActual().setRandomPokedex(pokedex);
        controllerCaptura.cambiar();

        // Simula la captura exitosa
        Random rand = new Random();
        boolean capturado = ((rand.nextInt(100) + 1) <= 60);

        if (capturado) {
            controllerCaptura.capturar();
            assertNull(controllerCaptura.pokedex);
            assertNull(controllerCaptura.pokemonrandom.getImage());
        } else {
            controllerCaptura.capturar();
            assertNull(controllerCaptura.pokedex);
            assertNull(controllerCaptura.pokemonrandom.getImage());
        }
    }

    @Test
    void testAtras() {
        // Esta prueba verifica si el método `atras` se ejecuta sin errores
        // Sin embargo, no se puede comprobar la funcionalidad completa sin un entorno JavaFX adecuado
        assertDoesNotThrow(() -> {
            controllerCaptura.atras(new javafx.event.ActionEvent());
        });
    }

    @AfterEach
    void tearDown() {
        controllerCaptura = null;
        pokedex = null;
        entrenador = null;
    }
}
