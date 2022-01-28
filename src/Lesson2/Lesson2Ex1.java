package Lesson2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lesson2Ex1 {
    public static void main(String[] args) {

        String[] tokens = new String[3];
        int[] tokenLength = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            System.out.print("Set length of no." + (i + 1) + " token : ");
            tokenLength[i] = getNumberFromUser();
            tokens[i] = generateToken(tokenLength[i]);
        }

        for (int i = 0; i < tokens.length; i++)
            System.out.println("Token no." + (i + 1) + " length is " + tokenLength[i] + ", and the value is: " + tokens[i]);

    }

    public static int getNumberFromUser() {
        while (true) {
            try {
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Something has gone wrong. Please try again: ");
            }
        }
    }

    public static String generateToken(int tokenLength) {
        StringBuilder token = new StringBuilder();
        char[] tokenChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()".toCharArray();
        while (token.length() != tokenLength)
            token.append(tokenChars[(new Random().nextInt(tokenChars.length))]);
        return token.toString();
    }

}