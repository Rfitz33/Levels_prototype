package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
    }

    public void NewGameStart (View view) {

        Intent intent = new Intent(this, LevelScreen.class);
        startActivity(intent);
    }

    public void ReturnToMenu (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}