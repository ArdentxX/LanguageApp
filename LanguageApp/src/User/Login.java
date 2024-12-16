package User;
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
    public Login() {
        filePath="C:\\Users\\biedr\\Desktop\\ThinkingInJava\\LanguageApp\\LanguageApp\\src\\User\\users.json";
        file = new File(filePath);
    }
    public void getInfo() {
        // Pobieranie danych od użytkownika
        System.out.println("Podaj swoje imię:");
        String username = scanner.nextLine();

        System.out.println("Podaj haslo:");
        String password = scanner.nextLine();

        user = new User(username, password);
    }
    public void writeInfo() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<User> users = new ArrayList<User>();

        try {
            // Odczytaj istniejącą listę użytkowników z pliku JSON
            users=mapper.readValue(file, new TypeReference<ArrayList<User>>(){});
            boolean userExists = false;
            do{
                getInfo();
                userExists = users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));
                if(userExists) {
                    System.out.println("Nazwa zajeta!");
                }
            }while(userExists);
            // Dodaj nowego użytkownika do listy
            users.add(user);
            // Serializuj listę użytkowników i zapisz do pliku
            mapper.writeValue(file, users);
            System.out.println("Konto utworzono poprawnie!");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania danych: " + e.getMessage());
        }
    }
}
