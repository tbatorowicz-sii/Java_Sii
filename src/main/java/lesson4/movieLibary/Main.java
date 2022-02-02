package lesson4.movieLibary;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String jsonString = FileUtils.readFileToString(new File("src/main/java/lesson4/movieLibary/jsonFiles/movies"), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArrayMovies = jsonObject.getJSONArray("movies");

        ArrayList<String> jsonStringMovies = new ArrayList<>();     //Lista stringow JSON do kazdego movie;

        for (int i=0;i<jsonArrayMovies.length();i++)
            jsonStringMovies.add(jsonArrayMovies.get(i).toString());

        ArrayList<String> titleList = new ArrayList<>();            //Lista title dla movie
        ArrayList<String> genreList = new ArrayList<>();            //Lista genre dla movie
        ArrayList<String> yearList = new ArrayList<>();             //Lista  JSON do year dla danego movie
        ArrayList<JSONArray> jsonStringActors = new ArrayList<>();     //Lista stringow JSON do actor dla danego movie;
        ArrayList<JSONArray> jsonStringDirectors = new ArrayList<>();


        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            titleList.add(jsonArrayMovies.getJSONObject(i).getString("title"));
            genreList.add(jsonArrayMovies.getJSONObject(i).getString("genre"));
            yearList.add(jsonArrayMovies.getJSONObject(i).getString("year"));
            jsonStringActors.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("actors"));
            jsonStringDirectors.add(new JSONObject(jsonStringMovies.get(i)).getJSONArray("directors"));
        }

        ArrayList<ArrayList> arrArrActorNames = new ArrayList<>();
        ArrayList<ArrayList> arrArrActorSurnames = new ArrayList<>();
        ArrayList<ArrayList> arrArrDirectorNames = new ArrayList<>();
        ArrayList<ArrayList> arrArrDirectorSurnames = new ArrayList<>();

        for (int i = 0; i < jsonStringActors.size(); i++) {
            ArrayList<String> actorsNameList = new ArrayList<>();
            ArrayList<String> actorsSurnameList = new ArrayList<>();
            ArrayList<String> directorNameList = new ArrayList<>();
            ArrayList<String> directorSurnameList = new ArrayList<>();
            for (int j = 0; j < jsonStringActors.get(i).length(); j++) {
                actorsNameList.add(jsonStringActors.get(i).getJSONObject(j).getString("name"));
                actorsSurnameList.add(jsonStringActors.get(i).getJSONObject(j).getString("surname"));
            }
            for (int j = 0; j < jsonStringDirectors.get(i).length(); j++) {
                directorNameList.add(jsonStringDirectors.get(i).getJSONObject(j).getString("name"));
                directorSurnameList.add(jsonStringDirectors.get(i).getJSONObject(j).getString("surname"));
            }
            arrArrActorNames.add(actorsNameList);
            arrArrActorSurnames.add(actorsSurnameList);
            arrArrDirectorNames.add(directorNameList);
            arrArrDirectorSurnames.add(directorSurnameList);
        }


        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            System.out.println("Title: " + titleList.get(i));
            System.out.println("Genre: " + genreList.get(i));
            System.out.println("Year: " + yearList.get(i));
            for (int j = 0; j < arrArrActorNames.get(i).size(); j++)
                System.out.println("Actor: " + arrArrActorNames.get(i).get(j) + " " + arrArrActorSurnames.get(i).get(j));

            for (int j = 0; j < arrArrDirectorNames.get(i).size(); j++)
                System.out.println("Director: " + arrArrDirectorNames.get(i).get(j) + " " + (arrArrDirectorSurnames.get(i).get(j)));

            System.out.println();
            System.out.println();
        }
    }
}