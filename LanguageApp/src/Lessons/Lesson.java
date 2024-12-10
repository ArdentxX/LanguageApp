package Lessons;

import Questions.Questions;
import java.util.Scanner;
import java.util.ArrayList;

public class Lesson {
    public Questions questions;

    public Lesson() {
        this.questions = new Questions();
    }

    public void MakeLesson() {
        int Vocabulary = 0;
        int Grammar = 0;
        int Result= 0;
        int MisSolve = 0;
        ArrayList<Questions> questionsList = new ArrayList<Questions>();
        String Answer = "";
        Scanner sc = new Scanner(System.in);
        while (Vocabulary + Grammar < 2) {
            questions.chooseQuestion();
            if (questions.getType().equals("choice")) {
                System.out.print(questions.getQuestion() + "\n" + questions.getOptions());
                System.out.println("\nPodaj Odpowiedz: ");
                Answer = sc.nextLine();
                questions.answer.setAnswer(Answer);
                Grammar++;
            } else {
                System.out.print(questions.getQuestion());
                System.out.println("\nPodaj Odpowiedz: ");
                Answer = sc.nextLine();
                questions.answer.setAnswer(Answer);
                Vocabulary++;
            }
            if(questions.isCorrect().equals("Correct")){
                Result++;
            }
            else{
                System.out.print(questions.isCorrect());
                questionsList.add(new Questions(questions));
            }
        }
        while(MisSolve < questionsList.size()){

        }
        System.out.println("\nResult: " + (100*Result)/(Vocabulary + Grammar)+"%");
    }
}
