package com.example.simranmhatre.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    /*String winner = "Donut";

    boolean over;

    boolean is_active = true;

     int which_player = 0; //o is donut and 1 is cake

    int[] game_state = {2,2,2,2,2,2,2,2,2};

    int[][] wining_positions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

     public void appear(View v) {

         ImageView counter = (ImageView) v;

         int tappercounter = Integer.parseInt(counter.getTag().toString());
         if (game_state[tappercounter] == 2 && is_active) {

             game_state[tappercounter] = which_player;
             counter.setTranslationY(-1000f);
             if (which_player == 0) {
                 counter.setImageResource(R.drawable.donut);
                 which_player = 1;
             } else {
                 counter.setImageResource(R.drawable.cake);
                 which_player = 0;
             }
             counter.animate().translationYBy(1000f).rotation(360).setDuration(500);

         for (int[] wining_position : wining_positions) {
             //who won

             if (game_state[wining_position[0]] == game_state[wining_position[1]]
                     && game_state[wining_position[1]] == game_state[wining_position[2]]
                     && game_state[wining_position[0]] != 2) {
                 is_active = false;

                 if (game_state[wining_position[0]] == 0)
                 {
                     winner = "Donut";
                 }
                 else {
                     winner = "Cake";
                 }

                 LinearLayout layout = findViewById(R.id.ll);
                 TextView t = findViewById(R.id.textView);
                 t.setText(winner + " Won!!!!");
                 layout.setVisibility(View.VISIBLE);
             } else {
                 over=true;
                 for (int counter_state : game_state)
                 {
                     if(counter_state == 2){
                         over = false ;
                     }
                 }
                 if(over)
                 {
                     LinearLayout layout = findViewById(R.id.ll);
                     TextView t = findViewById(R.id.textView);
                     t.setText("It's a draw!!!");
                     layout.setVisibility(View.VISIBLE);
                 }
             }

             }

         }

         }


     public void PlayAgain(View v){
         LinearLayout layout = findViewById(R.id.ll);
         layout.setVisibility(View.INVISIBLE);
         which_player = 0;
         is_active=true;
         int i;
         for(i=0;i<=8;i++){
             game_state[i]=2;
         }
         GridLayout gridLayout = findViewById(R.id.grid);
         for(i =0; i<=8 ; i++)
         {
             ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

         }

     }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
