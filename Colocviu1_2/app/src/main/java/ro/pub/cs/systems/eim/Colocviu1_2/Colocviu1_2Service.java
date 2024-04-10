package ro.pub.cs.systems.eim.Colocviu1_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Colocviu1_2Service extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("exD", "Service started");
        int sum = intent.getIntExtra(Constants.FINAL_SUM, 0);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            sendBroadcastMessage(sum);
        }).start();

        return START_STICKY;
    }

    private void sendBroadcastMessage(int sum) {
        Intent intent = new Intent();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedDate = sdf.format(new Date(System.currentTimeMillis()));

        String result = String.valueOf(sum) + " @ " + formattedDate;
        intent.putExtra(Constants.FINAL_SUM2, result);
        intent.setAction("HAHAHA");

        Log.d("exD_fromService", "Service sent: " + result);

        sendBroadcast(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
