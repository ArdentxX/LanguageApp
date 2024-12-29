package com.example.loginui.User;

public class User {
    public String username;
    private String password;
    public int englishUnitCount;
    public int koreanUnitCount;
    public double correctEnglishAnswer;
    public double correctKoreanAnswer;
    public double incorrectEnglishAnswer;
    public double incorrectKoreanAnswer;



    // Konstruktor
    public User() {}

    public User(String username, String password,int englishUnitCount,int koreanUnitCount, double correctEnglishAnswer, double correctKoreanAnswer, double incorrectEnglishAnswer, double incorrectKoreanAnswer ) {
        this.username = username;
        this.password = password;
        this.englishUnitCount = englishUnitCount;
        this.koreanUnitCount = koreanUnitCount;
        this.correctEnglishAnswer = correctEnglishAnswer;
        this.correctKoreanAnswer = correctKoreanAnswer;
        this.incorrectEnglishAnswer = incorrectEnglishAnswer;
        this.incorrectKoreanAnswer = incorrectKoreanAnswer;
    }


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //settery zeby json mogł zapisac do obiektu
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getEnglishUnitCount() {
        return englishUnitCount;
    }
    public void setEnglishUnitCount(int englishUnitCount) {
        this.englishUnitCount = englishUnitCount;
    }
    public int getKoreanUnitCount() {
        return koreanUnitCount;
    }
    public void setKoreanUnitCount(int koreanUnitCount) {
        this.koreanUnitCount = koreanUnitCount;
    }
    public double getCorrectEnglishAnswer() {
        return correctEnglishAnswer;
    }
    public void setCorrectEnglishAnswer(double correctAnswer) {
        this.correctEnglishAnswer = correctAnswer;
    }
    public double getCorrectKoreanAnswer() {
        return correctKoreanAnswer;
    }
    public void setCorrectKoreanAnswer(double correctKoreanAnswer) {
        this.correctKoreanAnswer = correctKoreanAnswer;
    }
    public double getIncorrectEnglishAnswer() {
        return incorrectEnglishAnswer;
    }
    public void setIncorrectEnglishAnswer(double incorrectEnglishAnswer) {
        this.incorrectEnglishAnswer = incorrectEnglishAnswer;
    }
    public double getIncorrectKoreanAnswer() {
        return incorrectKoreanAnswer;
    }
    public void setIncorrectKoreanAnswer(double incorrectKoreanAnswer) {
        this.incorrectKoreanAnswer = incorrectKoreanAnswer;
    }




}
