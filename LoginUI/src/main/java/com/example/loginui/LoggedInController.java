package com.example.loginui;

import com.example.loginui.Lessons.Lesson;
import com.example.loginui.Questions.Questions;
import com.example.loginui.User.Login;
import com.example.loginui.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @FXML
    Button ENGStartbutton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML



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
    @FXML
    private void onKRStartbutton() {
        closeCurrentWindow();
        loadFXMLWindow("LessonUiKR.fxml", "Lekcja Koreańskiego");
    }

    @FXML
    private void onENGStartbutton() {
        closeCurrentWindow();
        loadFXMLWindow("LessonUi.fxml", "Lekcja Angielskiego");
    }

    private void closeCurrentWindow() {
        // Pobierz bieżące okno i zamknij je
        Stage stage = (Stage) ENGStartbutton.getScene().getWindow();
        stage.close();
    }

    private void loadFXMLWindow(String fxmlFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
