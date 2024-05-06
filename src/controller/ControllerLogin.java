package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Entrenador;
import bbd.BD;
import bbd.LoginBD;

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
    
    private LoginBD login = new LoginBD(BD.getConnetion());
    
    // No necesitas crear una nueva instancia de bbd aquí
    // Puedes llamar al método conexionBbd() directamente

    @FXML
    void iniciar() {
        String username = user1.getText();
        String password = passw.getCharacters().toString();

        boolean credentialsCorrect = login.checkCredentials(username, password);

        if (credentialsCorrect) {
            loadNextScene();
        } else {
            showAlert("Credenciales incorrectas", "El nombre de entrenador o la contraseña son incorrectos.");
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

        boolean registrationSuccessful = login.registerUser(newUsername, newPassword);

        if (registrationSuccessful) {
            showAlert("Registro exitoso", "Usuario registrado correctamente.");
        } else {
            showAlert("Error en el registro", "No se te pudo registrar como usuario. Inténtalo de nuevo más tarde.");
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
