package lesson1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lesson1Ex2 {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);
        int myNumber;
        System.out.println("Guess the number! 0-99 ");

        for (int chances = 5; chances > 0; chances--) {

            myNumber = returnNumber();

            if (myNumber == numberToGuess) {
                System.out.println("Good job, you win");
                break;
            } else if (myNumber > numberToGuess) {
                System.out.println("Your number is GREATER than the one you are trying to guess");
            } else
                System.out.println("Your number is LOWER than the one you are trying to guess");

            if (chances == 1) {
                System.out.println("Guessing failed, GAME OVER!");
                break;
            } else
                System.out.println("Please try again");

            System.out.println("Chances left: " + (chances - 1));
        }
    }

    public static int returnNumber() {
        while (true) {
            try {
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Something has gone wrong. Please try again: ");
            }
        }
    }
}