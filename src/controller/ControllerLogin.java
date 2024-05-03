package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import bbd.bbd;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerLogin {

    private Stage currentStage;

    public void setCurrentStage(Stage stage) {
        this.currentStage = stage;
    }

    @FXML
    private PasswordField passw;

    @FXML
    private TextField user1;
    
    // No necesitas crear una nueva instancia de bbd aquí
    // Puedes llamar al método conexionBbd() directamente

    @FXML
    void iniciar() {
        String username = user1.getText();
        String password = passw.getCharacters().toString();

        boolean credentialsCorrect = checkCredentials(username, password);

        if (credentialsCorrect) {
            loadNextScene();
        } else {
            showAlert("Credenciales incorrectas", "El nombre de entrenador o la contraseña son incorrectos.");
        }
    }

    private boolean checkCredentials(String username, String password) {
        try (Connection connection = bbd.conexionBbd()) {
            String query = "SELECT * FROM ENTRENADOR WHERE NOM_ENTRENADOR = ? AND PASS = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    private void loadNextScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/menu_final.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) user1.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registrar() {
        String newUsername = user1.getText();
        String newPassword = passw.getCharacters().toString();

        boolean registrationSuccessful = registerUser(newUsername, newPassword);

        if (registrationSuccessful) {
            showAlert("Registro exitoso", "Usuario registrado correctamente.");
        } else {
            showAlert("Error en el registro", "No se te pudo registrar como usuario. Inténtalo de nuevo más tarde.");
        }
    }

    private boolean registerUser(String username, String password) {
        try (Connection connection = bbd.conexionBbd()) {
            String query = "INSERT INTO ENTRENADOR (NOM_ENTRENADOR, PASS) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}