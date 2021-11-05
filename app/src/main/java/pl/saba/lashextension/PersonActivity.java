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
    private EditText name, lastName, numberPhone;
    private Button appointment;

//    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        EditText name = findViewById(com.saba.lashextension.R.id.nameEditText);
        EditText lastName = findViewById(com.saba.lashextension.R.id.lastNameEditText);
        EditText phoneNumber = findViewById(com.saba.lashextension.R.id.numberPhoneEditText);
        Button appointment = findViewById(com.saba.lashextension.R.id.appointmentBtn);

        appointment.setEnabled(false);

        name.addTextChangedListener(textWatcher);
        lastName.addTextChangedListener(textWatcher);
        numberPhone.addTextChangedListener(textWatcher);

        appointment.setOnClickListener(v -> {
            openOrderDetailsActivity(effectType, dateString, timeString, variant);

        });
    }

//     name.addTextChangedListener(new TextWatcher() {

    //myEditText.setOnFocusListener(new OnFocusListener(){
//        public void onFocus(){
//            myEditText.setHint("");
//        }
//    });
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String n = name.getText().toString();
            String l = lastName.getText().toString();
            String p = numberPhone.getText().toString();

            if (!n.isEmpty() && !l.isEmpty() && !p.isEmpty()) {
                appointment.setEnabled(true);
            } else {
                appointment.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = name.getText().toString();
        }
    };


    String dateString = getIntent().getStringExtra("date");
    String timeString = getIntent().getStringExtra("time");
    String variant = getIntent().getStringExtra("variant");
    String effectTypeString = getIntent().getStringExtra("effectType");
    EffectType effectType = EffectType.valueOf(effectTypeString);


    public void openOrderDetailsActivity(EffectType effectType, String dateString, String
            timeString, String variant) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("effectType", effectType.name());
        System.out.println(dateString);
        System.out.println(timeString);
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        startActivity(intent);
    }


//            private void lockAndUnlockEditText(EditText name, EditText lastName, EditText numberPhone) {
//                if (Objects.nonNull(name) && Objects.nonNull(lastName) && Objects.nonNull(numberPhone)) {
//
//                } else {
//                }
//        }
}