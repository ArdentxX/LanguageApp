package Questions;
import CorrectOrIncorrect.Answer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Questions {
    protected String question;
    public String correctanswer;
    protected int id;
    protected String type;
    protected List<String> options;
    protected String category;
    public Answer answer;
    public String language;

    public Questions() {
        this.answer = new Answer();
        this.language = "ENG";
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }

    public String chooseQuestion() {
        ObjectMapper mapper = new ObjectMapper();
        String filePath;
        if (language.equals("KR")) {
             filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\QuestionsKR.json";
        }else{ filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\Questions.json";}
        try {
            List<Questions> questionsList = mapper.readValue(new File(filePath), new TypeReference<List<Questions>>() {});
            Random rand = new Random();
            Questions randomQuestion = questionsList.get(rand.nextInt(questionsList.size()));
            this.correctanswer = randomQuestion.correctanswer;
            if(randomQuestion.options != null){
                this.options = randomQuestion.options;
                return randomQuestion.getQuestion() +"\n"+randomQuestion.options;
            }
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

    public String isCorrect() {
        if (correctanswer == null || answer.getAnswer() == null) {
            return "Answer or correct answer is missing.";
        }
        if (correctanswer.replaceAll("\\s", "").equalsIgnoreCase(answer.getAnswer().replaceAll("\\s", ""))) {
            return "Correct";
        }
        return "Incorrect" +"\n"+"Correct Answer: " + correctanswer;
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
