package com.example.simranmhatre.guessthecelebrity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
    }

    public void hello(View v)
    {
        Toast.makeText(getApplicationContext(),"heloo",Toast.LENGTH_LONG).show();
    }
}
