package User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);

    User user;

    public void getInfo() {
        // Pobieranie danych od użytkownika
        System.out.println("Podaj swoje imię:");
        String username = scanner.nextLine();

        System.out.println("Podaj haslo:");
        String password = scanner.nextLine();

        user = new User(username, password);
    }
    public void writeInfo(){
    // Tworzenie mappera Jacksona
    ObjectMapper mapper = new ObjectMapper();

        try {
        // Serializacja obiektu do JSON i zapis do pliku
        mapper.writeValue(new File("C:\\Users\\biedr\\IdeaProjects\\LanguageApp\\LanguageApp\\src\\User\\users.json"), user);

        // Serializacja obiektu do JSON i wyświetlenie w konsoli
        String jsonString = mapper.writeValueAsString(user);
        System.out.println("Konto utworzono poprawnie:");
    } catch (IOException e) {
        System.err.println("Wystąpił błąd podczas tworzenia konta, sprobuj wylaczyc i wlaczyc: " + e.getMessage());
        }
    }
}
