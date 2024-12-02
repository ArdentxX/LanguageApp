import CorrectOrIncorrect.Answer;
import Questions.Questions;

public class Main {
    public static void main(String[] args) {
        Questions questionHandler = new Questions();
        String filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\Questions.json";
        String randomQuestion = questionHandler.chooseQuestion(filePath);
        System.out.println(randomQuestion);
    }
}
