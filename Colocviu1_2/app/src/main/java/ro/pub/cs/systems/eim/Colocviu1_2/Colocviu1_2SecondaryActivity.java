package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Colocviu1_2_SECONDARY", "entered secondary activity");

        Intent intent = getIntent();
        String sum_as_string = intent.getStringExtra(Constants.SUM_AS_STRING);

        Log.d("Colocviu1_2_SECONDARY", "RECEIVED: " + sum_as_string);

        if (sum_as_string != null) {
            String[] numbers = sum_as_string.split("\\+");
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim());
            }

            Log.d("Colocviu1_2_SECONDARY", "COMPUTED SUM: " + sum);

            Intent intentResult = new Intent();
            intentResult.putExtra(Constants.COMPUTED_SUM, sum);
            setResult(RESULT_OK, intentResult);
            finish();
        } else {
            Intent intentResult = new Intent();
            intentResult.putExtra(Constants.COMPUTED_SUM, 0);
            setResult(RESULT_OK, intentResult);
            finish();
        }
    }
}