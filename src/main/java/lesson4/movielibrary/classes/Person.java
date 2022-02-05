package lesson4.movielibrary.classes;

public class Person {
    private String name;
    private String surname;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return (this.name + " " + this.surname);
    }
}
