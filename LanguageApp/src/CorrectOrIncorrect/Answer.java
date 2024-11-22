package CorrectOrIncorrect;

import Questions.Questions;

public class Answer extends Questions {
    protected String getanswers;
    protected int Points;

    public Answer(String getanswers, String correctanswer) {
        super(correctanswer);
        this.getanswers = getanswers;
    }
    public void setAnswer(String getanswers) {
        this.getanswers = getanswers;
    }
    public String getAnswer() {
        return getanswers;
    }
    public String isCorrect() {
        if (correctanswer.replaceAll("\\s", "").equalsIgnoreCase(getanswers.replaceAll("\\s", ""))) {
            Points++;
            return "Correct";
        }
        return "Incorrect";
    }

}
