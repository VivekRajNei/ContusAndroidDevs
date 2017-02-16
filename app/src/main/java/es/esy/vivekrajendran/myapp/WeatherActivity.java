package es.esy.vivekrajendran.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncCallback;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncTask;

public class WeatherActivity extends AppCompatActivity implements WeatherAsyncCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Weather");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        new WeatherAsyncTask(this).
                execute(getResources().getString(R.string.usgs_baseurl) + "&" +
                        getResources().getString(R.string.usgs_starttime));

        TextView weather_title = (TextView) findViewById(R.id.txtView_weather_title);
        TextView description = (TextView) findViewById(R.id.txtView_weather_description);
        TextView condition = (TextView) findViewById(R.id.txtView_weather_condition);
        TextView latitude = (TextView) findViewById(R.id.txtView_weather_lat);
        ImageView imageView = (ImageView) findViewById(R.id.img_weather_image);
    }

    @Override
    public void onTaskDone(ArrayList<WeatherModel> weatherModelArrayList) {
        ArrayList<WeatherModel> arrayList = weatherModelArrayList;
//        Log.i("TAG", "onTaskDone: " + arrayList.size());

//        latitude.setText(arrayList.get(0).getLat());
//        weather_title.setText(arrayList.get(0).getLocation());
//        description.setText(arrayList.get(0).getDescription());
//        condition.setText(String.valueOf(arrayList.get(0).getTemp()));
//        Glide.with(this)
//                .load(getResources().getString(R.string.openweather_icon) + weatherModelArrayList.get(0).getImgae_id() + ".png")
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imageView);
    }
}
