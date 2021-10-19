package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class CalendarActivity extends AppCompatActivity {
    private String dateString = null;
    private String timeString = null;
    private String variant = null;
    private Button mon;
    private Button tue;
    private Button wed;
    private Button thu;
    private Button fri;
    private Button sat;
    private Button sun;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);
        String value = getIntent().getStringExtra("variant");

        Button bookNow = findViewById(R.id.bookNow);
        TextView saveHour = findViewById(R.id.saveHour);
        TextView saveDate = findViewById(R.id.saveDate);
        Button eight = findViewById(R.id.eight);
        Button ten = findViewById(R.id.ten);
        Button twelve = findViewById(R.id.twelve);
        Button two = findViewById(R.id.two);
        Button four = findViewById(R.id.four);
        Button six = findViewById(R.id.six);
        mon = findViewById(R.id.monBtn);
        tue = findViewById(R.id.tueBtn);
        wed = findViewById(R.id.wedBtn);
        thu = findViewById(R.id.thuBtn);
        fri = findViewById(R.id.friBtn);
        sat = findViewById(R.id.satBtn);
        sun = findViewById(R.id.sunBtn);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        setDateOfMonthOnButtons(dayOfWeek, dayOfMonth);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("dayOfMonth = " + dayOfMonth);
//        mon.setTextColor(Color.parseColor("#DD090A"));
//        tue.setTextColor(Color.parseColor("#228b22"));

        setTimeOnControls(eight, saveHour, "08:00", bookNow);
        setTimeOnControls(ten, saveHour, "10:00", bookNow);
        setTimeOnControls(twelve, saveHour, "12:00", bookNow);
        setTimeOnControls(two, saveHour, "14:00", bookNow);
        setTimeOnControls(four, saveHour, "16:00", bookNow);
        setTimeOnControls(six, saveHour, "18:00", bookNow);

        bookNow.setOnClickListener(v ->
                openPersonActivity(effectType, dateString, timeString, variant));
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


    private void lockAndUnlockButton(Button bookNow) {
        Boolean result = Objects.nonNull(dateString) && Objects.nonNull(timeString);
        bookNow.setEnabled(result);
    }

    private void setDateOfMonthOnButtons(Integer dayOfWeek, Integer dayOfMonth) {
        sun.setText(String.valueOf(dayOfMonth - dayOfWeek + 8));
        mon.setText(String.valueOf(dayOfMonth - dayOfWeek + 2));
        tue.setText(String.valueOf(dayOfMonth - dayOfWeek + 3));
        wed.setText(String.valueOf(dayOfMonth - dayOfWeek + 4));
        thu.setText(String.valueOf(dayOfMonth - dayOfWeek + 5));
        fri.setText(String.valueOf(dayOfMonth - dayOfWeek + 6));
        sat.setText(String.valueOf(dayOfMonth - dayOfWeek + 7));

    }
}
