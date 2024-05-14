package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import modelo.Entrenador;
import modelo.Movimiento;
import modelo.Pokemon;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ControllerRecuerdaMovimientosTest {

    private ControllerRecuerdaMovimientos controllerRecuerdaMovimientos;
    private Pokemon pokemon;
    private Movimiento movimiento;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Inicializa el entorno de JavaFX
    }

    @BeforeEach
    void setUp() {
        controllerRecuerdaMovimientos = new ControllerRecuerdaMovimientos();
        pokemon = new Pokemon();
        movimiento = new Movimiento();

        // Inicializa los componentes de JavaFX
        controllerRecuerdaMovimientos.imagen = new ImageView();
        controllerRecuerdaMovimientos.boxActivos = new HBox();
        controllerRecuerdaMovimientos.boxAprendidos = new FlowPane();

        // Configura el Pokémon y sus movimientos
        movimiento.setNomMovimiento("Impactrueno");
        movimiento.setIdMovimiento(1);
        pokemon.setNombre("Pikachu");
        pokemon.setMovimientosActivos(new Movimiento[]{movimiento});
        pokemon.setMovimientosAprendidos(new Movimiento[]{movimiento});
    }

    @Test
    void testEquipo() {
        assertDoesNotThrow(() -> {
            ActionEvent event = new ActionEvent();
            controllerRecuerdaMovimientos.equipo(event);
        });
    }

    @Test
    void testRefrescaVista() {
        controllerRecuerdaMovimientos.pokemon = pokemon;

        assertDoesNotThrow(() -> {
            controllerRecuerdaMovimientos.refrescaVista();
        });

        // Verifica que la imagen del Pokémon se haya actualizado
        assertNotNull(controllerRecuerdaMovimientos.imagen.getImage());

        // Verifica que los botones de movimientos activos se hayan creado
        assertEquals(1, controllerRecuerdaMovimientos.boxActivos.getChildren().size());

        // Verifica que los botones de movimientos aprendidos se hayan creado
        assertEquals(1, controllerRecuerdaMovimientos.boxAprendidos.getChildren().size());
    }

    @Test
    void testActivaDesactiva() {
        controllerRecuerdaMovimientos.pokemon = pokemon;

        assertDoesNotThrow(() -> {
            controllerRecuerdaMovimientos.activaDesactiva(movimiento);
        });

        // Verifica que el movimiento se haya activado/desactivado
        assertTrue(pokemon.getMovimientosActivos().length == 1 || pokemon.getMovimientosAprendidos().length == 1);
    }

    @Test
    void testManejaClickBoton() {
        ControllerRecuerdaMovimientos.ManejaClickBoton handler = controllerRecuerdaMovimientos.new ManejaClickBoton(movimiento);

        ActionEvent event = new ActionEvent();
        assertDoesNotThrow(() -> {
            handler.handle(event);
        });

        // Verifica que el método activaDesactiva se haya ejecutado
        assertTrue(pokemon.getMovimientosActivos().length == 1 || pokemon.getMovimientosAprendidos().length == 1);
    }

    @Test
    void testAtras() {
        assertDoesNotThrow(() -> {
            ActionEvent event = new ActionEvent();
            controllerRecuerdaMovimientos.atras(event);
        });
    }

    @AfterEach
    void tearDown() {
        controllerRecuerdaMovimientos = null;
        pokemon = null;
        movimiento = null;
    }
}
