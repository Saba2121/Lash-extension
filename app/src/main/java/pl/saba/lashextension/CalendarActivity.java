package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;


public class CalendarActivity extends AppCompatActivity {
    private String dateString = null;
    private String timeString = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        CalendarView cv = findViewById(R.id.calendarView);
        TextView tv = findViewById(R.id.saveDate);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String d = dayOfMonth + "/" + (month + 1) + "/" + year;
                dateString = d;
                tv.setText(d);

                TextView saveHour = findViewById(R.id.saveHour);
                Button eight = findViewById(R.id.eight);
                Button ten = findViewById(R.id.ten);
                Button twelve = findViewById(R.id.twelve);
                Button two = findViewById(R.id.two);
                Button four = findViewById(R.id.four);
                Button six = findViewById(R.id.six);

                setTimeOnControls(eight, saveHour, "08:00");
                setTimeOnControls(ten, saveHour, "10:00");
                setTimeOnControls(twelve, saveHour, "12:00");
                setTimeOnControls(two, saveHour, "14:00");
                setTimeOnControls(four, saveHour, "16:00");
                setTimeOnControls(six, saveHour, "18:00");

            }
        });
        Button bookNow = findViewById(R.id.bookNow);
        bookNow.setOnClickListener(v ->
                openPersonActivity(effectType, dateString, timeString));

    }

    public void openPersonActivity(EffectType effectType, String dateString, String timeString) {
        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("effectType", effectType.name());
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        startActivity(intent);
    }

    private void setTimeOnControls(Button button, TextView textView, String hour) {
        button.setOnClickListener(v -> {
            textView.setText(hour);
            timeString = hour;
        });

    }
}
