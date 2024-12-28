package com.example.loginui.Units;

import com.example.loginui.Lessons.Lesson;

public class Unit {
    private int unitProgress = 0;
    private final Lesson lesson;

    public Unit() {
        this.lesson = new Lesson();
    }

    public String getCurrentQuestion() {
        lesson.questions.chooseQuestion();
        return lesson.questions.getQuestion();
    }

    public boolean submitAnswer(String answer) {
        lesson.questions.answer.setAnswer(answer);
        boolean isCorrect = lesson.questions.isCorrect();

        if (isCorrect) {
            unitProgress++;
        }

        return isCorrect;
    }

    public int getUnitProgress() {
        return unitProgress;
    }

    public boolean isUnitComplete() {
        return unitProgress >= 6;
    }

    public int getFinalResult() {
        return lesson.Result;
    }
}
