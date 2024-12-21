package com.example.loginui;

import com.example.loginui.User.Login;
import com.example.loginui.User.User;
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

public class LoggedInController extends HelloController {
    @FXML
    public TextField currentUserTextField;
    public Label lessonsEngLabel;
    public Label percentageEngLabel;
    public Label lessonsKorLabel;
    public Label percentageKorLabel;
    @FXML
    Label usernameLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void displayInfo(User currentUser) {
        usernameLabel.setText(currentUser.getUsername());
        lessonsEngLabel.setText(String.valueOf(currentUser.getEnglishUnitCount()));
        lessonsKorLabel.setText(String.valueOf(currentUser.getKoreanUnitCount()));
        percentageEngLabel.setText(String.valueOf(currentUser.getCorrectEnglishAnswerPercentage()));
        percentageKorLabel.setText(String.valueOf(currentUser.getCorrectKoreanAnswerPercentage()));
    }

    public void onWylogujButton(ActionEvent actionEvent) throws IOException {
        switchToLogin(actionEvent);
    }
}
