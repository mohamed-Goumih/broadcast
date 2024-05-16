package com.example.broadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    //BatteryLevelReceiver
    private BatteryLevelReceiver batteryLevelReceiver = new BatteryLevelReceiver();
    //Screen OFF
    private ScreenReceiver screenReceiver=new ScreenReceiver();

    //HeadSetReceviver
    private HeadsetReceiver headsetReceiver=new HeadsetReceiver();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // IntentFilter filter=new IntentFilter(Intent.ACTION_SCREEN_OFF);
       // registerReceiver(screenReceiver,filter);

        //headSet
        IntentFilter filter2=new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(headsetReceiver,filter2);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Enregistrer le BroadcastReceiver pour écouter les changements de la batterie
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_BATTERY_LOW);
        //filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //registerReceiver(batteryLevelReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Désenregistrer le BroadcastReceiver quand l'activité n'est pas visible
        unregisterReceiver(batteryLevelReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(headsetReceiver);
    }
}



