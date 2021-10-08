package pl.saba.lashextension;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;


public class OrderActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_xml);
        TextView value = findViewById(R.id.orderServiceTypeValue);
        TextView valueDate = findViewById(R.id.orderServiceDateValue);
        TextView valueTime = findViewById(R.id.orderServiceHourValue);

        String timeString = getIntent().getStringExtra("time");
        valueTime.setText(timeString);


        String dateString = getIntent().getStringExtra("dateReservation");
        valueDate.setText(dateString);

        String effectTypeString = getIntent().getStringExtra("effectType");
        value.setText(effectTypeString);

    }


}
