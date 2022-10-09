package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SettingsScreen (View view) {

        Intent intent = new Intent(this, SettingsScreen.class);
        startActivity(intent);
    }

    public void NewGameStart (View view) {

        Intent intent = new Intent(this, LevelScreen.class);
        startActivity(intent);
    }

    public void CharacterScreen (View view) {

        Intent intent = new Intent(this, CharacterScreen.class);
        startActivity(intent);
    }
}