package Questions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Questions {
    protected String question;
    protected String correctanswer;
    protected int id;
    protected String type;
    protected List<String> options;
    protected String category;

    public Questions() {
        // Default constructor for Jackson
    }

    public Questions(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    public String chooseQuestion(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Wczytaj pytania z pliku JSON
            List<Questions> questionsList = mapper.readValue(new File(filePath), new TypeReference<List<Questions>>() {});
            // Wybierz losowe pytanie
            Random rand = new Random();
            Questions randomQuestion = questionsList.get(rand.nextInt(questionsList.size()));
            return randomQuestion.getQuestion();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading questions.";
        }
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
