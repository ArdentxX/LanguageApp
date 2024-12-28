//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.loginui.Questions;

import com.example.loginui.CorrectOrIncorrect.Answer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Questions {
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
        return this.language;
    }

    public String chooseQuestion() {
        ObjectMapper mapper = new ObjectMapper();
        String filePath;
        if (this.getLanguage().equals("KR")) {
            filePath = "C:\\Users\\biedr\\IdeaProjects\\LanguageApp\\LanguageApp\\src\\Questions\\Questions.json";
        } else {
            filePath = "C:\\Users\\biedr\\IdeaProjects\\LanguageApp\\LanguageApp\\src\\Questions\\Questions.json";
        }

        try {
            List<Questions> questionsList = (List)mapper.readValue(new File(filePath), new TypeReference<List<Questions>>() {
            });
            Random rand = new Random();
            Questions randomQuestion = (Questions)questionsList.get(rand.nextInt(questionsList.size()));
            this.correctanswer = randomQuestion.correctanswer;
            this.question = randomQuestion.question;
            this.type = randomQuestion.type;
            if (randomQuestion.options != null) {
                this.options = randomQuestion.options;
                String var10000 = randomQuestion.getQuestion();
                return var10000 + "\n" + String.valueOf(randomQuestion.options);
            } else {
                return randomQuestion.getQuestion();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading questions.";
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isCorrect() {
        if (this.correctanswer != null && this.answer.getAnswer() != null) {
            return this.correctanswer.replaceAll("\\s", "").equalsIgnoreCase(this.answer.getAnswer().replaceAll("\\s", ""));
        } else {
            return false;
        }
    }

    public String getCorrectanswer() {
        return this.correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
