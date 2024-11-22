package Questions;
import java.util.Random;
import java.util.List;

public class Questions {
    protected String question;
    protected String correctanswer;
    protected int id;
    protected String type;
    protected List<String> options;
    protected String category;
    public Questions(String correctanswer) {
        this.correctanswer = correctanswer;
    }
    public String chooseQuestion() {
        Random rand = new Random();
        return "ws";

    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getCorrectanswer() {
        return correctanswer;
    }
    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<String> getOptions() {
        return options;
    }
    public void setOptions(List<String> options) {
        this.options = options;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}