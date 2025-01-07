package com.example.loginui;

import com.example.loginui.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.round;

public class LoggedInController extends HelloController {
    @FXML
    public Label usernameLabel;
    @FXML
    public Label lessonsEngLabel;
    @FXML
    public Label percentageEngLabel;
    @FXML
    public Label lessonsKorLabel;
    @FXML
    public Label percentageKorLabel;
    @FXML
    Button ENGStartbutton;
    @FXML
    Button KRStartbutton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private User currentUser;
    String filePath = getClass().getClassLoader().getResource("users.json").getPath();
    File file = new File(filePath);
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<User> users = new ArrayList<User>();

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void displayInfo(User currentUser) {
        usernameLabel.setText(currentUser.getUsername());
        lessonsEngLabel.setText(String.valueOf(currentUser.getEnglishUnitCount()));
        lessonsKorLabel.setText(String.valueOf(currentUser.getKoreanUnitCount()));
        if (currentUser.getCorrectEnglishAnswer() == 0 && currentUser.getIncorrectEnglishAnswer() == 0) {
            percentageEngLabel.setText("0");
        } else {
            percentageEngLabel.setText(String.valueOf(round(100 * currentUser.getCorrectEnglishAnswer() / (currentUser.getCorrectEnglishAnswer() + currentUser.getIncorrectEnglishAnswer()))) + "%");
        }
        if (currentUser.getCorrectKoreanAnswer() == 0 && currentUser.getIncorrectKoreanAnswer() == 0) {
            percentageKorLabel.setText("0");
        }else {
            percentageKorLabel.setText(String.valueOf(round(100 * currentUser.getCorrectKoreanAnswer() / (currentUser.getIncorrectKoreanAnswer() + currentUser.getCorrectKoreanAnswer()))) + "%");
        }
        this.currentUser = currentUser;
    }

    @FXML
    public void onWylogujButton(ActionEvent actionEvent) throws IOException {
        switchToLogin(actionEvent);
    }

    @FXML
    private void onKRStartbutton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LessonUiKR.fxml"));
            Parent root = loader.load();
            LessonControllerKR lessonController = loader.getController();

            lessonController.setUser(currentUser);

            closeCurrentWindow();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Lekcja Koreańskiego");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onENGStartbutton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LessonUi.fxml"));
            Parent root = loader.load();
            LessonController lessonController = loader.getController();

            lessonController.setUser(currentUser);

            closeCurrentWindow();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Lekcja Angielskiego");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeCurrentWindow() {
        Stage stage = (Stage) ENGStartbutton.getScene().getWindow();
        stage.close();
    }

    public void setUser(User user) {
        this.currentUser = user;
        usernameLabel.setText(user.getUsername());
        lessonsEngLabel.setText(String.valueOf(user.getEnglishUnitCount()));
        updateUserValue(String.valueOf(user.getUsername()),"englishUnitCount",user.getEnglishUnitCount());
        lessonsKorLabel.setText(String.valueOf(user.getKoreanUnitCount()));
        updateUserValue(String.valueOf(user.getUsername()),"koreanUnitCount",user.getKoreanUnitCount());

        if (user.getCorrectEnglishAnswer() == 0 && user.getIncorrectEnglishAnswer() == 0) {
            percentageEngLabel.setText("0");
        } else {
            percentageEngLabel.setText(String.valueOf(round(100*user.getCorrectEnglishAnswer() / (user.getCorrectEnglishAnswer() + user.getIncorrectEnglishAnswer())))+"%");
            updateUserValue(String.valueOf(user.getUsername()),"correctEnglishAnswer",user.getCorrectEnglishAnswer());
            updateUserValue(String.valueOf(user.getUsername()),"incorrectEnglishAnswer",user.getIncorrectEnglishAnswer());
        }

        if (user.getCorrectKoreanAnswer() == 0 && user.getIncorrectKoreanAnswer() == 0) {
            percentageKorLabel.setText("0");
        } else {
            percentageKorLabel.setText(String.valueOf(round(100*user.getCorrectKoreanAnswer() / (user.getIncorrectKoreanAnswer() + user.getCorrectKoreanAnswer())))+"%");
            updateUserValue(String.valueOf(user.getUsername()),"correctKoreanAnswer",user.getCorrectKoreanAnswer());
            updateUserValue(String.valueOf(user.getUsername()),"incorrectKoreanAnswer",user.getIncorrectKoreanAnswer());
        }
    }

    public User getUser() {
        return currentUser;
    }

    public String getUsername() {
        return currentUser.getUsername();
    }

    public int getEnglishUnitCount() {
        return currentUser.getEnglishUnitCount();
    }

    public int getKoreanUnitCount() {
        return currentUser.getKoreanUnitCount();
    }

    public double getCorrectEnglishAnswer() {
        return currentUser.getCorrectEnglishAnswer();
    }

    public double getCorrectKoreanAnswer() {
        return currentUser.getCorrectKoreanAnswer();
    }

    public double getIncorrectEnglishAnswer() {
        return currentUser.getIncorrectEnglishAnswer();
    }

    public double getIncorrectKoreanAnswer() {
        return currentUser.getIncorrectKoreanAnswer();
    }
    public void updateUserValue(String username, String field, Object newValue) {
        try {
            ArrayList<User> users = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));


            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    switch (field) {
                        case "englishUnitCount":
                            user.setEnglishUnitCount((int) newValue);
                            break;
                        case "koreanUnitCount":
                            user.setKoreanUnitCount((int) newValue);
                            break;
                        case "correctEnglishAnswer":
                            user.setCorrectEnglishAnswer((double) newValue);
                            break;
                        case "correctKoreanAnswer":
                            user.setCorrectKoreanAnswer((double) newValue);
                            break;
                        case "incorrectEnglishAnswer":
                            user.setIncorrectEnglishAnswer((double) newValue);
                            break;
                        case "incorrectKoreanAnswer":
                            user.setIncorrectKoreanAnswer((double) newValue);
                            break;
                        default:
                            System.out.println("Nieznane pole: " + field);
                    }
                    break;
                }
            }

            mapper.writeValue(file, users);

            System.out.println("Dane użytkownika zaktualizowane pomyślnie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
