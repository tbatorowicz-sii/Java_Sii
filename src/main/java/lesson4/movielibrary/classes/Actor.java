package lesson4.movielibrary.classes;

public class Actor extends Person{
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Actor (Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    @Override
    public String toString() {
        return (this.name + " " + this.surname);
    }
}
