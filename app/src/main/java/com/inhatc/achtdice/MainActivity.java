package com.inhatc.achtdice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.scwang.wave.MultiWaveHeader;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{
    MultiWaveHeader waveHeader,waveFooter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveHeader = findViewById(R.id.wave_header);
        waveFooter = findViewById(R.id.wave_footer);

        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(45);
        waveHeader.setWaveHeight(30);
        waveHeader.setStartColor(Color.WHITE);
        waveHeader.setCloseColor(Color.BLACK);

        waveFooter.setVelocity(1);
        waveFooter.setProgress(1);
        waveFooter.isRunning();
        waveFooter.setGradientAngle(45);
        waveFooter.setWaveHeight(30);
        waveFooter.setStartColor(Color.BLACK);
        waveFooter.setCloseColor(Color.WHITE);
    }

    public void onButton_Offline_Clicked(View view){
        Intent intent = new Intent(this, GameplayingActivity2.class);
        startActivity(intent);
    }
    public void onButton_Signup_Clicked(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
    public void onButton_Online_Clicked(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}