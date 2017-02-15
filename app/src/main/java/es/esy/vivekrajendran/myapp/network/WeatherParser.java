package es.esy.vivekrajendran.myapp.network;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;

class WeatherParser {

    private ArrayList<WeatherModel> weatherModelsArrayList = new ArrayList<>();
    private String TAG = "TAG";

    ArrayList<WeatherModel> toArrayList(String jsonString) {

        if (jsonString == null) return null;

        try {
            Log.i(TAG, "toArrayList: " + jsonString);
            JSONObject rootElement = new JSONObject(jsonString);
            JSONArray features = rootElement.getJSONArray("features");
            Log.i(TAG, "toArrayList: " + features.length());

            String url;
            String place;
            String mag;
            String detail;
            long time;

            for (int i = 0; i < features.length(); i++) {
                JSONObject temp = features.getJSONObject(i);
                JSONObject properties = temp.getJSONObject("properties");
                url = properties.getString("url");
                place = properties.getString("place");
                mag = String.valueOf(properties.getDouble("mag"));
                detail = properties.getString("detail");
                time = properties.getLong("time");
                weatherModelsArrayList.add(new WeatherModel(url, place, mag, detail, time));
            }

            Log.i(TAG, "toArrayList: " + weatherModelsArrayList.size());
            return weatherModelsArrayList;
        } catch (JSONException e) {
            Log.i(TAG, "toArrayList: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private WeatherParser() {}

    public static WeatherParser getInstance() {
        return new WeatherParser();
    }
}
