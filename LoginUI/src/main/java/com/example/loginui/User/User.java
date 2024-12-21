package com.example.loginui.User;

public class User {
    private String username;
    private String password;
    private int englishUnitCount;
    private int koreanUnitCount;
    private double correctEnglishAnswerPercentage;
    private double correctKoreanAnswerPercentage;



    // Konstruktor
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
    public double getCorrectEnglishAnswerPercentage() {
        return correctEnglishAnswerPercentage;
    }
    public void setCorrectEnglishAnswerPercentage(double correctAnswerPercentage) {
        this.correctEnglishAnswerPercentage = correctAnswerPercentage;
    }
    public double getCorrectKoreanAnswerPercentage() {
        return correctKoreanAnswerPercentage;
    }
    public void setCorrectKoreanAnswerPercentage(double correctKoreanAnswerPercentage) {
        this.correctKoreanAnswerPercentage = correctKoreanAnswerPercentage;
    }



}
