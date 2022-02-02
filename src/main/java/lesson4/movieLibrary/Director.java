package lesson4.movieLibrary;

public class Director {
    private String name;
    private String surname;

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return (this.name + " " + this.surname);
    }
}
