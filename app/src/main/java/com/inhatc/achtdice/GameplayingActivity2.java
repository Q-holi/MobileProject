package com.inhatc.achtdice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class GameplayingActivity2 extends AppCompatActivity {
    ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplaying2);



    }
    public void Rolldice(View view){
        Random roll = new Random();
        int randomnum = roll.nextInt(6);
        Dice_order_in(1);
        Dice_image_in(randomnum);

        randomnum = roll.nextInt(6);
        Dice_order_in(2);
        Dice_image_in(randomnum);

        randomnum = roll.nextInt(6);
        Dice_order_in(3);
        Dice_image_in(randomnum);

        randomnum = roll.nextInt(6);
        Dice_order_in(4);
        Dice_image_in(randomnum);

        randomnum = roll.nextInt(6);
        Dice_order_in(5);
        Dice_image_in(randomnum);
    }
    public void Dice_order_in(int diceorder){//몇번째 주사위에 이미지를 넣을것인지 지정
        if(diceorder==1){
            imageView = (ImageView)findViewById(R.id.dice1);
        }else if(diceorder==2){
            imageView = (ImageView)findViewById(R.id.dice2);
        }else if(diceorder==3){
            imageView = (ImageView)findViewById(R.id.dice3);
        }else if(diceorder==4){
            imageView = (ImageView)findViewById(R.id.dice4);
        }else{
            imageView = (ImageView)findViewById(R.id.dice5);
        }
    }
    public void Dice_image_in(int dicenum){//랜덤값에 따라 이미지 변경
        if(dicenum==1){
            imageView.setImageResource(R.drawable.dice_num1);
        }else if(dicenum==2){
            imageView.setImageResource(R.drawable.dice_num2);
        }else if(dicenum==3){
            imageView.setImageResource(R.drawable.dice_num3);
        }else if(dicenum==4){
            imageView.setImageResource(R.drawable.dice_num4);
        }else if(dicenum==5){
            imageView.setImageResource(R.drawable.dice_num5);
        }else{
            imageView.setImageResource(R.drawable.dice_num6);
        }
    }
}