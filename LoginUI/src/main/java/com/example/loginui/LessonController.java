package com.example.loginui;

import com.example.loginui.Lessons.Lesson;
import com.example.loginui.Questions.Questions;
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
import java.util.ArrayList;

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
    public ArrayList<String> LessonQuestions= new ArrayList<>();

    private Lesson lesson;
    private double progress = 0;

    public LessonController() {
        this.lesson = new Lesson();
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
        boolean isCorrect = lesson.submitAnswer(answer);
        if (isCorrect) {
            progress += 1;
            progressBar.setProgress(progress / lesson.LessonSize);
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect! Try again.");
        }

        answerTextField.clear();

        if (lesson.isLessonComplete()) {
            questionLabel.setText("Lesson Complete!");
            submitAnswerButton.setDisable(true);
            answerTextField.setDisable(true);
            endLessonButton.setVisible(true);
            endLessonButton.setManaged(true);
        } else {
            showNextQuestion();
        }
    }

    private void showNextQuestion() {
        String question;
        do {
            question = Lesson.getCurrentQuestion();
        } while (LessonQuestions.contains(question));

        questionLabel.setText(question);
        LessonQuestions.add(question);
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

}


