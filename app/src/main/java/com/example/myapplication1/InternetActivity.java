package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;

public class InternetActivity extends AppCompatActivity {

    private boolean wifiConnected = false;
    private boolean mobileConnected = false;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        textView = findViewById(R.id.textView);
        checkNetworkConnection();
    }

    private void checkNetworkConnection(){

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() ) {
            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;

            if(wifiConnected){
                textView.setText("Connected to WiFi");
            }
            else if(mobileConnected) {
                textView.setText("Connected to Mobile");
            }

        } else {
            textView.setText("Not Connected");
        }
    }
}
