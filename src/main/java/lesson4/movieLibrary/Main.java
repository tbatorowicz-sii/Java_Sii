package lesson4.movieLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());

        new JsonMoviesToMovieLibraryObject(movieLibrary);

        while (true) {
            System.out.print("\n What do you wish to do now? \n" +
                             "1. Display movies from period \n" +
                             "2. Display info about random movie \n" +
                             "3. Type actor name and display his movies \n" +
                             "4. End program \n" +
                             "Enter the number:");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.print("\nYear from: ");
                    int yearFrom = new Scanner(System.in).nextInt();
                    System.out.print("Year to: ");
                    int yearTo = new Scanner(System.in).nextInt();
                    for (Movie m: movieLibrary.getMovieArrayList()) {
                        if(m.getYear()>=yearFrom&&m.getYear()<=yearTo) {
                            System.out.println(m.getTitle());
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n" + movieLibrary.getMovie(new Random().nextInt(movieLibrary.getMovieArrayList().size())));
                    break;
                case 3:
                    System.out.print("\nActor name: ");
                    String firstName = new Scanner(System.in).next();
                    System.out.print("Actor surname: ");
                    String lastName = new Scanner(System.in).next();
                    for (Movie m: movieLibrary.getMovieArrayList()) {
                        for (Actor a : m.getActors()) {
                            if (firstName.equals(a.getName()) && lastName.equals(a.getSurname())) {
                                System.out.println(m.getTitle());
                            }
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Out of range");
            }
        }
    }
}