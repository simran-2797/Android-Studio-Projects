package com.example.simranmhatre.highorlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int Random_number;

    public void Guess(View v){
        EditText get = findViewById(R.id.editText);
        String value = get.getText().toString();
        int intvalue = Integer.parseInt(value);
        if(intvalue < Random_number){
            Toast.makeText(getApplicationContext(), "The entered number is smaller.",
                    Toast.LENGTH_LONG).show();
        }
        if(intvalue >Random_number){
            Toast.makeText(getApplicationContext(), "The entered number is bigger.",
                    Toast.LENGTH_LONG).show();
        }
        if (intvalue ==Random_number){
            Toast.makeText(getApplicationContext(), "Correctly guesses!!",
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rn = new Random();
        Random_number = rn.nextInt(11)+0;
    }
}
