package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
            openOrderDetailsActivity(effectType, dateString, timeString, variant, name, surname, numberPhone);
        });

        name.addTextChangedListener(nameTextWatcher);
        surname.addTextChangedListener(nameTextWatcher);
        numberPhone.addTextChangedListener(nameTextWatcher);
    }

    private TextWatcher nameTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nameInput = name.getText().toString().trim();
            String lastNameInput = surname.getText().toString().trim();
            String numberPhoneInput = numberPhone.getText().toString().trim();

            appointment.setEnabled(!nameInput.isEmpty() && !lastNameInput.isEmpty() && !numberPhoneInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void openOrderDetailsActivity(EffectType effectType, String dateString, String timeString,
                                         String variant, EditText name, EditText surname, EditText numberPhone) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("effectType", effectType.name());
        System.out.println(dateString);
        System.out.println(timeString);
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("surname", surname.getText().toString());
        intent.putExtra("numberPhone", numberPhone.getText().toString());
        startActivity(intent);
    }


}