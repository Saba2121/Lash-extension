package pl.saba.lashextension;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;


public class WeekViewActivity extends AppCompatActivity {
    private String dateString = null;
    private String timeString = null;
    private String variant;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);
        String value = getIntent().getStringExtra("variant");

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView saveDate = findViewById(R.id.saveDate);
        saveDate.setText(currentDate);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 10);

//        CalendarView cv = findViewById(R.id.calendarView);


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String d = dayOfMonth + "/" + (month + 1) + "/" + year;
                dateString = d;
                saveDate.setText(d);


                Button bookNow = findViewById(R.id.bookNow);
                TextView saveHour = findViewById(R.id.saveHour);
                Button eight = findViewById(R.id.eight);
                Button ten = findViewById(R.id.ten);
                Button twelve = findViewById(R.id.twelve);
                Button two = findViewById(R.id.two);
                Button four = findViewById(R.id.four);
                Button six = findViewById(R.id.six);
                Button mon = findViewById(R.id.monBtn);
                Button tue = findViewById(R.id.tueBtn);
                Button wed = findViewById(R.id.wedBtn);
                Button thu = findViewById(R.id.thuBtn);
                Button fri = findViewById(R.id.friBtn);
                Button sat = findViewById(R.id.satBtn);
                Button sun = findViewById(R.id.sunBtn);


                mon.setTextColor(Color.parseColor("#DD090A"));
                tue.setTextColor(Color.parseColor("#228b22"));

                mon.setOnClickListener(v -> {
                    saveDate.setText("15.10.2021");
                });
                eight.setOnClickListener(v1 -> {
                    saveHour.setText("08:00");
                });

                setTimeOnControls(eight, saveHour, "08:00", bookNow);
                setTimeOnControls(ten, saveHour, "10:00", bookNow);
                setTimeOnControls(twelve, saveHour, "12:00", bookNow);
                setTimeOnControls(two, saveHour, "14:00", bookNow);
                setTimeOnControls(four, saveHour, "16:00", bookNow);
                setTimeOnControls(six, saveHour, "18:00", bookNow);

                bookNow.setOnClickListener(v ->
                        openPersonActivity(effectType, dateString, timeString, variant));
            }
        });


    }

    public void openPersonActivity(EffectType effectType, String dateString, String timeString, String variant) {
        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("effectType", effectType.name());
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        startActivity(intent);
    }

    private void setTimeOnControls(Button button, TextView textView, String hour, Button bookNow) {
        button.setOnClickListener(v -> {
            textView.setText(hour);
            timeString = hour;
            lockAndUnlockButton(bookNow);
        });

    }

    private void setDateOnControls(Button button, TextView textView, String date, Calendar calendar) {
        button.setOnClickListener(v -> {
            textView.setText(date);
            dateString = date;
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        });
    }

    private void lockAndUnlockButton(Button bookNow) {
        Boolean result = Objects.nonNull(dateString) && Objects.nonNull(timeString);
        bookNow.setEnabled(result);
    }


}



