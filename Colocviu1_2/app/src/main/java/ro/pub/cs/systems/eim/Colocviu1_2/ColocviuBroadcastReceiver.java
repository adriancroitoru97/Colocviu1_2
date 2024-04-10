package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ColocviuBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("PracticalTest01-bcrcvd", "Received broadcast");

        String received = intent.getStringExtra(Constants.FINAL_SUM2);
        Toast.makeText(context, received, Toast.LENGTH_LONG).show();
    }
}
