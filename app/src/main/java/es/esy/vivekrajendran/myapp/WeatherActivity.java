package es.esy.vivekrajendran.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncCallback;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncTask;

public class WeatherActivity extends AppCompatActivity implements WeatherAsyncCallback {

    private ArrayList<WeatherModel> arrayList;
    private TextView weather_title, description, condition, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Weather");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        new WeatherAsyncTask(this).
                execute("http://api.openweathermap.org/data/2.5/weather?q=London,uk&apikey=1a4c6876e942269eeed475dd217d48e8");

        weather_title = (TextView) findViewById(R.id.txtView_weather_title);
        description = (TextView) findViewById(R.id.txtView_weather_description);
        condition = (TextView) findViewById(R.id.txtView_weather_condition);
        latitude = (TextView) findViewById(R.id.txtView_weather_lat);
    }

    @Override
    public void onTaskDone(ArrayList<WeatherModel> weatherModelArrayList) {
        this.arrayList = weatherModelArrayList;
        Log.i("TAG", "onTaskDone: " + arrayList.size());

        latitude.setText(arrayList.get(0).getLat());
        weather_title.setText(arrayList.get(0).getLocation());
        description.setText(arrayList.get(0).getDescription());
        condition.setText(String.valueOf(arrayList.get(0).getTemp()));
    }
}
