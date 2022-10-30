package com.example.levels_prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SettingsScreen extends AppCompatActivity {

    AnimationDrawable characterWalkAnimation;
    AnimationDrawable gemAnimation;
    MediaPlayer buttonSound;
    SwitchCompat soundSwitch;
    Boolean isPlaying = true;
    private Intent serviceIntent;


    @Override
    protected void onStart() {
        super.onStart();
        characterWalkAnimation.start();
        gemAnimation.start();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        Button resume = findViewById(R.id.resumeBtn);
        Button restart = findViewById(R.id.restartBtn);
        Button quit = findViewById(R.id.quitBtn);

        soundSwitch = findViewById(R.id.soundSwitch);

        /*serviceIntent = new Intent(getApplicationContext(), MediaManager.class);

       soundSwitch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(isPlaying) {
                   stopService(new Intent(SettingsScreen.this, MediaManager.class));
                   isPlaying = false;
               } else {
                   startService(new Intent(SettingsScreen.this, MediaManager.class));
                   isPlaying = true;
               }
           }
       });*/


        ImageView characterWalk = (ImageView) findViewById(R.id.characterWalk);
        characterWalk.setBackgroundResource(R.drawable.character_animation);
        characterWalkAnimation = (AnimationDrawable) characterWalk.getBackground();

        ImageView gemImage = (ImageView) findViewById(R.id.gemImgSetScreen);
        gemImage.setBackgroundResource(R.drawable.gem_animation);
        gemAnimation = (AnimationDrawable) gemImage.getBackground();

//        buttonSound = MediaPlayer.create(this, R.raw.button_sound);

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                buttonSound.start();
                NewGameStart(view);
            }
        });

        /*restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSound.start();
            }
        });*/

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                buttonSound.start();
                ReturnToMenu(view);
            }
        });

    }

    public SwitchCompat getSoundSwitch() {
        return soundSwitch;
    }

    public void NewGameStart (View view) {

        Intent intent = new Intent(this, LevelScreen.class);
        startActivity(intent);
    }

    public void ReturnToMenu (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    @Override
//    protected void onDestroy () {
//        super.onDestroy();
//        buttonSound.release();
//        buttonSound = null;
//    }
}