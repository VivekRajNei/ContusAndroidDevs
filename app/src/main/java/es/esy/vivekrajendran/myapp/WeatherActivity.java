package es.esy.vivekrajendran.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncCallback;
import es.esy.vivekrajendran.myapp.network.WeatherAsyncTask;

public class WeatherActivity extends AppCompatActivity implements WeatherAsyncCallback {

    private ArrayList<WeatherModel> arrayList;
    private TextView weather_title, description, condition, latitude;
    private ImageView imageView;

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

        weather_title = (TextView) findViewById(R.id.txtView_weather_title);
        description = (TextView) findViewById(R.id.txtView_weather_description);
        condition = (TextView) findViewById(R.id.txtView_weather_condition);
        latitude = (TextView) findViewById(R.id.txtView_weather_lat);
        imageView = (ImageView) findViewById(R.id.img_weather_image);
    }

    @Override
    public void onTaskDone(ArrayList<WeatherModel> weatherModelArrayList) {
        this.arrayList = weatherModelArrayList;
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
