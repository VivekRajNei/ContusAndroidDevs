package es.esy.vivekrajendran.myapp.network;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.WeatherModel;


public class WeatherAsyncTask extends AsyncTask<String, Void, ArrayList<WeatherModel>>
        implements WeatherAsyncCallback {

    private WeatherAsyncCallback weatherAsynceCallback = null;

    public WeatherAsyncTask(WeatherAsyncCallback weatherAsynceCallback) {
        this.weatherAsynceCallback = weatherAsynceCallback;
    }

    @Override
    protected ArrayList<WeatherModel> doInBackground(String... params) {
        String response = doNetworkOperation(params[0]);
        return WeatherParser.getInstance().toArrayList(response);
    }

    @Override
    protected void onPostExecute(ArrayList<WeatherModel> weatherModels) {
//        Log.i("TAG", "onPostExecute: " + weatherModels.size());
        weatherAsynceCallback.onTaskDone(weatherModels);
    }

    private String doNetworkOperation(String url) {
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        try {
            URL urlConn = new URL(url);
            httpURLConnection = (HttpURLConnection) urlConn.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(30000);

            httpURLConnection.connect();
            bufferedReader =
                    new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String temp;
            StringBuilder stringBuilder = new StringBuilder();
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.i("TAG", "doNetworkOperation: " + e.getMessage());
            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTaskDone(ArrayList<WeatherModel> weatherModelArrayList) {
    }
}
