package lesson1;

import java.util.Random;
import java.util.Scanner;

public class Lesson1Ex2 {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(100);
        int chances = 5;
        System.out.println("Guess the number! 0-99 ");

        while (true) {
            int myNumber = new Scanner(System.in).nextInt();

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
            chances--;
            System.out.println("Chances left: " + (chances));
        }
    }
}