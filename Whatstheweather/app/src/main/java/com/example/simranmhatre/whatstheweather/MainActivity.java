package com.example.simranmhatre.whatstheweather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    TextView resultTextView;


    public void getWeather(View v){
        String cityname = cityName.getText().toString();
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute("http://samples.openweathermap.org/data/2.5/weather?q="+cityname+"&appid=b50aa988725ca9430fb556e973cfbbc8");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityName = findViewById(R.id.cityname);
        resultTextView = findViewById(R.id.result);
    }

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            String result="";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while(data != -1)
                {
                    char current = (char) data;
                    result = result + current;
                    data = reader.read();

                }
                return result;
            }
            catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONObject jsonObject = new JSONObject(s);
                String weather = jsonObject.getString("weather");
                JSONArray arr = new JSONArray(weather);
                for( int i =0; i < arr.length(); i++)
                {
                    JSONObject jsonObject1 = arr.getJSONObject(i);

                    Log.i("main",jsonObject1.getString("main"));
                    Log.i("Description",jsonObject1.getString("description"));
                    resultTextView.setText("Main : " + jsonObject1.getString("main"));
                    resultTextView.setText("Description : " + jsonObject1.getString("description"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
