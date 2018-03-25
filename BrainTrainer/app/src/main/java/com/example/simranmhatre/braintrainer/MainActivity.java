package com.example.simranmhatre.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button go,op1,op2,op3,op4,playAgain;
    TextView sum,correct,scoreDisplay,timer;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions=0;


    public void playAgain(View v) {


            score = 0;
            numberOfQuestions = 0;
            scoreDisplay.setText("0/0");
            timer.setText("30s");
            correct.setText("");


            generatequestions();

            new CountDownTimer(30100, 1000) {

                @Override
                public void onTick(long l) {
                    timer.setText(String.valueOf(l / 1000) + "s");
                }

                @Override
                public void onFinish() {
                    playAgain.setVisibility(View.VISIBLE);
                    correct.setText("YOUR SCORE: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                    timer.setText("0s");


                }
            }.start();

        }



    public void generatequestions() {


            Random rand = new Random();

            int a = rand.nextInt(1000);
            int b = rand.nextInt(1000);


            sum.setText(Integer.toString(a) + " + " + Integer.toString(b));


            locationOfCorrectAnswer = rand.nextInt(4);

            answers.clear();
            int wrongAnswer;

            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    Log.i("hello", Integer.toString(i));
                    int sum = a + b;
                    answers.add(sum);
                } else {
                    wrongAnswer = rand.nextInt(2000);
                    while (wrongAnswer == a + b) {
                        wrongAnswer = rand.nextInt(2000);
                    }
                    answers.add(wrongAnswer);
                }

            }

            op1.setText(Integer.toString(answers.get(0)));
            op2.setText(Integer.toString(answers.get(1)));
            op3.setText(Integer.toString(answers.get(2)));
            op4.setText(Integer.toString(answers.get(3)));
        }

    public void hide(View view){


        relativeLayout.setVisibility(View.VISIBLE);
        go.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.playagain));

    }

    public void choose(View v){
        if(v.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){

            score++;
            correct.setText("Correct!!");
        }
        else
        {
            correct.setText("Incorrect!!");
        }
        numberOfQuestions++;
        scoreDisplay.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generatequestions();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = findViewById(R.id.go);
        sum = findViewById(R.id.textView3);
        correct=findViewById(R.id.correctTextView);
        timer=findViewById(R.id.timer);
        scoreDisplay=findViewById(R.id.score);
        playAgain = findViewById(R.id.playagain);
        relativeLayout = findViewById(R.id.gamestart);
        op1 = findViewById(R.id.option1);
        op2 = findViewById(R.id.option2);
        op3 = findViewById(R.id.option3);
        op4 = findViewById(R.id.option4);



    }
}
