package Lesson1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1Ex3 {
    public static void main(String[] args) {

        int max = 0;
        int[] numbers = new int[returnNumber()];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Set integer for tab 'numbers[" + i + "]': ");
            numbers[i] = returnNumber();
            if (i == 0) max = numbers[i];
            else if (numbers[i] > max) max = numbers[i];
        }

        System.out.println("Average is: " + (float) Arrays.stream(numbers).sum() / (float) numbers.length);
        System.out.println("Max is: " + max);
    }

    public static int returnNumber() {
        while (true) {
            try {
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                continue;
            }
        }
    }
}