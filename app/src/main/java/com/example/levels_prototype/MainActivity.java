package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable torchFlameAnimationR;
    AnimationDrawable torchFlameAnimationL;

    @Override
    protected void onStart() {
        super.onStart();

        torchFlameAnimationL.start();
        torchFlameAnimationR.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView torchImage = (ImageView) findViewById(R.id.torch_image);
        ImageView torchImage2 = (ImageView) findViewById(R.id.torch_image2);
        torchImage.setBackgroundResource(R.drawable.torch_animation);
        torchFlameAnimationL = (AnimationDrawable) torchImage.getBackground();
        torchImage2.setBackgroundResource(R.drawable.torch_animation);
        torchFlameAnimationR = (AnimationDrawable) torchImage2.getBackground();

        torchImage.setOnClickListener(view -> torchFlameAnimationL.start());
        torchImage2.setOnClickListener(view -> torchFlameAnimationR.start());
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