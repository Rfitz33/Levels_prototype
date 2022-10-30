package com.example.levels_prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Intent serviceIntent;

    AnimationDrawable torchFlameAnimationR;
    AnimationDrawable torchFlameAnimationL;
    MediaPlayer buttonSound;
    Boolean isPlaying = false;

    private InterstitialAd interstitialAd;
    private boolean gameIsInProgress;
    private Button retryButton;
    private long timerMilliseconds;
    private CountDownTimer countDownTimer;
    private static final long GAME_LENGTH_MILLISECONDS = 3000;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"; // Sample ID


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

        ImageView torchImage = findViewById(R.id.torch_image);
        ImageView torchImage2 = findViewById(R.id.torch_image2);
        torchImage.setBackgroundResource(R.drawable.torch_animation);
        torchFlameAnimationL = (AnimationDrawable) torchImage.getBackground();
        torchImage2.setBackgroundResource(R.drawable.torch_animation);
        torchFlameAnimationR = (AnimationDrawable) torchImage2.getBackground();

        Button startGame = findViewById(R.id.newGameBtn);
        Button settingsMenu = findViewById(R.id.settingsBtn);
        Button characterSelect = findViewById(R.id.characterBtn);

/*        buttonSound = MediaPlayer.create(this, R.raw.button_sound);

        serviceIntent = new Intent(getApplicationContext(), MediaManager.class);
        if(!isPlaying) {
            startService(new Intent(getApplicationContext(), MediaManager.class));
            isPlaying = true;
        }


        if(!settingsScreen.getPlayer().isPlaying() && settingsScreen.getSoundToggle().isChecked()) {
            settingsScreen.getPlayer().start();
        }

        player = MediaPlayer.create(this, R.raw.menusound2);
        player.setVolume(1,1);
        if(!player.isPlaying()) {
            player.start();
        }*/

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                buttonSound.start();
                NewGameStart(view);
            }
        });

        settingsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                buttonSound.start();
                SettingsScreen(view);
            }
        });

        characterSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                buttonSound.start();
                CharacterScreen(view);
            }
        });
    }

        // Log the Mobile Ads SDK version.
        /*Log.d(TAG, "Google Mobile Ads SDK Version: " + MobileAds.getVersion());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        loadAd();

        // Create the "retry" button, which tries to show an interstitial between game plays.
        retryButton = findViewById(R.id.retry_button);
        retryButton.setVisibility(View.INVISIBLE);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
            }
        });

        startGame();

    }

        public void loadAd() {
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(this, AD_UNIT_ID, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                            // The mInterstitialAd reference will be null until an ad is loaded.
                            MainActivity.this.interstitialAd = interstitialAd;
                            Log.i(TAG, "onAdLoaded");
                            Toast.makeText(MainActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
                            interstitialAd.setFullScreenContentCallback(
                                    new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            // Called when fullscreen content is dismissed.
                                            // Make sure to set your reference to null so you don't
                                            // show it a second time.
                                            MainActivity.this.interstitialAd = null;
                                            Log.d("TAG", "The ad was dismissed.");
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                            // Called when fullscreen content failed to show.
                                            // Make sure to set your reference to null so you don't
                                            // show it a second time.
                                            MainActivity.this.interstitialAd = null;
                                            Log.d("TAG", "The ad failed to show.");
                                        }

                                        @Override
                                        public void onAdShowedFullScreenContent() {
                                            // Called when fullscreen content is shown.
                                            Log.d("TAG", "The ad was shown.");
                                        }
                                    });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            Log.i(TAG, loadAdError.getMessage());
                            interstitialAd = null;

                            String error =
                                    String.format(
                                            "domain: %s, code: %d, message: %s",
                                            loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                            Toast.makeText(
                                            MainActivity.this, "onAdFailedToLoad() with error: " + error, Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
        }

        private void createTimer(final long milliseconds) {
            // Create the game timer, which counts down to the end of the level
            // and shows the "retry" button.
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }

            final TextView textView = findViewById(R.id.timer);

            countDownTimer = new CountDownTimer(milliseconds, 50) {
                @Override
                public void onTick(long millisUnitFinished) {
                    timerMilliseconds = millisUnitFinished;
                    textView.setText("seconds remaining: " + ((millisUnitFinished / 1000) + 1));
                }

                @Override
                public void onFinish() {
                    gameIsInProgress = false;
                    textView.setText("done!");
                    retryButton.setVisibility(View.VISIBLE);
                }
            };
        }

        @Override
        public void onResume() {
            // Start or resume the game.
            super.onResume();

            if (gameIsInProgress) {
                resumeGame(timerMilliseconds);
            }
        }

        @Override
        public void onPause() {
            // Cancel the timer if the game is paused.
            countDownTimer.cancel();
            super.onPause();
        }

    private void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (interstitialAd == null) {
            loadAd();
        }

        retryButton.setVisibility(View.INVISIBLE);
        resumeGame(GAME_LENGTH_MILLISECONDS);
    }

    private void resumeGame(long milliseconds) {
        // Create a new timer for the correct length and start it.
        gameIsInProgress = true;
        timerMilliseconds = milliseconds;
        createTimer(milliseconds);
        countDownTimer.start();
    }

        private void showInterstitial() {
            // Show the ad if it's ready. Otherwise toast and restart the game.
            if (interstitialAd != null) {
                interstitialAd.show(this);
            } else {
                Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
                startGame();
            }
        }
        */


        public void SettingsScreen (View view){

            Intent intent = new Intent(this, SettingsScreen.class);
            startActivity(intent);
        }

        public void NewGameStart (View view){

            Intent intent = new Intent(this, LevelScreen.class);
            startActivity(intent);
        }

        public void CharacterScreen (View view){

            Intent intent = new Intent(this, CharacterScreen.class);
            startActivity(intent);
        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            buttonSound.release();
            buttonSound = null;
        }

}