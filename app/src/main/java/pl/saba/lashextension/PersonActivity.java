package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;


public class PersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        String dateString = getIntent().getStringExtra("date");
        String timeString = getIntent().getStringExtra("time");
        String variant = getIntent().getStringExtra("variant");

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        EditText name = findViewById(com.saba.lashextension.R.id.nameEditText);
        EditText lastName = findViewById(com.saba.lashextension.R.id.lastNameEditText);
        EditText phoneNumber = findViewById(com.saba.lashextension.R.id.numberPhoneEditText);
        Button appointment = findViewById(com.saba.lashextension.R.id.appointmentBtn);
        appointment.setOnClickListener(v -> {
            openOrderDetailsActivity(effectType, dateString, timeString, variant);

        });
    }

    public void openOrderDetailsActivity(EffectType effectType, String dateString, String timeString, String variant) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("effectType", effectType.name());
        System.out.println(dateString);
        System.out.println(timeString);
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        startActivity(intent);
    }
}