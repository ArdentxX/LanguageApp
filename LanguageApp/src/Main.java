import CorrectOrIncorrect.Answer;
import Questions.Questions;

public class Main {
    public static void main(String[] args) {
        Questions questionHandler = new Questions();
        String randomQuestion = questionHandler.chooseQuestion();
        System.out.println(randomQuestion);
        questionHandler.answer.setAnswer("goodmorning");
        System.out.println("User Answer: " + questionHandler.answer.getAnswer());
        System.out.println(questionHandler.isCorrect());
        String randomQuestion2 = questionHandler.chooseQuestion();
        System.out.println(randomQuestion2);
        questionHandler.answer.setAnswer("goodmorning");
        System.out.println("User Answer: " + questionHandler.answer.getAnswer());
        System.out.println(questionHandler.isCorrect());

    }
}