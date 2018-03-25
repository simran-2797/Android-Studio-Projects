package com.example.simranmhatre.newsreader;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> content = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    SQLiteDatabase db;

    public class DownloadTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
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
                JSONArray arr = new JSONArray(result);
                int number = 20;
                if(arr.length()<20)
                {
                    number = arr.length();
                }
                db.execSQL("DELETE FROM articles");
                for(int i =0; i < number; i++)
                {
                    String id = arr.getString(i);

                    url = new URL("https://hacker-news.firebaseio.com/v0/item/" + id +".json?print=pretty");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    in = urlConnection.getInputStream();
                    reader = new InputStreamReader(in);
                    data = reader.read();
                    String articleInfo = "";
                    while (data != -1)
                    {
                        char current = (char) data;
                        articleInfo = articleInfo + current;
                        data = reader.read();

                    }
                    JSONObject jsonObject = new JSONObject(articleInfo);


                    if(!jsonObject.isNull("title") && !jsonObject.isNull("url")) {
                        String aTitle = jsonObject.getString("title");
                        String aURL = jsonObject.getString("url");

                        url = new URL(aURL);
                        urlConnection = (HttpURLConnection) url.openConnection();
                        in = urlConnection.getInputStream();
                        reader = new InputStreamReader(in);
                        data = reader.read();
                        String content = "";
                        while (data != -1)
                        {
                            char current = (char) data;
                            content = content + current;
                            data = reader.read();

                        }
                        Log.i("Content",content);

                        String sql ="INSERT INTO articles (articleid, title, content) VALUES (?, ?, ?)";

                        SQLiteStatement st = db.compileStatement(sql);
                        st.bindString(1,id);
                        st.bindString(2,aTitle);
                        st.bindString(3,content);
                        st.execute();


                    }

                }
                return result;


            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            updateListView();
            super.onPostExecute(s);
        }
    }

    public void updateListView()
    {
        Cursor c = db.rawQuery("SELECT * FROM articles",null);
        int contentIndex = c.getColumnIndex("content");
        int titleIndex = c.getColumnIndex("title");
        if(c.moveToFirst())
        {
            titles.clear();
            content.clear();
            do {

                Log.i("updating","yesss");

                titles.add(c.getString(titleIndex));
                content.add(c.getString(contentIndex));
            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DownloadTask task = new DownloadTask();
        //task.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
        ListView listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("content",content.get(i));
                startActivity(intent);
            }
        });
        

        db = this.openOrCreateDatabase("Articles",MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE IF NOT EXISTS articles (id INTEGER PRIMARY KEY, articleid INTEGER , title VARCHAR, content VARCHAR)");
        updateListView();


    }
}