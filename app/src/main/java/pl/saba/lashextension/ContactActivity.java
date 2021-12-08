package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

public class ContactActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Button goBackContact = findViewById(R.id.goBackContact);
        goBackContact.setOnClickListener(v -> {
            openLashServiceActivity();
        });
    }

    public void openLashServiceActivity() {
        Intent intent = new Intent(this, LashServicesActivity.class);
        startActivity(intent);
    }
}
