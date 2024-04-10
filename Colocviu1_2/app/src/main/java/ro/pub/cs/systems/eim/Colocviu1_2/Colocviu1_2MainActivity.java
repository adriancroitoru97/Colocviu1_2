package ro.pub.cs.systems.eim.Colocviu1_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    Button add_button, compute_button;
    TextView sum_text_view;
    EditText number_edit_text;

    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_2_main);

        add_button = findViewById(R.id.addbutton);
        compute_button = findViewById(R.id.computebutton);
        sum_text_view = findViewById(R.id.sumview);
        number_edit_text = findViewById(R.id.inputbox);

        add_button.setOnClickListener(v -> {
            try {
                int number = Integer.parseInt((number_edit_text.getText().toString()));
                // The input is a valid integer.

                if (sum_text_view.getText().toString().isEmpty()) {
                    sum_text_view.setText(number_edit_text.getText().toString());
                } else {
                    sum_text_view.setText(sum_text_view.getText().toString() + " + " + number_edit_text.getText().toString());
                }
            } catch (NumberFormatException e) {
                // The input is not a valid integer.
                Log.d("Colocviu1_2", "The input is not a valid integer.");
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Log.d("MAIN", "returned ok from second");
                int tmp = result.getData().getIntExtra(Constants.COMPUTED_SUM, 0);
                Log.d("MAIN", "returned ok from second with sum: " + tmp);
                Toast.makeText(getApplicationContext(), "SUM: " + tmp, Toast.LENGTH_LONG).show();
                Log.d("TAG", "OK");
            }
        });
        compute_button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
            intent.putExtra(Constants.SUM_AS_STRING, sum_text_view.getText().toString());
            activityResultLauncher.launch(intent);
        });
    }
}