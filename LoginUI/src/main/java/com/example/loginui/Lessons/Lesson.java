//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.loginui.Lessons;

import com.example.loginui.Questions.Questions;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Lesson {
    public Questions questions = new Questions();
    public int Result = 0;

    public Lesson() {
    }

    public void MakeLesson() {
        int Vocabulary = 0;
        int Grammar = 0;
        int LocRes = 0;
        int MisSolve = 0;
        ArrayList<String> questionsList = new ArrayList();
        ArrayList<Questions> mistakeList = new ArrayList();
        String Answer = "";
        Scanner sc = new Scanner(System.in);

        while(Vocabulary + Grammar < 10) {
            this.questions.chooseQuestion();
            String questionCheck = this.questions.getQuestion();
            if (!questionsList.contains(questionCheck)) {
                if (this.questions.getType().equals("choice")) {
                    PrintStream var10000 = System.out;
                    String var10001 = this.questions.getQuestion();
                    var10000.print(var10001 + "\n" + String.valueOf(this.questions.getOptions()));
                    System.out.println("\nPodaj Odpowiedz: ");
                    Answer = sc.nextLine();
                    this.questions.answer.setAnswer(Answer);
                    ++Grammar;
                } else {
                    System.out.print(this.questions.getQuestion());
                    System.out.println("\nPodaj Odpowiedz: ");
                    Answer = sc.nextLine();
                    this.questions.answer.setAnswer(Answer);
                    ++Vocabulary;
                }

                if (this.questions.isCorrect()) {
                    ++LocRes;
                    System.out.println("Correct");
                } else {
                    System.out.print("Incorrect\nCorrect Answer: " + this.questions.correctanswer + "\n");
                    mistakeList.add(new Questions(this.questions));
                }

                questionsList.add(this.questions.getQuestion());
            }
        }

        int FinalResult = 100 * LocRes / (Vocabulary + Grammar);
        System.out.println("\nResult: " + FinalResult + "%");
        this.Result = FinalResult;
        questionsList.clear();
    }
}
