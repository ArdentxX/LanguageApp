package com.example.loginui;

import com.example.loginui.Units.Unit;
import com.example.loginui.User.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LessonController {
    @FXML
    private Label questionLabel;
    @FXML
    private TextField answerTextField;
    @FXML
    private Button submitAnswerButton;
    @FXML
    private Label feedbackLabel;
    @FXML
    private Label progressLabel;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button endLessonButton;

    private Unit unit;
    private double progress = 0;

    public LessonController() {
        this.unit = new Unit();
    }

    @FXML
    public void initialize() {
        if (endLessonButton != null) {
            endLessonButton.setVisible(false);
            endLessonButton.setManaged(false);
        }
        showNextQuestion();
    }

    @FXML
    public void handleSubmitAnswer() {
        String answer = answerTextField.getText();
        boolean isCorrect = unit.submitAnswer(answer);
        if (isCorrect) {
            progress += 1;
            progressBar.setProgress(progress / 6);
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect! Try again.");
        }

        answerTextField.clear();

        if (unit.isUnitComplete()) {
            questionLabel.setText("Lesson Complete! Final Score: " + unit.getFinalResult() + "%");
            submitAnswerButton.setDisable(true);
            answerTextField.setDisable(true);
            endLessonButton.setVisible(true);
            endLessonButton.setManaged(true);
        } else {
            showNextQuestion();
        }
    }

    private void showNextQuestion() {
        questionLabel.setText(unit.getCurrentQuestion());
    }

    public void onContinue(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loggedIn.fxml"));
        Parent root = loader.load();

        LoggedInController loggedInController = loader.getController();

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}


