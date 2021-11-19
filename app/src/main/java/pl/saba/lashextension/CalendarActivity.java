package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.String.valueOf;
import static pl.saba.lashextension.CalendarActivityHelper.countNumberOfDayInCircle;

public class CalendarActivity extends AppCompatActivity {
    private String dateString = null;
    private String timeString = null;
    private Button mon, tue, wed, thu, fri, sat, sun;
    private Button bookNow;
    private Calendar calendar;
    private TextView saveDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);
        String variant = getIntent().getStringExtra("variant");

        bookNow = findViewById(R.id.bookNow);
        TextView saveHour = findViewById(R.id.saveHour);
        saveDate = findViewById(R.id.saveDate);
        TextView monthAndYear = findViewById(R.id.nameOfMonthTextView);
        Button next = findViewById(R.id.nextBtn);
        Button previous = findViewById(R.id.previousBtn);
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

        next.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, 7);
            refreshView(calendar, monthAndYear);
        });

        previous.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, -7);
            refreshView(calendar, monthAndYear);
        });

        calendar = Calendar.getInstance();
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -dayOfWeek + 2);
        System.out.println("data = " + calendar.getTime());

        mon.setOnClickListener(v -> showDate(0));
        tue.setOnClickListener(v -> showDate(1));
        wed.setOnClickListener(v -> showDate(2));
        thu.setOnClickListener(v -> showDate(3));
        fri.setOnClickListener(v -> showDate(4));
        sat.setOnClickListener(v -> showDate(5));
        sun.setOnClickListener(v -> showDate(6));

        refreshView(calendar, monthAndYear);

        setTimeOnControls(eight, saveHour, "08:00");
        setTimeOnControls(ten, saveHour, "10:00");
        setTimeOnControls(twelve, saveHour, "12:00");
        setTimeOnControls(two, saveHour, "14:00");
        setTimeOnControls(four, saveHour, "16:00");
        setTimeOnControls(six, saveHour, "18:00");

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

    private void setTimeOnControls(Button button, TextView saveHour, String hour) {
        button.setOnClickListener(v -> {
            saveHour.setText(hour);
            timeString = hour;
            lockOrUnlockButton(bookNow);
        });
    }

    private void lockOrUnlockButton(Button bookNow) {
        Boolean result = Objects.nonNull(dateString) && Objects.nonNull(timeString);
        bookNow.setEnabled(result);

    }

    private void refreshView(Calendar calendar, TextView nameOfMonth) {
        Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer daysInMonth = YearMonth.of(year, month).lengthOfMonth();

        mon.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 0, daysInMonth)));
        tue.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 1, daysInMonth)));
        wed.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 2, daysInMonth)));
        thu.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 3, daysInMonth)));
        fri.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 4, daysInMonth)));
        sat.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 5, daysInMonth)));
        sun.setText(valueOf(countNumberOfDayInCircle(dayOfMonth, 6, daysInMonth)));
        markCurrentDay(Collections.emptyList());

        Calendar calendarForFirstCircle = (Calendar) calendar.clone();
        String nameOfMonthForFirstCircle = DateUtils.getNameOfMonth(calendarForFirstCircle.get(Calendar.MONTH));

        Calendar calendarForLastCircle = (Calendar) calendar.clone();
        calendarForLastCircle.add(Calendar.DATE, 6);
        String nameOfMonthForLastCircle = DateUtils.getNameOfMonth(calendarForLastCircle.get(Calendar.MONTH));

        if (nameOfMonthForFirstCircle.equals(nameOfMonthForLastCircle)) {
            nameOfMonth.setText(nameOfMonthForFirstCircle);

        } else {
            nameOfMonth.setText(nameOfMonthForFirstCircle + "/" + nameOfMonthForLastCircle);
        }

    }

    private void showDate(Integer numberOfDaysToAdd) {

        Date date = calendar.getTime();
        dateString = date.toString();
        Calendar calendarCopy = (Calendar) calendar.clone();
        calendarCopy.add(Calendar.DATE, numberOfDaysToAdd);
        String prettyDate = DateUtils.getDayAndMonth(calendarCopy.getTime());
        saveDate.setText(prettyDate);
        dateString = prettyDate;
        lockOrUnlockButton(bookNow);
    }

    private void markCurrentDay(List<Button> buttons) {

        Date now = new Date();
        Date dateOfFirstCircle = calendar.getTime();
        long dayDifference = ChronoUnit.DAYS.between(dateOfFirstCircle.toInstant(), now.toInstant());
        System.out.println(dayDifference);


//        date.setBackgroundColor(Color.parseColor("#7cfc00"));
    }
}
