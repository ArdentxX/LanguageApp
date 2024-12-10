package CorrectOrIncorrect;
public class Answer {
    protected String getanswers;
    public Answer() {}
    public Answer(Answer original) {
        this.getanswers = original.getanswers;

    }
    public void setAnswer(String getanswers) {
        this.getanswers = getanswers;
    }
    public String getAnswer() {
        return getanswers;
    }
}
