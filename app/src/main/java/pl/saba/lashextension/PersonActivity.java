package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

public class PersonActivity extends AppCompatActivity {
    private EditText name, surname, numberPhone;
    private Button appointment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        String dateString = getIntent().getStringExtra("date");
        String timeString = getIntent().getStringExtra("time");
        String variant = getIntent().getStringExtra("variant");
        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        name = findViewById(R.id.nameEditText);
        surname = findViewById(R.id.surnameEditText);
        numberPhone = findViewById(R.id.numberPhoneEditText);
        appointment = findViewById(R.id.appointmentBtn);

        appointment.setOnClickListener(v -> {
            String nameInput = name.getText().toString().trim();
            String lastNameInput = surname.getText().toString().trim();
            String numberPhoneInput = numberPhone.getText().toString().trim();

            if (!Validator.isValidNameOrSurname(nameInput)) {
                name.requestFocus();
                name.setError("Field cannot be empty");
                return;

            }
            if (!Validator.isValidNameOrSurname(lastNameInput)) {
                surname.requestFocus();
                surname.setError("Field cannot be empty");
                return;
            }
            if (!Validator.isValidPhoneNumber(numberPhoneInput)) {
                numberPhone.requestFocus();
                numberPhone.setError("");
            }


            openOrderDetailsActivity(effectType, dateString, timeString, variant, name.getText().toString(),
                    surname.getText().toString(), numberPhone.getText().toString());
        });

    }


    public void openOrderDetailsActivity(EffectType effectType, String dateString, String timeString,
                                         String variant, String name, String surname, String numberPhone) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("effectType", effectType.name());
        System.out.println(dateString);
        System.out.println(timeString);
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("numberPhone", numberPhone);
        startActivity(intent);
    }


}