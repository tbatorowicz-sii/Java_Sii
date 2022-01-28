package Lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson3Ex1 {
    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 5; i++) employeeList.add(new Employee());

        loop: while (true) {
            System.out.print("""
                    What do you wish to do now?\s
                    1. Print sum of all employees salary\s
                    2. Display all employees data\s
                    3. Add new employee\s
                    4. End program\s
                    Enter the number:""");
            switch (new Scanner(System.in).next()) {
                case "1":
                    System.out.println(employeeList.stream().mapToInt(e -> (int) e.getSalary()).sum());
                    break;
                case "2":
                    employeeList.forEach(Employee::getAllData);
                    break;
                case "3":
                    employeeList.add(new Employee());
                    break;
                case "4":
                    break loop;
            }
        }
    }
}