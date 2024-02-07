package com.example.mathbraintraniner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
  Button goButton;
  Button button0,button1,button2,button3,resetButton;
  ConstraintLayout gameLayout;
  TextView sumText,resultText,scoreText,timerText;
  ArrayList<Integer> ans;
    int locOfAns,score=0,numQues=0;

    public void setGoButton(View view) {

        goButton.setVisibility(View. INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        startGame();
    }
    public void startGame(){
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        score=0;
        numQues=0;
        scoreText.setText("0/0");
        timerText.setText("30s");
       resultText.setVisibility((View.INVISIBLE));
        resetButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerText.setText(l/1000+"s");
            }

            @Override
            public void onFinish() {
                resultText.setText("Done !!! \n"+scoreText.getText());
                resetButton.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);

            }
        }.start();
        newQuestion();

    }
    public void resetGame(View view){
          startGame();
    }


      public void newQuestion() {
        Random rand = new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sumText.setText(a+" + "+b);
         locOfAns= rand.nextInt(4);
         ans.clear();
        for(int i=0;i<4;i++){
            if(i==locOfAns){
                ans.add(a+b);
            }else{
                int wrongANs=rand.nextInt(41);
                while(wrongANs==a+b){
                    wrongANs=rand.nextInt(41);
                }
                ans.add(wrongANs);

            }        }

        button0.setText(Integer.toString(ans.get(0)));
        button1.setText(Integer.toString(ans.get(1)));
        button2.setText(Integer.toString(ans.get(2)));
        button3.setText(Integer.toString(ans.get(3)));
    }
    public void chooseAns(View view){
        resultText.setVisibility(View.VISIBLE);
        if(Integer.toString(locOfAns).equals(view.getTag().toString())){
            resultText.setText("Correct :)");
            score++;
            newQuestion();
        }else{
            resultText.setText("Wrong :(");
        }
        numQues++;
        scoreText.setText(score+"/"+numQues);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.goButton);
        gameLayout=findViewById(R.id.gameLayout);
        timerText=findViewById(R.id.timerTextview);
        resetButton=findViewById(R.id.reset);

        resultText=findViewById(R.id.resultTextView);
        scoreText=findViewById(R.id.scoreTextView);
        ans = new ArrayList<>();
       // resultText.setVisibility(View.INVISIBLE);
        sumText=findViewById(R.id.sumTextview);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);




    }
}