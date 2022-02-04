package lesson4.movieLibrary.functions;

import lesson4.movieLibrary.classes.Actor;
import lesson4.movieLibrary.classes.Movie;
import lesson4.movieLibrary.classes.MovieLibrary;

import java.util.Random;
import java.util.Scanner;

public class Functions {

    public static void displayMenu(){
        System.out.print("\n What do you wish to do now? \n" +
                         "1. Display movies from period \n" +
                         "2. Display info about random movie \n" +
                         "3. Type actor name and display his movies \n" +
                         "4. End program \n" +
                         "Enter the number:");
    }

    public static void displayMoviesFromPeriod(MovieLibrary movieLibrary){
        System.out.print("\nYear from: ");
        int yearFrom = new Scanner(System.in).nextInt();
        System.out.print("Year to: ");
        int yearTo = new Scanner(System.in).nextInt();
        for (Movie m: movieLibrary.getMovieArrayList()) {
            if(m.getYear()>=yearFrom&&m.getYear()<=yearTo) {
                System.out.println(m.getTitle());
            }
        }
    }

    public static void displayInfoAboutRandomMovie(MovieLibrary movieLibrary){
        System.out.println("\n" + movieLibrary.getMovie(new Random().nextInt(movieLibrary.getMovieArrayList().size())));
    }

    public static void displayMoviesForActor(MovieLibrary movieLibrary){
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
    }
}
