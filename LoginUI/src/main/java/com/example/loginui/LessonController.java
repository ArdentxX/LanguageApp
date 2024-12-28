package com.example.loginui;

import com.example.loginui.Units.Unit;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    private Unit unit;

    public LessonController() {
        this.unit = new Unit();
    }

    @FXML
    public void initialize() {
        showNextQuestion();
    }

    @FXML
    public void handleSubmitAnswer() {
        String answer = answerTextField.getText();
        boolean isCorrect = unit.submitAnswer(answer);

        if (isCorrect) {
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect! Try again.");
        }

        answerTextField.clear();

        if (unit.isUnitComplete()) {
            questionLabel.setText("Unit Complete! Final Score: " + unit.getFinalResult() + "%");
            submitAnswerButton.setDisable(true);
            answerTextField.setDisable(true);
        } else {
            showNextQuestion();
        }
    }

    private void showNextQuestion() {
        questionLabel.setText(unit.getCurrentQuestion());
    }
}

