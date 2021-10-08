package com.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import pl.saba.lashextension.EffectType;
import pl.saba.lashextension.OrderActivity;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        EditText name = findViewById(R.id.nameEditText);
        EditText lastName = findViewById(R.id.lastNameEditText);
        EditText phoneNumber = findViewById(R.id.numberPhoneEditText);
        Button appointment = findViewById(R.id.appointmentBtn);
        appointment.setOnClickListener(v -> {
            openOrderSummaryActivity(effectType);

        });
    }

    public void openOrderSummaryActivity(EffectType effectType) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("effectType", effectType.name());
        startActivity(intent);
    }
}