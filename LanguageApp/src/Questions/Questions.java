package Questions;
import CorrectOrIncorrect.Answer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Questions{
    public String question;
    public String correctanswer;
    public int id;
    public String type;
    public List<String> options;
    public String category;
    public Answer answer;
    public String language;

    public Questions() {
        this.answer = new Answer();
        this.language = "ENG";
    }
    public Questions(Questions original) {
        this.question = original.question;
        this.type = original.type;
        this.options = original.options;
        this.answer = new Answer(original.answer);
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
        if (getLanguage().equals("KR")) {
             filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\QuestionsKR.json";
        }else{ filePath = "C:\\Users\\przem\\IdeaProjects\\LanguageApp1\\LanguageApp\\src\\Questions\\Questions.json";}
        try {
            List<Questions> questionsList = mapper.readValue(new File(filePath), new TypeReference<List<Questions>>() {});
            Random rand = new Random();
            Questions randomQuestion = questionsList.get(rand.nextInt(questionsList.size()));
            this.correctanswer = randomQuestion.correctanswer;
            this.question = randomQuestion.question;
            this.type = randomQuestion.type;
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

    public boolean isCorrect() {
        if (correctanswer == null || answer.getAnswer() == null) {
            return false;
        }
        if (correctanswer.replaceAll("\\s", "").equalsIgnoreCase(answer.getAnswer().replaceAll("\\s", ""))) {
            return true;
        }
        return false;
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
