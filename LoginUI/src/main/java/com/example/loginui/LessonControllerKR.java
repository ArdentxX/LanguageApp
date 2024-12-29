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
import java.util.EventObject;

public class LessonControllerKR {
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
    private Stage stage;
    private Scene scene;

    public LessonControllerKR() {
        this.lesson = new Lesson();

    }

    @FXML
    public void initialize() {
        if (endLessonButton != null) {
            endLessonButton.setVisible(false);
            endLessonButton.setManaged(false);
        }
        lesson.questions.setLanguage("KR");
        showNextQuestion();

    }

    @FXML
    public void handleSubmitAnswer() {
        String answer = answerTextField.getText();
        boolean isCorrect = lesson.submitAnswer(answer);
        if (isCorrect) {
            progress += 1;
            progressBar.setProgress(progress / lesson.LessonSize);
            feedbackLabel.setText("Dobrze!");
        } else {
            feedbackLabel.setText("ŹLE! Dobra Odpowiedź: "+ lesson.questions.getCorrectanswer() );
        }

        answerTextField.clear();

        if (lesson.isLessonComplete()) {
            questionLabel.setText("Lesson Complete!");
            submitAnswerButton.setDisable(true);
            answerTextField.setDisable(true);
            endLessonButton.setVisible(true);
            endLessonButton.setManaged(true);
            LessonQuestions.clear();
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
        Parent root = FXMLLoader.load(getClass().getResource("loggedIn.fxml"));
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

