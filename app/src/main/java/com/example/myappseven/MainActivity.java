package com.example.myappseven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_stop;
    private ConstraintLayout cl_play;

    private Animation animation_fade_in;
    private Animation animation_fade_out;

    private MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.button);
        btn_stop = findViewById(R.id.btn_stop);
        cl_play = findViewById(R.id.cl_play);

        animation_fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animation_fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        if(player == null){
            player = MediaPlayer.create(getApplicationContext(), R.raw.sadatasadaeliya);
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                cl_play.setVisibility(View.VISIBLE);
//                cl_play.startAnimation(animation_fade_in);

                player.pause();
            }
        });

        cl_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                btn_login.startAnimation(animation_fade_out);
//                btn_login.setVisibility(View.INVISIBLE);

                if(player == null){
                    player = MediaPlayer.create(getApplicationContext(), R.raw.sadatasadaeliya);
                    player.start();
                }else {
                    player.start();
                }


            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(player != null){
                    player.release();
                    player = null;
                }

            }
        });

    }
}