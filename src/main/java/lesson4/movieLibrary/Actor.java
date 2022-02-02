package lesson4.movieLibrary;

public class Actor {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return (this.name + " " + this.surname);
    }
}
