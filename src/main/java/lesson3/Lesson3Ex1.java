package lesson3;

import java.util.ArrayList;

import static lesson3.MyScanner.*;

public class Lesson3Ex1 {
    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        while (empList.size() != 1) {
            empList.add(new Employee(nameScan(), surnameScan(), salaryScan()));
        }

        while (true) {
            System.out.print("What do you wish to do now? \n" +
                             "1. Print sum of all employees salary \n" +
                             "2. Display all employees data \n" +
                             "3. Add new employee \n" +
                             "4. End program \n" +
                             "Enter the number:");
            switch (intScanner()) {
                case 1:
                    System.out.println(empList.stream().mapToInt(Employee::getSalary).sum());
                    break;
                case 2:
                    empList.forEach(Employee::getAllData);
                    break;
                case 3:
                    empList.add(new Employee(nameScan(), surnameScan(), salaryScan()));
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Out of range");
                    continue;
            }
        }
    }
}