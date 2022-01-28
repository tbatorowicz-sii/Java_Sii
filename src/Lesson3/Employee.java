package Lesson3;

import static Lesson3.MyScanner.*;

class Employee {
    private String name;
    private String surname;
    private int salary;

    public float getSalary() {
        return salary;
    }

    public void getAllData() {
        System.out.println("Salary for " + name + " " + surname + " is " + salary);
    }

    public Employee(){
        System.out.print("Please enter name of employee: ");
        this.name = stringNamesScanner();
        System.out.print("Please enter surname of employee: ");
        this.surname = stringNamesScanner();
        System.out.print("Please set salary for employee: ");
        this.salary = intScanner();
    }
}