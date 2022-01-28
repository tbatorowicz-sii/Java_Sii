package Lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    public static int intScanner() {
        while (true) {
            try {
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Something has gone wrong. Please try again: ");
            }
        }
    }

    public static String stringNamesScanner() {
        while (true) {
            String s = new Scanner(System.in).next();
            if (s.matches("[a-zA-Z]+"))
                return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            else
                System.out.print("Something has gone wrong. Please try again: ");
        }
    }
}
