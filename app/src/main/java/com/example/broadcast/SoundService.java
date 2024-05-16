package com.example.broadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class SoundService extends Service {
    MediaPlayer mp;
    public SoundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.music);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mp.isPlaying()) {
            mp.start();
            mp.setLooping(true); // Répétez la musique en boucle

        }
        return START_STICKY;
    }




    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
            Log.d("TAG", "Service détruit et lecture de la musique arrêtée");
        }
    }
}