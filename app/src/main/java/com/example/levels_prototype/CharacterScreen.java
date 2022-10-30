package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CharacterScreen extends AppCompatActivity {

    AnimationDrawable character_select0;
    AnimationDrawable character_select1;
    AnimationDrawable character_select2;
    AnimationDrawable character_select3;
    AnimationDrawable character_select4;
    AnimationDrawable character_select5;
    AnimationDrawable character_select6;
    AnimationDrawable character_select7;
    AnimationDrawable character_select8;
    AnimationDrawable character_select9;
    MediaPlayer buttonSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);

        Button confirmSelect = findViewById(R.id.confirm_sel);
        buttonSound = MediaPlayer.create(this, R.raw.button_sound);

        confirmSelect.setOnClickListener(view -> {
            buttonSound.start();
            MainScreen(view);
        });

        ImageView char0_walk = (ImageView) findViewById(R.id.char0_sel);
        ImageView char1_walk = (ImageView) findViewById(R.id.char1_sel);
        ImageView char2_walk = (ImageView) findViewById(R.id.char2_sel);
        ImageView char3_walk = (ImageView) findViewById(R.id.char3_sel);
        ImageView char4_walk = (ImageView) findViewById(R.id.char4_sel);
        ImageView char5_walk = (ImageView) findViewById(R.id.char5_sel);
        ImageView char6_walk = (ImageView) findViewById(R.id.char6_sel);
        ImageView char7_walk = (ImageView) findViewById(R.id.char7_sel);
        ImageView char8_walk = (ImageView) findViewById(R.id.char8_sel);
        ImageView char9_walk = (ImageView) findViewById(R.id.char9_sel);

        char0_walk.setBackgroundResource(R.drawable.char_select0);
        char1_walk.setBackgroundResource(R.drawable.char_select1);
        char2_walk.setBackgroundResource(R.drawable.char_select2);
        char3_walk.setBackgroundResource(R.drawable.char_select3);
        char4_walk.setBackgroundResource(R.drawable.char_select4);
        char5_walk.setBackgroundResource(R.drawable.char_select5);
        char6_walk.setBackgroundResource(R.drawable.char_select6);
        char7_walk.setBackgroundResource(R.drawable.char_select7);
        char8_walk.setBackgroundResource(R.drawable.char_select8);
        char9_walk.setBackgroundResource(R.drawable.char_select9);

        character_select0 = (AnimationDrawable) char0_walk.getBackground();
        character_select1 = (AnimationDrawable) char1_walk.getBackground();
        character_select2 = (AnimationDrawable) char2_walk.getBackground();
        character_select3 = (AnimationDrawable) char3_walk.getBackground();
        character_select4 = (AnimationDrawable) char4_walk.getBackground();
        character_select5 = (AnimationDrawable) char5_walk.getBackground();
        character_select6 = (AnimationDrawable) char6_walk.getBackground();
        character_select7 = (AnimationDrawable) char7_walk.getBackground();
        character_select8 = (AnimationDrawable) char8_walk.getBackground();
        character_select9 = (AnimationDrawable) char9_walk.getBackground();

        char0_walk.setOnClickListener(view -> character_select0.start());
//        char0_walk.setOnClickListener(view -> character_select0.stop());
        char1_walk.setOnClickListener(view -> character_select1.start());
        char2_walk.setOnClickListener(view -> character_select2.start());
        char3_walk.setOnClickListener(view -> character_select3.start());
        char4_walk.setOnClickListener(view -> character_select4.start());
        char5_walk.setOnClickListener(view -> character_select5.start());
        char6_walk.setOnClickListener(view -> character_select6.start());
        char7_walk.setOnClickListener(view -> character_select7.start());
        char8_walk.setOnClickListener(view -> character_select8.start());
        char9_walk.setOnClickListener(view -> character_select9.start());
    }

    public void MainScreen (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}