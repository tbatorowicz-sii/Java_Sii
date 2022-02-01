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

    public static String namesScanner() {
        while (true) {
            String s = new Scanner(System.in).next();
            if (s.chars().allMatch(Character::isLetter)) {
                return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            }
            else {
                System.out.print("Something has gone wrong. Please try again: ");
            }
        }
    }

    public static String nameScan(){
        System.out.print("Please enter name of employee: ");
        return namesScanner();
    }
    public static String surnameScan(){
        System.out.print("Please enter surname of employee: ");
        return namesScanner();
    }
    public static int salaryScan(){
        System.out.print("Please set salary for employee: ");
        return intScanner();
    }

}