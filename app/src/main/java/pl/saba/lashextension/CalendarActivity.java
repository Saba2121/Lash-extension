package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static java.lang.String.valueOf;

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
    private Calendar calendar;

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
        TextView monday = findViewById(R.id.monTextView);
        TextView tuesday = findViewById(R.id.tueTextView);
        TextView wednesday = findViewById(R.id.wedTextView);
        TextView thursday = findViewById(R.id.thuTextView);
        TextView friday = findViewById(R.id.friTextView);
        TextView saturday = findViewById(R.id.satTextView);
        TextView sunday = findViewById(R.id.sunTextView);

        next.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, 7);
            setDayOfMonthOnButtons(calendar, monthAndYear);
        });

        previous.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, -7);
            setDayOfMonthOnButtons(calendar, monthAndYear);

        });
        mon.setOnClickListener(v -> {
            Date date = calendar.getTime();
            saveDate.setText(date.toString());
            dateString = date.toString();
            lockOrUnlockButton(bookNow);
        });

        calendar = Calendar.getInstance();
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -dayOfWeek + 2);
        System.out.println("data = " + calendar.getTime());

        setDayOfMonthOnButtons(calendar, monthAndYear);

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
            lockOrUnlockButton(bookNow);
        });
    }

    private void lockOrUnlockButton(Button bookNow) {
        Boolean result = Objects.nonNull(dateString) && Objects.nonNull(timeString);
        bookNow.setEnabled(result);

    }

    private Integer countNumberOfDayInCircle(Integer dayOfMonth, Integer circleOfNumber,
                                             Integer numberOfDaysInCurrentMonth) {
        Integer different = dayOfMonth + circleOfNumber;
        if (different > numberOfDaysInCurrentMonth) {
            return different - numberOfDaysInCurrentMonth;

        } else {
            return different;
        }
    }

    private void setDayOfMonthOnButtons(Calendar calendar, TextView nameOfMonth) {
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

        Calendar calendarForFirstCircle = (Calendar) calendar.clone();
        String nameOfMonthForFirstCircle = getNameOfMonths(calendarForFirstCircle.get(Calendar.MONTH));

        Calendar calendarForLastCircle = (Calendar) calendar.clone();
        calendarForLastCircle.add(Calendar.DATE, 6);
        String nameOfMonthForLastCircle = getNameOfMonths(calendarForLastCircle.get(Calendar.MONTH));

        if (nameOfMonthForFirstCircle.equals(nameOfMonthForLastCircle)) {
            nameOfMonth.setText(nameOfMonthForFirstCircle);

        } else {
            nameOfMonth.setText(nameOfMonthForFirstCircle + "/ " + nameOfMonthForLastCircle);
        }
//        sun.setBackgroundColor(Color.parseColor("#DD090A"));
    }

    private String getNameOfMonths(Integer numberOfMonth) {

        switch (numberOfMonth) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            default:
                return "December";

        }
    }
}
