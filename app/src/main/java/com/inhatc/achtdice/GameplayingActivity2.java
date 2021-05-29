package com.inhatc.achtdice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameplayingActivity2 extends AppCompatActivity {
    ImageView imageView = null;
    Button btn_text_edit = null;
    Button P1Aces = null;
    Button P1Deuces = null;
    Button P1Trees = null;
    Button P1Fours = null;
    Button P1Fives = null;
    Button P1Sixes = null;
    Button P1Choice = null;
    Button P1FourAKind = null;
    Button P1FullHouse = null;
    Button P1SmallStraight = null;
    Button P1LargeStraight = null;
    Button P1Yacht = null;

    TextView P1Total_score = null;
    TextView P1Bonus_check = null;

    Button P2Aces = null;
    Button P2Deuces = null;
    Button P2Trees = null;
    Button P2Fours = null;
    Button P2Fives = null;
    Button P2Sixes = null;
    Button P2Choice = null;
    Button P2FourAKind = null;
    Button P2FullHouse = null;
    Button P2SmallStraight = null;
    Button P2LargeStraight = null;
    Button P2Yacht = null;
    TextView P2Total_score = null;
    TextView P2Bonus_check = null;

    //주사위 5개
    ImageView touch_dice1 = null;
    ImageView touch_dice2 = null;
    ImageView touch_dice3 = null;
    ImageView touch_dice4 = null;
    ImageView touch_dice5 = null;

    TextView DiceRollingcount = null;

    Button DiceRoll = null;

    int turnCount = 0; // 게임을 하면 턴이 필요하기 때문에 턴 카운트 숫자
    int rolldicecount = 0; // 주사위굴리기 사용 제한은 2번이다.
    int player1total = 0;//Player1의 최종 점수
    int player2total = 0;//Player2의 최종 점수
    int trunCountlbl = 0;//레이블에 보여줄 턴 카운트
    int[] player1topitem = {0, 0, 0, 0, 0, 0};//플레이어1 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player2topitem = {0, 0, 0, 0, 0, 0};//플레이어2 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player1bottomitem = {0, 0, 0, 0, 0, 0};//플레이어1 의 하단 항목 활성화 여부를 체크해주는 배열 선언
    int[] player2bottomitem = {0, 0, 0, 0, 0, 0};//플레이어2 의 하단 항목 활성화 여부를 체크해주는 배열 선언
    int player1bonusscore = 0; // 플레이어1이 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int player2bonusscore = 0;//플레이어2가 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int[] Diceorder = {0, 0, 0, 0, 0};//주사위 순서에 따라 저장되는 값 [0]에는 왼쪽에서 첫번째 주사위값이 저장됨
    int[] SelectedDiceorder = {0, 0, 0, 0, 0};//주사위를 고정시키는 값 1이면 고정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DiceRoll = findViewById(R.id.DiceRolling);
        //P1버튼 객체생성
        setContentView(R.layout.activity_gameplaying2);
        P1Aces = findViewById(R.id.P1AcesBtn);
        P1Deuces = findViewById(R.id.P1DeucesBtn);
        P1Trees = findViewById(R.id.P1ThreesBtn);
        P1Fours = findViewById(R.id.P1FoursBtn);
        P1Fives = findViewById(R.id.P1FivesBtn);
        P1Sixes = findViewById(R.id.P1SixesBtn);
        P1Choice = findViewById(R.id.P1ChoiceBtn);
        P1FourAKind = findViewById(R.id.P1FourOfaKindBtn);
        P1FullHouse = findViewById(R.id.P1FullHouseBtn);
        P1SmallStraight = findViewById(R.id.P1SmallStraightBtn);
        P1LargeStraight = findViewById(R.id.P1LargeStraightBtn);
        P1Yacht = findViewById(R.id.P1YachtBtn);

        //P1버튼 전부 비활성화
        P1Aces.setEnabled(false);
        P1Deuces.setEnabled(false);
        P1Trees.setEnabled(false);
        P1Fours.setEnabled(false);
        P1Fives.setEnabled(false);
        P1Sixes.setEnabled(false);
        P1Choice.setEnabled(false);
        P1FourAKind.setEnabled(false);
        P1FullHouse.setEnabled(false);
        P1SmallStraight.setEnabled(false);
        P1LargeStraight.setEnabled(false);
        P1Yacht.setEnabled(false);
        //P2버튼 객체생성
        P2Aces = findViewById(R.id.P2AcesBtn);
        P2Deuces = findViewById(R.id.P2DeucesBtn);
        P2Trees = findViewById(R.id.P2ThreesBtn);
        P2Fours = findViewById(R.id.P2FoursBtn);
        P2Fives = findViewById(R.id.P2FivesBtn);
        P2Sixes = findViewById(R.id.P2SixesBtn);
        P2Choice = findViewById(R.id.P2ChoiceBtn);
        P2FourAKind = findViewById(R.id.P2FourOfaKindBtn);
        P2FullHouse = findViewById(R.id.P2FullHouseBtn);
        P2SmallStraight = findViewById(R.id.P2SmallStraightBtn);
        P2LargeStraight = findViewById(R.id.P2LargeStraightBtn);
        P2Yacht = findViewById(R.id.P2YachtBtn);
        DiceRoll = findViewById(R.id.DiceRolling);

        //P2버튼 전부 비활성화

        P2Aces.setEnabled(false);
        P2Deuces.setEnabled(false);
        P2Trees.setEnabled(false);
        P2Fours.setEnabled(false);
        P2Fives.setEnabled(false);
        P2Sixes.setEnabled(false);
        P2Choice.setEnabled(false);
        P2FourAKind.setEnabled(false);
        P2FullHouse.setEnabled(false);
        P2SmallStraight.setEnabled(false);
        P2LargeStraight.setEnabled(false);
        P2Yacht.setEnabled(false);

        P1Total_score = findViewById(R.id.P1Total);
        P1Bonus_check = findViewById(R.id.P1Bouns);

        P2Total_score = findViewById(R.id.P2Total);
        P2Bonus_check = findViewById(R.id.P2Bouns);

        touch_dice1 = findViewById(R.id.DiceImageView1);
        touch_dice2 = findViewById(R.id.DiceImageView2);
        touch_dice3 = findViewById(R.id.DiceImageView3);
        touch_dice4 = findViewById(R.id.DiceImageView4);
        touch_dice5 = findViewById(R.id.DiceImageView5);

        DiceRollingcount = findViewById(R.id.DiceRollingcount);


        startturn();
    }

    public void startturn() {//턴이 시작되면
        if (turnCount % 2 == 0) {//player1의 턴일때
            //메세지 출력
            Toast.makeText(getApplicationContext(), "player1 turn", Toast.LENGTH_SHORT).show();


            //P1Turn,P2Turn 을 가져와
            TextView P1Turn = findViewById(R.id.P1Turn);
            TextView P2Turn = findViewById(R.id.P2Turn);
            //P1Turn은 MAGENTA색으로 P2Turn는 black으로 색변경
            P1Turn.setTextColor(Color.MAGENTA);
            P2Turn.setTextColor(Color.parseColor("#000000"));


            //textView turn을가져와
            TextView Turn = findViewById(R.id.Turn);
            //Turn의 텍스트를 넣기
            String now_turn = (String) Turn.getText();
            // "/"기준으로 문자열자르기
            String[] now_turn_num = now_turn.split("/");
            // 자른 문자열에서 숫자 부분만 떼네 1을 더한다.
            int plus_turn = 1 + Integer.parseInt(now_turn_num[0]);
            //+1해서
            Turn.setText(plus_turn + "/12");
            //기존 양식에 맞게 출력

           //player2버튼 비활성화
            P2Aces.setEnabled(false);
            P2Deuces.setEnabled(false);
            P2Trees.setEnabled(false);
            P2Fours.setEnabled(false);
            P2Fives.setEnabled(false);
            P2Sixes.setEnabled(false);
            P2Choice.setEnabled(false);
            P2FourAKind.setEnabled(false);
            P2FullHouse.setEnabled(false);
            P2SmallStraight.setEnabled(false);
            P2LargeStraight.setEnabled(false);
            P2Yacht.setEnabled(false);
            if (player1topitem[0] == 0)//버튼이 눌리기전일때만
                P1Aces.setEnabled(true);//버튼활성화'
            if (player1topitem[1] == 0)//버튼이 눌리기전일때만
                P1Deuces.setEnabled(true);//버튼활성화
            if (player1topitem[2] == 0)
                P1Trees.setEnabled(true);
            if (player1topitem[3] == 0)
                P1Fours.setEnabled(true);
            if (player1topitem[4] == 0)
                P1Fives.setEnabled(true);
            if (player1topitem[5] == 0)
                P1Sixes.setEnabled(true);

            if (player1bottomitem[0] == 0)//버튼이 눌리기전일때만
                P1Choice.setEnabled(true);//버튼활성화'
            if (player1bottomitem[1] == 0)//버튼이 눌리기전일때만
                P1FourAKind.setEnabled(true);//버튼활성화'
            if (player1bottomitem[2] == 0)//버튼이 눌리기전일때만
                P1FullHouse.setEnabled(true);//버튼활성화'
            if (player1bottomitem[3] == 0)//버튼이 눌리기전일때만
                P1SmallStraight.setEnabled(true);//버튼활성화'
            if (player1bottomitem[4] == 0)//버튼이 눌리기전일때만
                P1LargeStraight.setEnabled(true);//버튼활성화'
            if (player1bottomitem[5] == 0)//버튼이 눌리기전일때만
                P1Yacht.setEnabled(true);//버튼활성화'

        } else {//player2의 턴일때
            //메세지 출력
            Toast.makeText(getApplicationContext(), "player2 turn", Toast.LENGTH_SHORT).show();

            //P1Turn,P2Turn 을 가져와
            TextView P1Turn = findViewById(R.id.P1Turn);
            TextView P2Turn = findViewById(R.id.P2Turn);
            //P2Turn은 MAGENTA색으로 P1Turn는 black으로 색변경
            P2Turn.setTextColor(Color.MAGENTA);
            P1Turn.setTextColor(Color.parseColor("#000000"));

            //player1버튼 비활성화
            P1Aces.setEnabled(false);
            P1Deuces.setEnabled(false);
            P1Trees.setEnabled(false);
            P1Fours.setEnabled(false);
            P1Fives.setEnabled(false);
            P1Sixes.setEnabled(false);
            P1Choice.setEnabled(false);
            P1FourAKind.setEnabled(false);
            P1FullHouse.setEnabled(false);
            P1SmallStraight.setEnabled(false);
            P1LargeStraight.setEnabled(false);
            P1Yacht.setEnabled(false);
            if (player2topitem[0] == 0)//버튼이 눌리기전일때만
                P2Aces.setEnabled(true);//버튼활성화'
            if (player2topitem[1] == 0)//버튼이 눌리기전일때만
                P2Deuces.setEnabled(true);//버튼활성화
            if (player2topitem[2] == 0)
                P2Trees.setEnabled(true);
            if (player2topitem[3] == 0)
                P2Fours.setEnabled(true);
            if (player2topitem[4] == 0)
                P2Fives.setEnabled(true);
            if (player2topitem[5] == 0)
                P2Sixes.setEnabled(true);

            if (player2bottomitem[0] == 0)//버튼이 눌리기전일때만
                P2Choice.setEnabled(true);//버튼활성화'
            if (player2bottomitem[1] == 0)//버튼이 눌리기전일때만
                P2FourAKind.setEnabled(true);//버튼활성화'
            if (player2bottomitem[2] == 0)//버튼이 눌리기전일때만
                P2FullHouse.setEnabled(true);//버튼활성화'
            if (player2bottomitem[3] == 0)//버튼이 눌리기전일때만
                P2SmallStraight.setEnabled(true);//버튼활성화'
            if (player2bottomitem[4] == 0)//버튼이 눌리기전일때만
                P2LargeStraight.setEnabled(true);//버튼활성화'
            if (player2bottomitem[5] == 0)//버튼이 눌리기전일때만
                P2Yacht.setEnabled(true);//버튼활성화'
        }

        rolldicecount=0;
        DiceRollingcount.setText("0/2");
        DiceRoll.setEnabled(true);


        SelectedDiceorder[0] = 0;
        SelectedDiceorder[1] = 0;
        SelectedDiceorder[2] = 0;
        SelectedDiceorder[3] = 0;
        SelectedDiceorder[4] = 0;
        //주사위를 굴린뒤
        Rolldice();
        //계산
        calculation();


    }

    public void onButtonClick(View v) {
        switch (v.getId()) {
            //player 아무나 Aces버튼을 누를경우
            case R.id.P1AcesBtn:
            case R.id.P2AcesBtn:
                Aces_Clicked();
                break;
            //player 아무나 Deuces버튼을 누를경우
            case R.id.P1DeucesBtn:
            case R.id.P2DeucesBtn:
                Deuces_Clicked();
                break;
            //player 아무나 Threes버튼을 누를경우
            case R.id.P1ThreesBtn:
            case R.id.P2ThreesBtn:
                Threes_Clicked();
                break;
            //player 아무나 Fours버튼을 누를경우
            case R.id.P1FoursBtn:
            case R.id.P2FoursBtn:
                Fours_Clicked();
                break;
            //player 아무나 Fives버튼을 누를경우
            case R.id.P1FivesBtn:
            case R.id.P2FivesBtn:
                Fives_Clicked();
                break;
            //player 아무나 Sixes버튼을 누를경우
            case R.id.P1SixesBtn:
            case R.id.P2SixesBtn:
                Sixes_Clicked();
                break;
            //player 아무나 Choice버튼을 누를경우
            case R.id.P1ChoiceBtn:
            case R.id.P2ChoiceBtn:
                Choice_Clicked();
                break;
            //player 아무나 FourOfaKind버튼을 누를경우
            case R.id.P1FourOfaKindBtn:
            case R.id.P2FourOfaKindBtn:
                FourOfAKind_Clicked();
                break;
            //player 아무나 FullHouse버튼을 누를경우
            case R.id.P1FullHouseBtn:
            case R.id.P2FullHouseBtn:
                FullHouse_Clicked();
                break;
            //player 아무나 SmallStraight버튼을 누를경우
            case R.id.P1SmallStraightBtn:
            case R.id.P2SmallStraightBtn:
                SmallStraight_Clicked();
                break;
            //player 아무나 LargeStraight버튼을 누를경우
            case R.id.P1LargeStraightBtn:
            case R.id.P2LargeStraightBtn:
                LargeStaight_Clicked();
                break;
            //player 아무나 Yacht버튼을 누를경우
            case R.id.P1YachtBtn:
            case R.id.P2YachtBtn:
                Yacht_Clicked();
                break;

            case R.id.DiceRolling:
                rolldicecount++;
                DiceRollingcount.setText(rolldicecount + "/2");

                if(rolldicecount==2){
                    DiceRoll.setEnabled(false);
                }
                Rolldice();
                break;

            case R.id.DiceImageView1://첫번째 주사위 이미지가 터치되면
                Dice1_Clicked();
                break;
            case R.id.DiceImageView2:
                Dice2_Clicked();
                break;
            case R.id.DiceImageView3:
                Dice3_Clicked();
                break;
            case R.id.DiceImageView4:
                Dice4_Clicked();
                break;
            case R.id.DiceImageView5:
                Dice5_Clicked();
                break;

        }
    }
    public void Dice1_Clicked() {
        if(SelectedDiceorder[0] ==0){//고정이 안되있으면 고정
            SelectedDiceorder[0] =1;
            Dice_order_in(1);
            Selected_Dice_image_in(Diceorder[0]);
        }else if(SelectedDiceorder[0] ==1){//고정되있으면 고정헤제
            SelectedDiceorder[0] =0;
            Dice_order_in(1);
            Dice_image_in(Diceorder[0]);
        }
    }
    public void Dice2_Clicked() {
        if(SelectedDiceorder[1] ==0){//고정이 안되있으면 고정
            SelectedDiceorder[1] =1;
            Dice_order_in(2);
            Selected_Dice_image_in(Diceorder[1]);
        }else if(SelectedDiceorder[1] ==1){//고정되있으면 고정헤제
            SelectedDiceorder[1] =0;
            Dice_order_in(2);
            Dice_image_in(Diceorder[1]);
        }
    }
    public void Dice3_Clicked() {
        if(SelectedDiceorder[2] ==0){//고정이 안되있으면 고정
            SelectedDiceorder[2] =1;
            Dice_order_in(3);
            Selected_Dice_image_in(Diceorder[2]);
        }else if(SelectedDiceorder[2] ==1){//고정되있으면 고정헤제
            SelectedDiceorder[2] =0;
            Dice_order_in(3);
            Dice_image_in(Diceorder[2]);
        }
    }
    public void Dice4_Clicked() {
        if(SelectedDiceorder[3] ==0){//고정이 안되있으면 고정
            SelectedDiceorder[3] =1;
            Dice_order_in(4);
            Selected_Dice_image_in(Diceorder[3]);
        }else if(SelectedDiceorder[3] ==1){//고정되있으면 고정헤제
            SelectedDiceorder[3] =0;
            Dice_order_in(4);
            Dice_image_in(Diceorder[3]);
        }
    }
    public void Dice5_Clicked() {
        if(SelectedDiceorder[4] ==0){//고정이 안되있으면 고정
            SelectedDiceorder[4] =1;
            Dice_order_in(5);
            Selected_Dice_image_in(Diceorder[4]);
        }else if(SelectedDiceorder[4] ==1){//고정되있으면 고정헤제
            SelectedDiceorder[4] =0;
            Dice_order_in(5);
            Dice_image_in(Diceorder[4]);
        }
    }

    public void Aces_Clicked() {//Aces버튼을 누를경우
        //누구의 턴인지 파악
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Aces.getText()) + Integer.parseInt((String) P1Total_score.getText());
            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Aces.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");
            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }
            P1Aces.setEnabled(false);
            player1topitem[0] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Aces.getText()) + Integer.parseInt((String) P2Total_score.getText());
            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Aces.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");
            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }
            P2Aces.setEnabled(false);
            player2topitem[0] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Deuces_Clicked() {//Deuces버튼을 누를경우
        //누구의 턴인지 파악
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Deuces.getText()) + Integer.parseInt((String) P1Total_score.getText());

            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Deuces.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }

            P1Deuces.setEnabled(false);
            player1topitem[1] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Deuces.getText()) + Integer.parseInt((String) P2Total_score.getText());

            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Deuces.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }

            P2Deuces.setEnabled(false);
            player2topitem[1] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Threes_Clicked() {//Threes버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Trees.getText()) + Integer.parseInt((String) P1Total_score.getText());

            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Trees.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }

            P1Trees.setEnabled(false);
            player1topitem[2] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Trees.getText()) + Integer.parseInt((String) P2Total_score.getText());

            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Trees.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }

            P2Trees.setEnabled(false);
            player2topitem[2] = 1;
        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Fours_Clicked() {//Fours버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Fours.getText()) + Integer.parseInt((String) P1Total_score.getText());

            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Fours.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }

            player1topitem[3] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Fours.getText()) + Integer.parseInt((String) P2Total_score.getText());

            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Fours.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }

            player2topitem[3] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Fives_Clicked() {//Fives버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Fives.getText()) + Integer.parseInt((String) P1Total_score.getText());

            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Fives.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }

            P1Fives.setEnabled(false);
            player1topitem[4] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Fives.getText()) + Integer.parseInt((String) P2Total_score.getText());

            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Fives.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }

            P2Fives.setEnabled(false);
            player2topitem[4] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Sixes_Clicked() {//Sixes버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Sixes.getText()) + Integer.parseInt((String) P1Total_score.getText());

            String Subtotalsplit = (String) P1Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P1Sixes.getText()) + Integer.parseInt(Subtotalnum[0]);
            P1Total_score.setText(Integer.toString(score));
            P1Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P1Total_score.getText());
                P1Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P1BounsCheck);
                Bonuscheck.setText("O");
            }

            P1Sixes.setEnabled(false);
            player1topitem[5] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Sixes.getText()) + Integer.parseInt((String) P2Total_score.getText());

            String Subtotalsplit = (String) P2Bonus_check.getText();
            String[] Subtotalnum = Subtotalsplit.split("/");
            int subscore = Integer.parseInt((String) P2Sixes.getText()) + Integer.parseInt(Subtotalnum[0]);
            P2Total_score.setText(Integer.toString(score));
            P2Bonus_check.setText(subscore + "/63");

            if(subscore>=63){
                score = 35+Integer.parseInt((String) P2Total_score.getText());
                P2Total_score.setText(Integer.toString(score));
                TextView Bonuscheck = findViewById(R.id.P2BounsCheck);
                Bonuscheck.setText("O");
            }

            P2Sixes.setEnabled(false);
            player2topitem[5] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Choice_Clicked() {//Choice버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Choice.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1Choice.setEnabled(false);
            player1bottomitem[0] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Choice.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2Choice.setEnabled(false);
            player2bottomitem[0] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();

    }

    public void FourOfAKind_Clicked() {//FourOfAKind버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1FourAKind.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1FourAKind.setEnabled(false);
            player1bottomitem[1] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2FourAKind.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2FourAKind.setEnabled(false);
            player2bottomitem[1] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void FullHouse_Clicked() {//FullHouse버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1FullHouse.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1FullHouse.setEnabled(false);
            player1bottomitem[2] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2FullHouse.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2FullHouse.setEnabled(false);
            player2bottomitem[2] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void LargeStaight_Clicked() {
        if (turnCount % 2 == 0) {
            int score = Integer.parseInt((String) P1LargeStraight.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1LargeStraight.setEnabled(false);
            player1bottomitem[4] = 1;
        } else {
            int score = Integer.parseInt((String) P2LargeStraight.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2LargeStraight.setEnabled(false);
            player2bottomitem[4] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void SmallStraight_Clicked() {//SmallStraight버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1SmallStraight.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1SmallStraight.setEnabled(false);
            player1bottomitem[3] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2SmallStraight.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2SmallStraight.setEnabled(false);
            player2bottomitem[3] = 1;

        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void Yacht_Clicked() {//Yacht버튼을 누를경우
        if (turnCount % 2 == 0) {//player1이면
            //P1 버튼 계산
            int score = Integer.parseInt((String) P1Yacht.getText()) + Integer.parseInt((String) P1Total_score.getText());
            P1Total_score.setText(Integer.toString(score));
            P1Yacht.setEnabled(false);
            player1bottomitem[5] = 1;
        } else {//player2이면
            //P2 버튼 계산
            int score = Integer.parseInt((String) P2Yacht.getText()) + Integer.parseInt((String) P2Total_score.getText());
            P2Total_score.setText(Integer.toString(score));
            P2Yacht.setEnabled(false);
            player2bottomitem[5] = 1;
        }
        //턴카운트를 증가시키고
        turnCount++;
        //다음턴 스타트
        startturn();
    }

    public void calculation() {// 계산함수
        calculation_Aces();//계산적용
        calculation_Deuces();
        calculation_Threes();
        calculation_Fours();
        calculation_Fives();
        calculation_Sixes();
        calculation_Choice();
        calculation_FourofaKind();
        calculation_FullHouse();
        calculation_SmallStraight();
        calculation_LargeStraight();
        calculation_Yacht();


    }

    public void Rolldice() {//주사위 굴리기
        Random roll = new Random();
        int randomnum = 0;

        if(SelectedDiceorder[0] ==0) {//첫번째 주사위가 고정되있지 않으면
            randomnum = roll.nextInt(6) + 1;//랜덤값생성
            Dice_order_in(1);//첫번째 주사위선택
            Dice_image_in(randomnum);//첫번째 주사위의 이미지를 주사위 눈에 맞춰 변경
            Diceorder[0] = randomnum;//Diceorder 배열 [0]에 나왔던 랜덤값 입력
        }


        if(SelectedDiceorder[1] ==0) {
            randomnum = roll.nextInt(6) + 1;
            Dice_order_in(2);
            Dice_image_in(randomnum);
            Diceorder[1] = randomnum;
        }


        if(SelectedDiceorder[2] ==0) {
            randomnum = roll.nextInt(6) + 1;
            Dice_order_in(3);
            Dice_image_in(randomnum);
            Diceorder[2] = randomnum;
        }


        if(SelectedDiceorder[3] ==0) {
            randomnum = roll.nextInt(6) + 1;
            Dice_order_in(4);
            Dice_image_in(randomnum);
            Diceorder[3] = randomnum;
        }


        if(SelectedDiceorder[4] ==0) {
            randomnum = roll.nextInt(6) + 1;
            Dice_order_in(5);
            Dice_image_in(randomnum);
            Diceorder[4] = randomnum;
        }
        calculation();

    }

    public void Dice_order_in(int diceorder) {//몇번째 주사위에 이미지를 넣을것인지 지정
        if (diceorder == 1) {
            imageView = findViewById(R.id.DiceImageView1);
        } else if (diceorder == 2) {
            imageView = findViewById(R.id.DiceImageView2);
        } else if (diceorder == 3) {
            imageView = findViewById(R.id.DiceImageView3);
        } else if (diceorder == 4) {
            imageView = findViewById(R.id.DiceImageView4);
        } else {
            imageView = findViewById(R.id.DiceImageView5);
        }
    }



    public void Dice_image_in(int dicenum) {//랜덤값에 따라 이미지 변경
        if (dicenum == 1) {
            imageView.setImageResource(R.drawable.dice_num1);
        } else if (dicenum == 2) {
            imageView.setImageResource(R.drawable.dice_num2);
        } else if (dicenum == 3) {
            imageView.setImageResource(R.drawable.dice_num3);
        } else if (dicenum == 4) {
            imageView.setImageResource(R.drawable.dice_num4);
        } else if (dicenum == 5) {
            imageView.setImageResource(R.drawable.dice_num5);
        } else {
            imageView.setImageResource(R.drawable.dice_num6);
        }
    }
    public void Selected_Dice_image_in(int dicenum) {//선택된 주사위의 이미지변경
        if (dicenum == 1) {
            imageView.setImageResource(R.drawable.selected_dice_num1);
        } else if (dicenum == 2) {
            imageView.setImageResource(R.drawable.selected_dice_num2);
        } else if (dicenum == 3) {
            imageView.setImageResource(R.drawable.selected_dice_num3);
        } else if (dicenum == 4) {
            imageView.setImageResource(R.drawable.selected_dice_num4);
        } else if (dicenum == 5) {
            imageView.setImageResource(R.drawable.selected_dice_num5);
        } else {
            imageView.setImageResource(R.drawable.selected_dice_num6);
        }
    }

    public void calculation_Aces() {//주사위 이미지에 따라 ACE버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 1) {
                btn_num += 1;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[0] == 0) {
            //player1이면서 player1의 Aces버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1AcesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        } else if ((turnCount % 2 == 1 && player2topitem[0] == 0)) {
            //player2이면서 player2의 Aces버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2AcesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }


    }

    public void calculation_Deuces() {//주사위 이미지에 따라 Deuces버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 2) {
                btn_num += 2;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[1] == 0) {
            //player1이면서 player1의 Deuces버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1DeucesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if ((turnCount % 2 == 1 && player2topitem[1] == 0)) {
            //player2이면서 player2의 Deuces버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2DeucesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }

    public void calculation_Threes() {//주사위 이미지에 따라 Threes버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 3) {
                btn_num += 3;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[2] == 0) {
            //player1이면서 player1의 Threes버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1ThreesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2topitem[2] == 0) {
            //player2이면서 player2의 Threes버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2ThreesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }


    }

    public void calculation_Fours() {//주사위 이미지에 따라 Fours버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 4) {
                btn_num += 4;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[3] == 0) {
            //player1이면서 player1의 Fours버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1FoursBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2topitem[3] == 0) {
            //player2이면서 player2의 Fours버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2FoursBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }

    }

    public void calculation_Fives() {//주사위 이미지에 따라 Fives버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 5) {
                btn_num += 5;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[4] == 0) {
            //player1이면서 player1의 Fives버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1FivesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2topitem[4] == 0) {
            //player2이면서 player2의 Fives버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2FivesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }

    }

    public void calculation_Sixes() {//주사위 이미지에 따라 Sixes버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {
            if (Diceorder[i] == 6) {
                btn_num += 6;
            }
        }
        if (turnCount % 2 == 0 && player1topitem[5] == 0) {
            //player1이면서 player1의 Sixes버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1SixesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2topitem[5] == 0) {
            //player2이면서 player2의 Sixes버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2SixesBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }

    public void calculation_Choice() {//주사위 이미지에 따라 Choice버튼 값 지정
        int btn_num = 0;
        for (int i = 0; i < Diceorder.length; i++) {

            btn_num += Diceorder[i];
        }

        if (turnCount % 2 == 0 && player1bottomitem[0] == 0) {
            //player1이면서 player1의 Choice버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1ChoiceBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2bottomitem[0] == 0) {
            //player2이면서 player2의 Choice버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2ChoiceBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }

    public void calculation_FourofaKind() {//주사위 이미지에 따라 FourofaKind버튼 값 지정
        int btn_num = 0;
        int first_check = 0;
        int last_check = 0;
        for (int i = 0; i <= 3; i++) {
            if (Diceorder[0] == Diceorder[i + 1]) {
                first_check++;
            }
        }
        for (int j = 0; j <= 3; j++) {
            if (Diceorder[4] == Diceorder[j]) {
                last_check++;
            }
        }
        if ((first_check >= 3) || (last_check >= 3)) {
            for (int i = 0; i < Diceorder.length; i++) {
                btn_num += Diceorder[i];
            }
        } else {
            btn_num = 0;
        }
        if (turnCount % 2 == 0 && player1bottomitem[1] == 0) {
            //player1이면서 player1의 FourofaKind버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1FourOfaKindBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2bottomitem[1] == 0) {
            //player2이면서 player2의 FourofaKind버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2FourOfaKindBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }
    }

    public void calculation_FullHouse() {
        int btn_num = 0;
        int[] dice = {1, 2, 3, 4, 5, 6};
        int[] dice_cnt = {0, 0, 0, 0, 0, 0};
        int FullHouse = 0;

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (Diceorder[j] == dice[i]) {
                    dice_cnt[i]++;
                }
            }
        }
        for (int i = 0; i <= 5; i++) {
            if (dice_cnt[i] == 3) {
                for (int j = 0; j <= 5; j++) {
                    if (dice_cnt[j] == 2) {
                        FullHouse = 1;

                    }
                }
            }
        }
        if (FullHouse == 1) {
            for (int i = 0; i < Diceorder.length; i++) {
                btn_num += Diceorder[i];
            }
        } else {
            btn_num = 0;
        }
        if (turnCount % 2 == 0 && player1bottomitem[2] == 0) {
            //player1이면서 player1의 FullHouse버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1FullHouseBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2bottomitem[2] == 0) {
            //player2이면서 player2의 FullHouse버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2FullHouseBtn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }


    }

    public void calculation_SmallStraight() {

        int[] dice = {1, 2, 3, 4, 5, 6};
        int[] dice_cnt = {0, 0, 0, 0, 0, 0};
        int Small = 0;
        int btn_num = 0;

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (Diceorder[j] == dice[i]) {
                    dice_cnt[i] = 1;
                }
            }
        }
        if (dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1 && dice_cnt[5] == 1)
            Small = 1;

        if (dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1)
            Small = 1;

        if (dice_cnt[0] == 1 && dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1)
            Small = 1;

        if (dice_cnt[0] == 0 && dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1 && dice_cnt[5] == 1)
            Small = 1;

        if (dice_cnt[0] == 1 && dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1 && dice_cnt[5] == 0)
            Small = 1;

        if (Small == 1) {
            btn_num = 15;

        } else {
            btn_num = 0;

        }
        if (turnCount % 2 == 0 && player1bottomitem[3] == 0) {
            //player1이면서 player1의 SmallStraight버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1SmallStraightBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2bottomitem[3] == 0) {
            //player2이면서 player2의 SmallStraight버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2SmallStraightBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }

    public void calculation_LargeStraight() {

        int[] dice = {1, 2, 3, 4, 5, 6};
        int[] dice_cnt = {0, 0, 0, 0, 0, 0};
        int Small = 0;
        int btn_num = 0;

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (Diceorder[j] == dice[i]) {
                    dice_cnt[i] = 1;
                }
            }
        }

        if (dice_cnt[0] == 0 && dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1 && dice_cnt[5] == 1)
            Small = 1;

        if (dice_cnt[0] == 1 && dice_cnt[1] == 1 && dice_cnt[2] == 1 && dice_cnt[3] == 1 && dice_cnt[4] == 1 && dice_cnt[5] == 0)
            Small = 1;
        if (Small == 1) {
            btn_num = 25;

        } else {
            btn_num = 0;

        }
        if (turnCount % 2 == 0 && player1bottomitem[4] == 0) {
            //player1이면서 player1의 LargeStraight버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1LargeStraightBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        } else if (turnCount % 2 == 1 && player2bottomitem[4] == 0) {
            //player2이면서 player2의 LargeStraight버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2LargeStraightBtn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }
    }

    public void calculation_Yacht() {
        int btn_num = 0;
        int first_check = 0;

        for (int i = 0; i <= 3; i++) {
            if (Diceorder[0] == Diceorder[i + 1]) {
                first_check++;
            }
        }
        if (turnCount % 2 == 0 && player1bottomitem[5] == 0) {
            //player1이면서 player1의 Yacht버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P1YachtBtn);
        } else if (turnCount % 2 == 1 && player2bottomitem[5] == 0) {
            //player2이면서 player1의 Yacht버튼이 아직 안눌렸으면
            btn_text_edit = findViewById(R.id.P2YachtBtn);
        }

        if (first_check >= 4) {
            btn_num = 50;
            btn_text_edit.setText(Integer.toString(btn_num));
        } else {
            btn_text_edit.setText(Integer.toString(btn_num));

        }

    }


}