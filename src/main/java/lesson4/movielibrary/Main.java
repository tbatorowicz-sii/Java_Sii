package lesson4.movielibrary;

import lesson4.movielibrary.classes.MovieLibrary;
import lesson4.movielibrary.functions.JsonMoviesToMovieLibraryObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static lesson4.movielibrary.functions.Functions.*;

public class Main {

    public static void main(String[] args) throws IOException {

        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());

        new JsonMoviesToMovieLibraryObject(movieLibrary);

        while (true) {
            displayMenu();
            switch (new Scanner(System.in).next()) {
                case "1":
                    displayMoviesFromPeriod(movieLibrary);
                    break;
                case "2":
                    displayInfoAboutRandomMovie(movieLibrary);
                    break;
                case "3":
                    displayMoviesForActor(movieLibrary);
                    break;
                default:
                    return;
            }
        }
    }
}