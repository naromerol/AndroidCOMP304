package com.example.jsontest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplayWeather;
    private EditText txtLat, txtLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplayWeather = (TextView)findViewById(R.id.txtDisplayWeather);
        new ReadJSONFeedTask().execute(
                "http://extjs.org.cn/extjs/examples/grid/survey.html");

    }
    public void getWeather(View view)
    {
        //read geocoordinates from edit texts
        txtLat = (EditText)findViewById(R.id.txtLat);
        txtLong = (EditText)findViewById(R.id.txtLong);
        String latitude = txtLat.getText().toString();
        String longitude = txtLong.getText().toString();

        //get weather information using geo coordinates
        //this method calls OpenWeatherMap API
        //
        //create the URL to call JSON service
        //"http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=13f04464b7119837cf1dc4fa8b39caa3");

        String url = "https://api.openweathermap.org/data/2.5/weather?";
        url+="lat="+latitude;
        url+="&lon="+longitude;
        url+="&appid=23f04464b7119837cf1dc4fa8b39caa3"; //from OpenWeatherMap website
        Log.d("URL",url);
        new ReadJSONFeedTask().execute(url);
        //new ReadJSONFeedTask().execute(
        //        "https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=13f04464b7119837cf1dc4fa8b39caa3");


    }


    public String readJSONFeed(String address) {
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        };
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream content = new BufferedInputStream(
                    urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return stringBuilder.toString();
    }
    private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }
        protected void onPostExecute(String result) {
            try {
                //JSONArray jsonArray = new JSONArray(result);
                //Uncomment the two rows below to parse weather data from OpenWeatherMap
                JSONObject weatherJson = new JSONObject(result);
                JSONArray dataArray1= weatherJson.getJSONArray("weather");
                String strResults="Weather\n";
                for (int i = 0; i < dataArray1.length(); i++) {
                    JSONObject jsonObject = dataArray1.getJSONObject(i);
                    strResults +="id: "+jsonObject.getString("id");
                    strResults +="\nmain: "+jsonObject.getString("main");
                    strResults +="\ndescription: "+jsonObject.getString("description");
                }
                //
                JSONObject dataObject= weatherJson.getJSONObject("main");
                strResults +="\ntemp: "+dataObject.getString("temp");
                strResults +="\nhumidity: "+dataObject.getString("humidity");
                strResults +="\ntemp_min: "+dataObject.getString("temp_min");
                strResults +="\ntemp_max: "+dataObject.getString("temp_max");
                //
                txtDisplayWeather.setText(strResults);
                //txtDisplayWeather.setText(weatherJson.getString("weather"));
                //
                //uncomment the code below for parsing survey data
                /*
                JSONArray jsonArray = new JSONArray(result);
                Log.i("JSON", "Number of surveys in feed: " + jsonArray.length());
                //---print out the content of the json feed---
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Log.d("survey",jsonObject.getString("surveyDate"));
                    Toast.makeText(getBaseContext(),
                            jsonObject.getString("surveyTime") +
                                    " - " + jsonObject.getString("appeId"),
                            Toast.LENGTH_SHORT).show();
                }
                */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
