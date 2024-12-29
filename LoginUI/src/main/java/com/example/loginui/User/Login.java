package com.example.loginui.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Login {
    Scanner scanner = new Scanner(System.in);
    String filePath;
    User user;
    File file;
    ArrayList<User> users;
    ObjectMapper mapper;
    User currentUser;
    public Login() {
        filePath = getClass().getClassLoader().getResource("users.json").getPath();
        file = new File(filePath);
        mapper = new ObjectMapper();
        users = new ArrayList<User>();
    }
    //metoda uzywana do wstepnego testowania dzialania logowania i rejestracji przed dodaniem UI
    public void getInfo() {
        // Pobieranie danych od użytkownika
        System.out.println("Podaj swoje imię:");
        String username = scanner.nextLine();

        System.out.println("Podaj haslo:");
        String password = scanner.nextLine();

        user = new User(username, password,0,0,0,0,0,0);
    }
    //metoda rejestracji, String username i password podawane w polach tekstowych w UI
    //zwraca 0 gdy utworzono poprawnie, -1 gdy uzytkownik istnieje
    public int registerUser(String username, String password) {
        try {
            // Odczytaj istniejącą listę użytkowników z pliku JSON
            users=mapper.readValue(file, new TypeReference<ArrayList<User>>(){});
            boolean userExists = false;
            user=new User(username,password,0,0,0,0,0,0);
            userExists = users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));
            if(userExists) {
                System.out.println("Nazwa zajeta!");
                return -1;
            }

            // Dodaj nowego użytkownika do listy
            users.add(user);
            // Serializuj listę użytkowników i zapisz do pliku
            mapper.writeValue(file, users);
            System.out.println("Konto utworzono poprawnie!");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania danych: " + e.getMessage());
        }
        return 0;
    }
    //metoda logowania, String username i password podawane w polach tekstowych w UI
    //zwraca 0 gdy poprawnie zalogowano, -1 gdy haslo jest bledne i -2 gdy uzytkownik nie istnieje
    public int loginUser(String username, String password) {
        try {
            // Odczytaj istniejącą listę użytkowników z pliku JSON
            users = mapper.readValue(file, new TypeReference<ArrayList<User>>() {});

            for (User u : users) {
                if (u.getUsername().equals(username)) {
                    if (u.getPassword().equals(password)) {
                        System.out.println("Zalogowano poprawnie!");
                        currentUser = u;
                        return 0;
                    }
                    System.out.println("Bledne haslo");
                    return -1;
                }
            }
            System.out.println("Nie znaleziono uzytkownika!");
            return -2;
        } catch (IOException e) {
            throw new RuntimeException("Wystąpił błąd podczas logowania: " + e.getMessage());
        }
    }
    public String showCurrentUserInfo() {
        return currentUser.getUsername();
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
