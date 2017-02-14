package es.esy.vivekrajendran.myapp.network;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;

class WeatherParser {
    private ArrayList<WeatherModel> weatherModelsArrayList = new ArrayList<>();

    public ArrayList<WeatherModel> toArrayList(String jsonString) {

        if (jsonString == null) return null;

        try {
            JSONObject rootElement = new JSONObject(jsonString);
            JSONObject coord = rootElement.getJSONObject("coord");
            JSONObject main = rootElement.getJSONObject("main");
            JSONArray weather = rootElement.getJSONArray("weather");
            JSONObject weatherOne = weather.getJSONObject(0);

            String image_id = weatherOne.getString("icon");
            String name = rootElement.getString("name");
            String lon = String.valueOf(coord.getLong("lon"));
            String lat = String.valueOf(coord.getLong("lat"));
            String description = weatherOne.getString("description");
            long temp = main.getLong("temp");
            long humidity = main.getLong("humidity");

            weatherModelsArrayList.add(new WeatherModel(lat, lon, name, description, temp, humidity, image_id));
            return weatherModelsArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private WeatherParser() {}

    public static WeatherParser getInstance() {
        return new WeatherParser();
    }
}
