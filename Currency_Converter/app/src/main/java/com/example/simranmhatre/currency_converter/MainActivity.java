package com.example.simranmhatre.currency_converter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public void dollars(View v){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);

    }
    public void euros(View v){
        Intent intent = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);

    }
    public void bath(View v){
        Intent intent = new Intent(MainActivity.this,Main4Activity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
