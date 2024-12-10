import CorrectOrIncorrect.Answer;
import Lessons.Lesson;
import Questions.Questions;
import Units.Unit;

public class Main {
    public static void main(String[] args) {
        Unit unit1 = new Unit();
        unit1.lesson.questions.setLanguage("KR");
        System.out.println(unit1.lesson.questions.getLanguage());
        unit1.makeUnit();



    }
}