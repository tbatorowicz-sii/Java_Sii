package lesson3;

class Employee {
    private final String name;
    private final String surname;
    private final int salary;

    public int getSalary() {
        return salary;
    }

    public void getAllData() {
        System.out.println("Salary for " + name + " " + surname + " is " + salary);
    }

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }
}