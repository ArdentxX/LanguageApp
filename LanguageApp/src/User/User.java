package User;

public class User {
    private String imie;
    private String nazwisko;
    private int wiek;

    // Konstruktor z trzema argumentami
    public User(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // Gettery i setery (opcjonalne, ale pomocne przy serializacji)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
