package es.esy.vivekrajendran.myapp.network;


import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;

public interface WeatherAsyncCallback {
    public void onTaskDone(ArrayList<WeatherModel> weatherModelArrayList);
}
