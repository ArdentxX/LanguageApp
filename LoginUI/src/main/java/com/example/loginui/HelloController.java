package com.example.loginui;

import com.example.loginui.User.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField currentUserTextField;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField hasloTextField;
    //utworzenie obiektu klasy login
    Login login= new Login();
    @FXML
    private Label welcomeText;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML


    //logowanie
    public void onZalogujButton(ActionEvent actionEvent) throws IOException {
        String username = loginTextField.getText();
        String password = hasloTextField.getText();

        if (login.loginUser(username, password) >= 0) {
            // Załaduj scenę tylko raz
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loggedIn.fxml"));
            Parent root = loader.load(); // Ładowanie FXML

            // Pobierz kontroler i przekaż obiekt użytkownika
            LoggedInController loggedInController = loader.getController();
            loggedInController.displayInfo(login.getCurrentUser());

            // Zmień scenę
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    //rejestracja
    public void onRejestrujButton(ActionEvent actionEvent) {
        String username=(loginTextField.getText());
        String password=(hasloTextField.getText());
        login.registerUser(username,password);
    }
}