package com.example.mathquiz;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    TextView timerText;
    TextView quesText;
    TextView scoreBoard;
    TextView Result;
    Button start;
    Button stop;
    GridLayout grid;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    int rand1;
    int rand2;
    int Answer;
    int h=8;


    Random rand = new Random();

    int[] ans = {0,0,0,0};
    int Score = 0;
    int ques = 0;


    int rand6;

    public void settingButtons(){
        quesText = (TextView)findViewById(R.id.quesView);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        question();
    }


    public void question(){

        rand1= rand.nextInt(50);
        rand2= rand.nextInt(50);
        rand6 = rand.nextInt(3);
        h=rand6;
        Answer = rand1+rand2;

        for(int i =0; i<=3 ; i++){
            if(i==rand6){
                ans[rand6]=Answer;
                 }
                 else{
                     ans[i]=rand.nextInt(100);
            }
        }

        quesText.setText(Integer.toString(rand1) + " + " + Integer.toString(rand2));
        b1.setText(Integer.toString(ans[0]));
        b2.setText(Integer.toString(ans[1]));
        b3.setText(Integer.toString(ans[2]));
        b4.setText(Integer.toString(ans[3]));

    }
   /* public void systemanswer() {

        int[] butArray = {0, 0, 0, 0};
        butArray[0] = b1.getId();
        butArray[1] = b2.getId();
        butArray[2] = b3.getId();
        butArray[3] = b4.getId();
        for (int i = 0; i <= 3; i++) {
            if (butArray[i] == Answer) {
                if (i == 0) {
                   h = b1.getId();
                } else if (i == 1) {
                    h = b2.getId();
                } else if (i == 2) {
                    h =  b2.getId();
                } else if (i == 3) {
                    h = b2.getId();
                }

            }
        }


    }
    */


    public void chooseButton(View view){
       //systemanswer();
        if(view.getTag().toString().equals(Integer.toString(h))){
        Score++;
        ques++;
        }else{
            ques++;
        }
        System.out.println("ques" + Integer.toString(ques));
        question();
        scoreBoard = (TextView)findViewById(R.id.Score);
        scoreBoard.setText(String.valueOf(Score)+ "/" + String.valueOf(ques));
    }


    public void startFunction(View view){
        timer.start();
        settingButtons();
        scoreBoard = (TextView)findViewById(R.id.Score);
        scoreBoard.setText(String.valueOf(Score)+ "/" + String.valueOf(ques));
        stop = (Button)findViewById(R.id.stop);
        Result.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.VISIBLE);

    }
    public void stopFunction(View view){
        timer.cancel();
        Result = (TextView)findViewById(R.id.Result);
        Result.setVisibility(View.VISIBLE);
        Result.setText(String.valueOf(Score)+ "/" + String.valueOf(ques));
        stop.setVisibility(View.INVISIBLE);
        Score=0;
        ques=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Result = (TextView)findViewById(R.id.Result);
        Result.setVisibility(View.VISIBLE);




        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerText = (TextView)findViewById(R.id.Timer);
                timerText.setText("00:" + String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
            Result = (TextView)findViewById(R.id.Result);
            Result.setVisibility(View.VISIBLE);
            Result.setText(String.valueOf(Score)+ "/" + String.valueOf(ques));


            }
        };

    }
}
