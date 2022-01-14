package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button welcomeBtn = findViewById(R.id.welcomeBtn);
        welcomeBtn.setOnClickListener(v ->
                openLashServiceActivity());
    }

    public void openLashServiceActivity() {
        Intent intent = new Intent(this, LashExtActivity.class);
        startActivity(intent);
    }


}