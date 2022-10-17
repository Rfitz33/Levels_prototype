package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingsScreen extends AppCompatActivity {

    AnimationDrawable characterWalkAnimation;


    @Override
    protected void onStart() {
        super.onStart();
        characterWalkAnimation.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);


        ImageView characterWalk = (ImageView) findViewById(R.id.characterWalk);
        characterWalk.setBackgroundResource(R.drawable.character_animation);
        characterWalkAnimation = (AnimationDrawable) characterWalk.getBackground();
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