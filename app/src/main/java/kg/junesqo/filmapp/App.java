package kg.junesqo.filmapp;

import android.app.Application;

import kg.junesqo.filmapp.data.remote.FilmApi;
import kg.junesqo.filmapp.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createFilmApi();
    }
}
