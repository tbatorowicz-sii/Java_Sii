package lesson4.movielibrary.classes;

public class Director extends Person{
    private String name;
    private String surname;

    public Director (Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    @Override
    public String toString() {
        return (this.name + " " + this.surname);
    }
}
