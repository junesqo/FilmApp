package kg.junesqo.filmapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kg.junesqo.filmapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}