package com.example.loginui;

import com.example.loginui.User.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    @FXML
    void refresh(){
        currentUserTextField.setText((login.showCurrentUserInfo()));
    }
    //logowanie
    public void onZalogujButton(ActionEvent actionEvent) {
        String username=(loginTextField.getText());
        String password=(hasloTextField.getText());
        if(login.loginUser(username,password)>=0){
            refresh();
        }
    }
    //rejestracja
    public void onRejestrujButton(ActionEvent actionEvent) {
        String username=(loginTextField.getText());
        String password=(hasloTextField.getText());
        login.registerUser(username,password);
    }
}