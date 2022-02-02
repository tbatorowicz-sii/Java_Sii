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
        ArrayList<ArrayList> arrArrActorSurnmes = new ArrayList<>();

        for (int i = 0; i < jsonStringActors.size(); i++) {
            //System.out.println(jsonStringActors.get(i));
            ArrayList<String> actorsNameList = new ArrayList<>();
            ArrayList<String> actorsSurnameList = new ArrayList<>();
            for (int j = 0; j < jsonStringActors.get(i).length(); j++) {
                actorsNameList.add(jsonStringActors.get(i).getJSONObject(j).getString("name"));
                actorsSurnameList.add(jsonStringActors.get(i).getJSONObject(j).getString("surname"));
                //System.out.println(actorsNameList.get(j) + " " + actorsSurnameList.get(j));
            }
            arrArrActorNames.add(actorsNameList);
            arrArrActorSurnmes.add(actorsSurnameList);
        }

        ArrayList<ArrayList> arrArrDirectorNames = new ArrayList<>();
        ArrayList<ArrayList> arrArrDirectorSurnmes = new ArrayList<>();

        for (int i = 0; i < jsonStringDirectors.size(); i++) {
            //System.out.println(jsonStringActors.get(i));
            ArrayList<String> directorNameList = new ArrayList<>();
            ArrayList<String> directorSurnameList = new ArrayList<>();
            for (int j = 0; j < jsonStringDirectors.get(i).length(); j++) {
                directorNameList.add(jsonStringDirectors.get(i).getJSONObject(j).getString("name"));
                directorSurnameList.add(jsonStringDirectors.get(i).getJSONObject(j).getString("surname"));
                //System.out.println(actorsNameList.get(j) + " " + actorsSurnameList.get(j));
            }
            arrArrDirectorNames.add(directorNameList);
            arrArrDirectorSurnmes.add(directorSurnameList);
        }

        for (int i = 0; i < jsonArrayMovies.length(); i++)
        {
            System.out.println(titleList.get(i));
            System.out.println(genreList.get(i));
            System.out.println(yearList.get(i));
            System.out.println(arrArrActorNames.get(i));
            System.out.println(arrArrActorSurnmes.get(i));

            System.out.println(arrArrDirectorNames.get(i));
            System.out.println(arrArrDirectorSurnmes.get(i));

            System.out.println();
            System.out.println();
        }
    }
}