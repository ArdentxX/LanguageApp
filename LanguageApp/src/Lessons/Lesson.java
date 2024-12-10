package Lessons;

import Questions.Questions;
import java.util.Scanner;
import java.util.ArrayList;

public class Lesson {
    public Questions questions;
    public int Result;

    public Lesson() {
        this.questions = new Questions();
        this.Result = 0;
    }

    public void MakeLesson() {
        int Vocabulary = 0;
        int Grammar = 0;
        int LocRes= 0;
        int MisSolve = 0;
        ArrayList<String> questionsList = new ArrayList<>();
        ArrayList<Questions> mistakeList = new ArrayList<Questions>();
        String Answer = "";
        Scanner sc = new Scanner(System.in);
        while (Vocabulary + Grammar < 10) {
                questions.chooseQuestion();
                String questionCheck = questions.getQuestion();
                if(questionsList.contains(questionCheck)) {
                    continue;
                }

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
            if(questions.isCorrect()){
                LocRes++;
                System.out.println("Correct");
            }
            else{
                System.out.print("Incorrect" +"\n"+"Correct Answer: " + questions.correctanswer+"\n");
                mistakeList.add(new Questions(questions));
            }
            questionsList.add(questions.getQuestion());
        }
        //while(MisSolve < mistakeList.size()){


        //}
        int FinalResult = (100*LocRes)/(Vocabulary + Grammar);
        System.out.println("\nResult: " + FinalResult +"%");
        this.Result =FinalResult;
        questionsList.clear();
    }
}
