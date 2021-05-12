package com.inhatc.achtdice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameplayingActivity2 extends AppCompatActivity {
    ImageView imageView = null;
    Button Aces_btn_text = null;

    int trunCount = 0; // 게임을 하면 턴이 필요하기 때문에 턴 카운트 숫자
    int rolldicecount=0; // 주사위굴리기 사용 제한은 2번이다.
    int player1total =0;//Player1의 최종 점수
    int player2total =0;//Player2의 최종 점수
    int trunCountlbl = 0;//레이블에 보여줄 턴 카운트
    int[] player1topitem = {0,0,0,0,0,0};//플레이어1 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player2topitem = {0,0,0,0,0,0};//플레이어2 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player1bottomitem = {0,0,0,0,0,0};//플레이어1 의 하단 항목 활성화 여부를 케츠해주는 배열 선언
    int[] player2bottomitem = {0,0,0,0,0,0};//플레이어2 의 하단 항목 활성화 여부를 케츠해주는 배열 선언
    int player1bonusscore =0; // 플레이어1이 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int player2bonusscore = 0;//플레이어2가 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int[] Diceorder = {0,0,0,0,0};//주사위 순서에 따라 저장되는 값 [0]에는 왼쪽에서 첫번째 주사위값이 저장됨


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplaying2);




    }
    public void Rolldice(View view){//주사위 굴리기
        Random roll = new Random();
        int randomnum = roll.nextInt(6);//랜덤값생성
        Dice_order_in(1);//첫번째 주사위선택
        Dice_image_in(randomnum);//첫번째 주사위의 이미지를 주사위 눈에 맞춰 변경
        Diceorder[0]= randomnum;//Diceorder 배열 [0]에 나왔던 랜덤값 입력

        randomnum = roll.nextInt(6);
        Dice_order_in(2);
        Dice_image_in(randomnum);
        Diceorder[1]= randomnum;

        randomnum = roll.nextInt(6);
        Dice_order_in(3);
        Dice_image_in(randomnum);
        Diceorder[2]= randomnum;

        randomnum = roll.nextInt(6);
        Dice_order_in(4);
        Dice_image_in(randomnum);
        Diceorder[3]= randomnum;

        randomnum = roll.nextInt(6);
        Dice_order_in(5);
        Dice_image_in(randomnum);
        Diceorder[4]= randomnum;

        calculation_Aces();

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
    public void calculation_Aces() {//주사위 이미지에 따라 ACE버튼 값 지정
        int Aces_btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 1){
                Aces_btn_num += 1;
            }
            Aces_btn_text =(Button)findViewById(R.id.Aces_btn);

            Aces_btn_text.setText(Integer.toString(Aces_btn_num));
        }

    }
}