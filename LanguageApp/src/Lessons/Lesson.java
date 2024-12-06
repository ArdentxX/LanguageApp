package Lessons;

import Questions.Questions;
import java.util.Scanner;

public class Lesson {
    public Questions questions;

    public Lesson() {
        this.questions = new Questions();
    }

    public void MakeLesson() {
        int Vocabulary = 0;
        int Grammar = 0;
        int Result=0;
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
            }
        }
        System.out.println("\nResult: " + Result/(Vocabulary + Grammar)*100+"%");
    }
}
