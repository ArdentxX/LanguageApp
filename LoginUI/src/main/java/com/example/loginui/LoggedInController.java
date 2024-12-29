package com.example.loginui;

import com.example.loginui.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoggedInController extends HelloController {
    @FXML
    public Label usernameLabel;
    @FXML
    public Label lessonsEngLabel;
    @FXML
    public Label percentageEngLabel;
    @FXML
    public Label lessonsKorLabel;
    @FXML
    public Label percentageKorLabel;
    @FXML
    Button ENGStartbutton;
    @FXML
    Button KRStartbutton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private User currentUser;

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayInfo(User currentUser) {
        usernameLabel.setText(currentUser.getUsername());
        lessonsEngLabel.setText(String.valueOf(currentUser.getEnglishUnitCount()));
        lessonsKorLabel.setText(String.valueOf(currentUser.getKoreanUnitCount()));
        percentageEngLabel.setText(String.valueOf(currentUser.getCorrectEnglishAnswer()));
        percentageKorLabel.setText(String.valueOf(currentUser.getCorrectKoreanAnswer()));
        this.currentUser = currentUser;
    }

    @FXML
    public void onWylogujButton(ActionEvent actionEvent) throws IOException {
        switchToLogin(actionEvent);
    }

    @FXML
    private void onKRStartbutton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LessonUiKR.fxml"));
            Parent root = loader.load();
            LessonControllerKR lessonController = loader.getController();

            lessonController.setUser(currentUser);

            closeCurrentWindow();
            Stage stage = new Stage();
            stage.setTitle("Lekcja Koreańskiego");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onENGStartbutton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LessonUi.fxml"));
            Parent root = loader.load();
            LessonController lessonController = loader.getController();

            lessonController.setUser(currentUser);

            closeCurrentWindow();
            Stage stage = new Stage();
            stage.setTitle("Lekcja Angielskiego");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeCurrentWindow() {
        Stage stage = (Stage) ENGStartbutton.getScene().getWindow();
        stage.close();
    }

    public void setUser(User user) {
        this.currentUser = user;
        usernameLabel.setText(user.getUsername());
        lessonsEngLabel.setText(String.valueOf(user.getEnglishUnitCount()));
        lessonsKorLabel.setText(String.valueOf(user.getKoreanUnitCount()));

        if (user.getCorrectEnglishAnswer() == 0 && user.getIncorrectEnglishAnswer() == 0) {
            percentageEngLabel.setText("0");
        } else {
            percentageEngLabel.setText(String.valueOf(user.getCorrectEnglishAnswer() / (user.getCorrectEnglishAnswer() + user.getIncorrectEnglishAnswer())));
        }

        if (user.getCorrectKoreanAnswer() == 0 && user.getIncorrectKoreanAnswer() == 0) {
            percentageKorLabel.setText("0");
        } else {
            percentageKorLabel.setText(String.valueOf(user.getCorrectKoreanAnswer() / (user.getIncorrectKoreanAnswer() + user.getCorrectKoreanAnswer())));
        }
    }

    public User getUser() {
        return currentUser;
    }

    public String getUsername() {
        return currentUser.getUsername();
    }

    public int getEnglishUnitCount() {
        return currentUser.getEnglishUnitCount();
    }

    public int getKoreanUnitCount() {
        return currentUser.getKoreanUnitCount();
    }

    public double getCorrectEnglishAnswer() {
        return currentUser.getCorrectEnglishAnswer();
    }

    public double getCorrectKoreanAnswer() {
        return currentUser.getCorrectKoreanAnswer();
    }

    public double getIncorrectEnglishAnswer() {
        return currentUser.getIncorrectEnglishAnswer();
    }

    public double getIncorrectKoreanAnswer() {
        return currentUser.getIncorrectKoreanAnswer();
    }
}
