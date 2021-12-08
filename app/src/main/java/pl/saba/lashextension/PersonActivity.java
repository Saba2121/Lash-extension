package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.util.Objects;

public class PersonActivity extends AppCompatActivity {
    private String name = null;
    private EditText lastName = null;
    private EditText numberPhone = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        EditText name = findViewById(R.id.nameEditText);
        EditText lastName = findViewById(R.id.lastNameEditText);
        EditText numberPhone = findViewById(R.id.numberPhoneEditText);
        Button appointment = findViewById(R.id.appointmentBtn);

        appointment.setOnClickListener(v -> {
            openOrderDetailsActivity(effectType, dateString, timeString, variant);
        });
    }

    String dateString = getIntent().getStringExtra("date");
    String timeString = getIntent().getStringExtra("time");
    String variant = getIntent().getStringExtra("variant");
    String effectTypeString = getIntent().getStringExtra("effectType");
    EffectType effectType = EffectType.valueOf(effectTypeString);


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


    private void lockOrUnlockEditText(EditText name, EditText lastName, EditText numberPhone, Button appointment) {
        Boolean result = Objects.nonNull(name) && Objects.nonNull(lastName) && Objects.nonNull(numberPhone);
        appointment.setEnabled(result);
    }
}