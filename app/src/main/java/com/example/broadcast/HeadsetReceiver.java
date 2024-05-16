package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HeadsetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            int state=intent.getIntExtra("state",-1);
            if (state==0) {
                context.stopService(new Intent(context, SoundService.class));
                Toast.makeText(context, "sound off", Toast.LENGTH_SHORT).show();
            }
            else if (state==1){
                    context.startService(new Intent(context,SoundService.class));
                    Toast.makeText(context, "sound on", Toast.LENGTH_SHORT).show();
            }
            else{
                Log.d("TAG", "État des écouteurs inconnu");
            }
        }
    }
}