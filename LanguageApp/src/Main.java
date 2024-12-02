import CorrectOrIncorrect.Answer;
import Questions.Questions;

public class Main {
    public static void main(String[] args) {
        Questions questionHandler = new Questions();
        String filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\Questions.json";
        String randomQuestion = questionHandler.chooseQuestion(filePath);
        System.out.println(randomQuestion);
        System.out.println("Correct Answer: " + questionHandler.correctanswer);
        questionHandler.answer.setAnswer("zat");
        System.out.println("User Answer: " + questionHandler.answer.getAnswer());
        System.out.println(questionHandler.isCorrect());

    }
}