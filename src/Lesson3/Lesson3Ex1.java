package Lesson3;

import java.util.ArrayList;
import java.util.Scanner;

import static Lesson3.MyScanner.*;

public class Lesson3Ex1 {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        while (empList.size() != 5) {
            empList.add(new Employee(nameScan(), surnameScan(), salaryScan()));
        }

        while (true) {
            System.out.print("""
                    What do you wish to do now?\s
                    1. Print sum of all employees salary\s
                    2. Display all employees data\s
                    3. Add new employee\s
                    4. End program\s
                    Enter the number:""");
            switch (new Scanner(System.in).next()) {
                case "1":
                    System.out.println(empList.stream().mapToInt(Employee::getSalary).sum());
                    break;
                case "2":
                    empList.forEach(Employee::getAllData);
                    break;
                case "3":
                    empList.add(new Employee(nameScan(), surnameScan(), salaryScan()));
                    break;
                case "4":
                    return;
            }
        }
    }
}