//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.loginui.Lessons;

import com.example.loginui.Questions.Questions;


public class Lesson {
    public static Questions questions;
    private int LessonProgress = 0;
    public int LessonSize=10;

    public Lesson() {
        this.questions = new Questions();
    }

    public static String getCurrentQuestion() {
        questions.chooseQuestion();
        return questions.getQuestion();
    }

    public boolean submitAnswer(String answer) {
        questions.answer.setAnswer(answer);
        boolean isCorrect = questions.isCorrect();

        if (isCorrect) {
            LessonProgress++;
        }

        return isCorrect;
    }

    public int getLessonProgress() {
        return LessonProgress;
    }

    public boolean isLessonComplete() {
        return LessonProgress >= LessonSize;
    }
    public String getQuestion() {
        return questions.getQuestion();
    }
}
