package com.inhatc.achtdice;

import androidx.appcompat.app.AppCompatActivity;

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
    Button btn_text_Aces = null;
    Button btn_text_Deuces = null;
    Button btn_text_Threes = null;
    Button btn_text_Fours = null;
    Button btn_text_Fives = null;
    Button btn_text_Sixes = null;
    Button btn_text_Choice = null;
    Button btn_text_fourofaKind = null;
    Button btn_text_FullHouse = null;
    Button btn_text_LargeStraight = null;
    Button btn_text_SmallStraight = null;
    Button btn_text_Yacht = null;
    TextView Total_score= null;
    TextView Subtotal= null;
    TextView Bonus_check= null;



    int trunCount = 0; // 게임을 하면 턴이 필요하기 때문에 턴 카운트 숫자
    int rolldicecount=0; // 주사위굴리기 사용 제한은 2번이다.
    int player1total =0;//Player1의 최종 점수
    int player2total =0;//Player2의 최종 점수
    int trunCountlbl = 0;//레이블에 보여줄 턴 카운트
    int[] player1topitem = {0,0,0,0,0,0};//플레이어1 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player2topitem = {0,0,0,0,0,0};//플레이어2 의 상단 항목 활성화 여부를 체크 해주는 배열 선언
    int[] player1bottomitem = {0,0,0,0,0,0};//플레이어1 의 하단 항목 활성화 여부를 체크해주는 배열 선언
    int[] player2bottomitem = {0,0,0,0,0,0};//플레이어2 의 하단 항목 활성화 여부를 체크해주는 배열 선언
    int player1bonusscore =0; // 플레이어1이 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int player2bonusscore = 0;//플레이어2가 상단 항목 점수가 63이상이면 35점을 추가로 흭득한다.
    int[] Diceorder = {0,0,0,0,0};//주사위 순서에 따라 저장되는 값 [0]에는 왼쪽에서 첫번째 주사위값이 저장됨


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplaying2);
        btn_text_Aces=(Button)findViewById(R.id.Aces_btn);
        btn_text_Deuces=(Button)findViewById(R.id.Deuces_btn);
        btn_text_Threes=(Button)findViewById(R.id.Threes_btn);
        btn_text_Fours=(Button)findViewById(R.id.Fours_btn);
        btn_text_Fives=(Button)findViewById(R.id.Fives_btn);
        btn_text_Sixes=(Button)findViewById(R.id.Sixes_btn);
        btn_text_Choice=(Button)findViewById(R.id.Choice_btn);
        btn_text_fourofaKind=(Button)findViewById(R.id.FourOfaKind_btn);
        btn_text_FullHouse=(Button)findViewById(R.id.FullHouse_btn);
        btn_text_SmallStraight=(Button)findViewById(R.id.SmallStraight_btn);
        btn_text_LargeStraight=(Button)findViewById(R.id.LargeStraight_btn);
        btn_text_Yacht=(Button)findViewById(R.id.Yacht_btn);

        btn_text_Aces.setEnabled(false);
        btn_text_Deuces.setEnabled(false);
        btn_text_Threes.setEnabled(false);
        btn_text_Fours.setEnabled(false);
        btn_text_Fives.setEnabled(false);
        btn_text_Sixes.setEnabled(false);

        btn_text_Choice.setEnabled(false);
        btn_text_fourofaKind.setEnabled(false);
        btn_text_FullHouse.setEnabled(false);
        btn_text_SmallStraight.setEnabled(false);
        btn_text_LargeStraight.setEnabled(false);
        btn_text_Yacht.setEnabled(false);

        Total_score = (TextView)findViewById(R.id.Total_Score);
        Subtotal = (TextView)findViewById(R.id.Subtotal);
        Bonus_check = (TextView)findViewById(R.id.Bonus_check);




    }

    public void onButtonClick(View v) {
        switch (v.getId()){
            case R.id.Aces_btn :
                Aces_Clicked();
                break ;
            case R.id.Deuces_btn:
                Deuces_Clicked();
                break;
            case R.id.Threes_btn:
                Threes_Clicked();
                break;
            case R.id.Fours_btn:
                Fours_Clicked();
                break;
            case R.id.Fives_btn:
                Fives_Clicked();
                break;
            case R.id.Sixes_btn:
                Sixes_Clicked();
                break;
            case R.id.Choice_btn:
                Choice_Clicked();
                break;
            case R.id.FourOfaKind_btn:
                fourofaKind_Clicked();
                break;
            case R.id.FullHouse_btn:
                FullHouse_Clicked();
                break;
            case R.id.SmallStraight_btn:
                SmallStraight_Clicked();
                break;
            case R.id.LargeStraight_btn:
                LargeStaight_Clicked();
                break;
            case R.id.Yacht_btn:
                Yacht_Clicked();
                break;

        }
    }
    public void Aces_Clicked(){

        int score = Integer.parseInt((String) btn_text_Aces.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Aces.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Aces.setEnabled(false);
        player1topitem[0] = 1;
    }
    public void Deuces_Clicked(){

        int score = Integer.parseInt((String) btn_text_Deuces.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Deuces.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Deuces.setEnabled(false);
        player1topitem[1] = 1;
    }
    public void Threes_Clicked(){

        int score = Integer.parseInt((String) btn_text_Threes.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Threes.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Threes.setEnabled(false);
        player1topitem[2] = 1;
    }
    public void Fours_Clicked(){

        int score = Integer.parseInt((String) btn_text_Fours.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Fours.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Fours.setEnabled(false);
        player1topitem[3] = 1;
    }
    public void Fives_Clicked(){

        int score = Integer.parseInt((String) btn_text_Fives.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Fives.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Fives.setEnabled(false);
        player1topitem[4] = 1;
    }
    public void Sixes_Clicked(){

        int score = Integer.parseInt((String) btn_text_Sixes.getText())+Integer.parseInt((String) Total_score.getText());

        String Subtotalsplit = (String)Subtotal.getText();
        String[] Subtotalnum = Subtotalsplit.split("/");
        int subscore =Integer.parseInt((String) btn_text_Sixes.getText())+Integer.parseInt(Subtotalnum[0]);
        Total_score.setText(Integer.toString(score));
        Subtotal.setText(Integer.toString(subscore)+"/63");

        btn_text_Sixes.setEnabled(false);
        player1topitem[5] = 1;
    }

    public void Choice_Clicked(){
        int score = Integer.parseInt((String) btn_text_Choice.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_Choice.setEnabled(false);
        player1bottomitem[0] = 1;
    }
    public void fourofaKind_Clicked(){
        int score = Integer.parseInt((String) btn_text_fourofaKind.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_fourofaKind.setEnabled(false);
        player1bottomitem[1] = 1;
    }
    public void FullHouse_Clicked(){
        int score = Integer.parseInt((String) btn_text_FullHouse.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_FullHouse.setEnabled(false);
        player1bottomitem[2] = 1;
    }
    public void LargeStaight_Clicked(){
        int score = Integer.parseInt((String) btn_text_LargeStraight.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_LargeStraight.setEnabled(false);
        player1bottomitem[4] = 1;
    }
    public void SmallStraight_Clicked(){
        int score = Integer.parseInt((String) btn_text_SmallStraight.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_SmallStraight.setEnabled(false);
        player1bottomitem[3] = 1;
    }
    public void Yacht_Clicked(){
        int score = Integer.parseInt((String) btn_text_Yacht.getText())+Integer.parseInt((String) Total_score.getText());
        Total_score.setText(Integer.toString(score));
        btn_text_Yacht.setEnabled(false);
        player1bottomitem[5] = 1;
    }


    public void calculation(){// 계산함수
        if(player1topitem[0]==0)//버튼이 초기화된 상태일 때만
            calculation_Aces();//계산적용
        if(player1topitem[1]==0)
            calculation_Deuces();
        if(player1topitem[2]==0)
            calculation_Threes();
        if(player1topitem[3]==0)
            calculation_Fours();
        if(player1topitem[4]==0)
            calculation_Fives();
        if(player1topitem[5]==0)
            calculation_Sixes();

        if(player1bottomitem[0]==0)
            calculation_Choice();
        if(player1bottomitem[1]==0)
            calculation_fourofaKind();
        if(player1bottomitem[2]==0)
            calculation_FullHouse();
        if(player1bottomitem[3]==0)
            calculation_SmallStraight();
        if(player1bottomitem[4]==0)
            calculation_LargeStraight();
        if(player1bottomitem[5]==0)
            calculation_Yacht();

    }
    public void Rolldice(View view){//주사위 굴리기
        Random roll = new Random();
        int randomnum=0;
        randomnum = roll.nextInt(6)+1;//랜덤값생성
        randomnum = 1;
        Dice_order_in(1);//첫번째 주사위선택
        Dice_image_in(randomnum);//첫번째 주사위의 이미지를 주사위 눈에 맞춰 변경
        Diceorder[0]= randomnum;//Diceorder 배열 [0]에 나왔던 랜덤값 입력

        randomnum = roll.nextInt(6)+1;
        randomnum = 1;
        Dice_order_in(2);
        Dice_image_in(randomnum);
        Diceorder[1]= randomnum;

        randomnum = roll.nextInt(6)+1;
        randomnum = 1;
        Dice_order_in(3);
        Dice_image_in(randomnum);
        Diceorder[2]= randomnum;

        randomnum = roll.nextInt(6)+1;
        randomnum = 6;
        Dice_order_in(4);
        Dice_image_in(randomnum);
        Diceorder[3]= randomnum;

        randomnum = roll.nextInt(6)+1;
        randomnum = 1;
        Dice_order_in(5);
        Dice_image_in(randomnum);
        Diceorder[4]= randomnum;

        calculation();

        if(player1topitem[0]==0)//버튼이 눌리기전일때만
            btn_text_Aces.setEnabled(true);//버튼활성화'
        if(player1topitem[1]==0)//버튼이 눌리기전일때만
            btn_text_Deuces.setEnabled(true);//버튼활성화
        if(player1topitem[2]==0)
            btn_text_Threes.setEnabled(true);
        if(player1topitem[3]==0)
            btn_text_Fours.setEnabled(true);
        if(player1topitem[4]==0)
            btn_text_Fives.setEnabled(true);
        if(player1topitem[5]==0)
            btn_text_Sixes.setEnabled(true);

        if(player1bottomitem[0]==0)//버튼이 눌리기전일때만
            btn_text_Choice.setEnabled(true);//버튼활성화'
        if(player1bottomitem[1]==0)//버튼이 눌리기전일때만
            btn_text_fourofaKind.setEnabled(true);//버튼활성화'
        if(player1bottomitem[2]==0)//버튼이 눌리기전일때만
            btn_text_FullHouse.setEnabled(true);//버튼활성화'
        if(player1bottomitem[3]==0)//버튼이 눌리기전일때만
            btn_text_SmallStraight.setEnabled(true);//버튼활성화'
        if(player1bottomitem[4]==0)//버튼이 눌리기전일때만
            btn_text_LargeStraight.setEnabled(true);//버튼활성화'
        if(player1bottomitem[5]==0)//버튼이 눌리기전일때만
            btn_text_Yacht.setEnabled(true);//버튼활성화'
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
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 1){
                btn_num += 1;
            }
            btn_text_edit =(Button)findViewById(R.id.Aces_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Deuces() {//주사위 이미지에 따라 Deuces버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 2){
                btn_num += 2;
            }
            btn_text_edit =(Button)findViewById(R.id.Deuces_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Threes() {//주사위 이미지에 따라 Threes버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 3){
                btn_num += 3;
            }
            btn_text_edit =(Button)findViewById(R.id.Threes_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Fours() {//주사위 이미지에 따라 Fours버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 4){
                btn_num += 4;
            }
            btn_text_edit =(Button)findViewById(R.id.Fours_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Fives() {//주사위 이미지에 따라 Fives버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 5){
                btn_num += 5;
            }
            btn_text_edit =(Button)findViewById(R.id.Fives_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Sixes() {//주사위 이미지에 따라 Sixes버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++){
            if(Diceorder[i] == 6){
                btn_num += 6;
            }
            btn_text_edit =(Button)findViewById(R.id.Sixes_btn);

            btn_text_edit.setText(Integer.toString(btn_num));
        }

    }
    public void calculation_Choice() {//주사위 이미지에 따라 Choice버튼 값 지정
        int btn_num =0;
        for(int i=0; i<Diceorder.length; i++) {

            btn_num += Diceorder[i];
        }
            btn_text_edit =(Button)findViewById(R.id.Choice_btn);

            btn_text_edit.setText(Integer.toString(btn_num));


    }
    public void calculation_fourofaKind() {//주사위 이미지에 따라 Choice버튼 값 지정
        int btn_num =0;
        int first_check=0;
        int last_check=0;
        for(int i=0; i<=3; i++){
            if(Diceorder[0]==Diceorder[i+1]){
                first_check ++;
            }
        }
        for(int j=0; j<=3; j++){
            if(Diceorder[4]==Diceorder[j]){
                last_check ++;
            }
        }
        if((first_check >= 3 )||( last_check>=3)){
            for(int i=0; i<Diceorder.length; i++) {
                btn_num += Diceorder[i];
            }
            btn_text_edit =(Button)findViewById(R.id.FourOfaKind_btn);
            btn_text_edit.setText(Integer.toString(btn_num));
        }else {
            btn_text_edit =(Button)findViewById(R.id.FourOfaKind_btn);
            btn_text_edit.setText(Integer.toString(0));

            }
    }
    public void calculation_FullHouse() {
        int btn_num =0;
        int[] dice = {1,2,3,4,5,6};
        int[] dice_cnt = {0,0,0,0,0,0};
        int FullHouse = 0;

        for(int i=0; i<=5; i++){
            for(int j=0; j<=4; j++){
                if(Diceorder[j]==dice[i]){
                    dice_cnt[i] ++;
                }
            }
        }
        for(int i=0; i<=5; i++) {
            if (dice_cnt[i] == 3) {
                for (int j = 0; j <= 5; j++) {
                    if (dice_cnt[j] == 2) {
                        FullHouse = 1;

                    }
                }
            }
        }

        if(FullHouse==1){
            for(int i=0; i<Diceorder.length; i++) {
                btn_num += Diceorder[i];
            }
            btn_text_edit =(Button)findViewById(R.id.FullHouse_btn);
            btn_text_edit.setText(Integer.toString(btn_num));

        }else {
            btn_text_edit =(Button)findViewById(R.id.FullHouse_btn);
            btn_text_edit.setText(Integer.toString(0));

        }


    }
    public void calculation_SmallStraight() {

        int[] dice = {1,2,3,4,5,6};
        int[] dice_cnt = {0,0,0,0,0,0};
        int Small = 0;

        for(int i=0; i<=5; i++){
            for(int j=0; j<=4; j++){
                if(Diceorder[j]==dice[i]){
                    dice_cnt[i] =1;
                }
            }
        }
        if(dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 && dice_cnt[5] == 1)
            Small =1;

        if(dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 )
            Small =1;

        if(dice_cnt[0]==1 && dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 )
            Small =1;

        if(dice_cnt[0]==0 && dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 && dice_cnt[5] == 1)
            Small =1;

        if(dice_cnt[0]==1 && dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 && dice_cnt[5] == 0)
            Small =1;

        btn_text_edit =(Button)findViewById(R.id.SmallStraight_btn);
        if(Small==1){
            btn_text_edit.setText(Integer.toString(15));
        }else{
            btn_text_edit.setText(Integer.toString(0));
        }
    }
    public void calculation_LargeStraight() {

        int[] dice = {1,2,3,4,5,6};
        int[] dice_cnt = {0,0,0,0,0,0};
        int Small = 0;

        for(int i=0; i<=5; i++){
            for(int j=0; j<=4; j++){
                if(Diceorder[j]==dice[i]){
                    dice_cnt[i] =1;
                }
            }
        }

        if(dice_cnt[0]==0 && dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 && dice_cnt[5] == 1)
            Small =1;

        if(dice_cnt[0]==1 && dice_cnt[1] == 1 && dice_cnt[2]==1 && dice_cnt[3] == 1 && dice_cnt[4]==1 && dice_cnt[5] == 0)
            Small =1;

        btn_text_edit =(Button)findViewById(R.id.LargeStraight_btn);
        if(Small==1){
            btn_text_edit.setText(Integer.toString(25));
        }else{
            btn_text_edit.setText(Integer.toString(0));
        }
    }
    public void calculation_Yacht(){
        int btn_num =0;
        int first_check=0;

        for(int i=0; i<=3; i++){
            if(Diceorder[0]==Diceorder[i+1]){
                first_check ++;
            }
        }

        if(first_check>=4){
            for(int i=0; i<Diceorder.length; i++) {
                btn_num += Diceorder[i];
            }
            btn_text_edit =(Button)findViewById(R.id.Yacht_btn);
            btn_text_edit.setText(Integer.toString(50));
        }else {
            btn_text_edit =(Button)findViewById(R.id.Yacht_btn);
            btn_text_edit.setText(Integer.toString(0));

        }

    }


}