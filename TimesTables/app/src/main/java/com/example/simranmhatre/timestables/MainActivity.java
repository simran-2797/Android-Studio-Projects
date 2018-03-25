package com.example.simranmhatre.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    public void generateTable(int progress)
    {
        ArrayList<String> table = new ArrayList<String>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,table);

        listview.setAdapter(arrayAdapter);

        for(int i =1; i<=10; i++)
        {
            table.add(Integer.toString(i * progress));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listview = findViewById(R.id.listView);

        seekBar.setMax(20);
        seekBar.setProgress(10);//Initial value

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int time;
                if(i<min)
                {
                    time=min;
                    seekBar.setProgress(min);
                }
                else
                    time = i;
                generateTable(time);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTable(10);


    }
}
