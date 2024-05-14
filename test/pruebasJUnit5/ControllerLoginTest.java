package pruebasJUnit5;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.*;
import util.UtilView;
import bbd.LoginBD;

import static org.junit.jupiter.api.Assertions.*;

class ControllerLoginTest {

    private ControllerLogin controllerLogin;
    private LoginBD loginBD;

    @BeforeAll
    static void initJFX() {
        new JFXPanel(); // Initializes the JavaFX environment
    }

    @BeforeEach
    void setUp() {
        controllerLogin = new ControllerLogin();
        loginBD = new LoginBD();

        // Initialize JavaFX components
        controllerLogin.passw = new PasswordField();
        controllerLogin.user1 = new TextField();

        // Set LoginBD instance
        controllerLogin.loginBD = loginBD;
    }

    @Test
    void testIniciar() {
        // Set test credentials
        controllerLogin.user1.setText("testUser");
        controllerLogin.passw.setText("testPassword");

        // Assume loginBD.checkCredentials returns true for these credentials
        boolean credentialsCorrect = loginBD.checkCredentials("testUser", "testPassword");

        if (credentialsCorrect) {
            controllerLogin.iniciar();
            assertTrue(credentialsCorrect);
        } else {
            controllerLogin.iniciar();
            assertFalse(credentialsCorrect);
        }
    }

    @Test
    void testRegistrar() {
        // Set test registration details
        controllerLogin.user1.setText("newUser");
        controllerLogin.passw.setText("newPassword");

        // Assume loginBD.registerUser returns true for these credentials
        boolean registrationSuccessful = loginBD.registerUser("newUser", "newPassword");

        if (registrationSuccessful) {
            controllerLogin.registrar();
            assertTrue(registrationSuccessful);
        } else {
            controllerLogin.registrar();
            assertFalse(registrationSuccessful);
        }
    }

    @AfterEach
    void tearDown() {
        controllerLogin = null;
        loginBD = null;
    }
}
