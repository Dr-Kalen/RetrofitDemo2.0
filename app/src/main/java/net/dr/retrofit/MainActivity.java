package net.dr.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import net.dr.retrofit.model.Config;
import net.dr.retrofit.network.NetworkRequest;

import java.io.IOException;

import retrofit2.Call;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Call<Config> call =  NetworkRequest.getInstance().configInfo("name",23);
        try {
            Config response  = call.execute().body();
            Toast.makeText(MainActivity.this, response.message, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
