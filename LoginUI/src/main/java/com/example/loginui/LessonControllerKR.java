package com.example.loginui;

import com.example.loginui.Lessons.Lesson;
import com.example.loginui.Questions.Questions;
import com.example.loginui.User.User;
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
    private User user;
    public int KRCount;
    public double Correct;
    public double InCorrect;
    public int CorrectCount;
    public int IncorrectCount;

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
    public void setUser(User currentUser) {
        this.user = currentUser;
    }

    @FXML
    public void handleSubmitAnswer() {
        String answer = answerTextField.getText();
        boolean isCorrect = lesson.submitAnswer(answer);
        if (isCorrect) {
            progress += 1;
            progressBar.setProgress(progress / lesson.LessonSize);
            feedbackLabel.setText("Dobrze!");
            this.Correct = user.getCorrectKoreanAnswer()+1;
            user.setCorrectKoreanAnswer(Correct);
            CorrectCount +=1;
        } else {
            feedbackLabel.setText("ŹLE! Dobra Odpowiedź: "+ lesson.questions.getCorrectanswer() );
            this.InCorrect=user.getIncorrectKoreanAnswer()+1;
            user.setIncorrectKoreanAnswer(InCorrect);
            IncorrectCount +=1;
        }

        answerTextField.clear();

        if (lesson.isLessonComplete()) {
            questionLabel.setText("Lesson Complete!");
            submitAnswerButton.setDisable(true);
            answerTextField.setDisable(true);
            endLessonButton.setVisible(true);
            endLessonButton.setManaged(true);
            LessonQuestions.clear();
            this.KRCount = user.getKoreanUnitCount()+1;
            user.setKoreanUnitCount(KRCount);
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
        user.setIncorrectKoreanAnswer(user.getIncorrectKoreanAnswer()-IncorrectCount);
        user.setCorrectKoreanAnswer(user.getCorrectKoreanAnswer()-CorrectCount);

        // Pobranie kontrolera i przekazanie użytkownika
        LoggedInController controller = loader.getController();
        controller.setUser(user);

        // Ustawienie sceny i pokazanie nowego okna
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stats");
        stage.setScene(scene);
        stage.show();
    }

    public void onContinue2(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loggedIn.fxml"));
        Parent root = loader.load();

        // Pobranie kontrolera i przekazanie użytkownika
        LoggedInController controller = loader.getController();
        controller.setUser(user);

        // Ustawienie sceny i pokazanie nowego okna
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stats");
        stage.setScene(scene);
        stage.show();
    }
}

