package Lesson2;

import java.util.Random;
import java.util.Scanner;

public class Lesson2Ex1_v2 {
    public static void main(String[] args) {
        String[] tokens = new String[3];
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = returnRandomToken(new Scanner(System.in).nextInt());
        for (int i = 0; i < tokens.length; i++)
            System.out.println("Token length is " + tokens[i].length() + ", and the value is: " + tokens[i]);
    }

    public static String returnRandomToken(int tokenLength) {
        String token = "";
        char[] tokenChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()".toCharArray();
        while (token.length() != tokenLength)
            token += tokenChars[(new Random().nextInt(tokenChars.length))];
        return token;
    }
}