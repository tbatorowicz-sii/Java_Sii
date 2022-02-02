package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Lesson2Ex1_v2 {
    public static void main(String[] args) {
        String[] tokens = new String[3];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = returnRandomToken(new Scanner(System.in).nextInt());
        }
        for (String token : tokens) {
            System.out.println("Token length is " + token.length() + ", and the value is: " + token);
        }
    }

    public static String returnRandomToken(int tokenLength) {
        StringBuilder token = new StringBuilder();
        char[] tokenChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()".toCharArray();
        while (token.length() != tokenLength) {
            token.append(tokenChars[(new Random().nextInt(tokenChars.length))]);
        }
        return token.toString();
    }
}