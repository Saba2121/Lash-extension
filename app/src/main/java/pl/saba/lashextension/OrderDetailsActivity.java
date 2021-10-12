package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;


public class OrderDetailsActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        TextView value = findViewById(R.id.orderServiceTypeValue);
        TextView valueDate = findViewById(R.id.orderServiceDateValue);
        TextView valueTime = findViewById(R.id.orderServiceHourValue);


        String effectTypeString = getIntent().getStringExtra("effectType");
        value.setText(effectTypeString);

        String date = getIntent().getStringExtra("date");
        valueDate.setText(date);

        String time = getIntent().getStringExtra("time");
        valueTime.setText(time);


        Button submit = findViewById(R.id.submitBtn);
        submit.setOnClickListener(v -> {
            openMainActivity();
            Toast.makeText(this, "Your visit is confirmed", Toast.LENGTH_SHORT).show();
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
