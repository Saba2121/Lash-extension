package pl.saba.lashextension;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;
import static pl.saba.lashextension.CalendarActivityHelper.countNumberOfDayInCircle;
import static pl.saba.lashextension.DateUtils.canClickPreviousButton;
import static pl.saba.lashextension.DateUtils.markCurrentDay;
import static pl.saba.lashextension.DateUtils.markHoliday;

public class CalendarActivity extends AppCompatActivity {
    private String dateString = null, timeString = null;
    private Button bookNow, mon, tue, wed, thu, fri, sat, sun, eight, ten, twelve, two, four, six, dialog;
    private Calendar calendar;
    private TextView saveDate, saveHour;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);
        String variant = getIntent().getStringExtra("variant");

        dialog = findViewById(R.id.dialogBtn);
        bookNow = findViewById(R.id.bookNow);
        saveHour = findViewById(R.id.saveHour);
        saveDate = findViewById(R.id.saveDate);
        TextView monthAndYear = findViewById(R.id.nameOfMonthTextView);
        Button next = findViewById(R.id.nextBtn);
        Button previous = findViewById(R.id.previousBtn);
        eight = findViewById(R.id.eight);
        ten = findViewById(R.id.ten);
        twelve = findViewById(R.id.twelve);
        two = findViewById(R.id.two);
        four = findViewById(R.id.four);
        six = findViewById(R.id.six);
        mon = findViewById(R.id.monBtn);
        tue = findViewById(R.id.tueBtn);
        wed = findViewById(R.id.wedBtn);
        thu = findViewById(R.id.thuBtn);
        fri = findViewById(R.id.friBtn);
        sat = findViewById(R.id.satBtn);
        sun = findViewById(R.id.sunBtn);

        DayCollection dayCollection = new DayCollection();

        next.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, 7);
            refreshDayButtons(calendar, monthAndYear, dayCollection);
        });

        previous.setOnClickListener(v -> {
            if (canClickPreviousButton(calendar)) {
                calendar.add(Calendar.DATE, -7);
                refreshDayButtons(calendar, monthAndYear, dayCollection);
            }
        });

        calendar = Calendar.getInstance();
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -dayOfWeek + 2);
        System.out.println("data = " + calendar.getTime());

        mon.setOnClickListener(v -> refreshAvailableHours(0, dayCollection));
        tue.setOnClickListener(v -> refreshAvailableHours(1, dayCollection));
        wed.setOnClickListener(v -> refreshAvailableHours(2, dayCollection));
        thu.setOnClickListener(v -> refreshAvailableHours(3, dayCollection));
        fri.setOnClickListener(v -> refreshAvailableHours(4, dayCollection));
        sat.setOnClickListener(v -> refreshAvailableHours(5, dayCollection));
        sun.setOnClickListener(v -> refreshAvailableHours(6, dayCollection));

        refreshDayButtons(calendar, monthAndYear, dayCollection);

        setTimeOnControls(eight);
        setTimeOnControls(ten);
        setTimeOnControls(twelve);
        setTimeOnControls(two);
        setTimeOnControls(four);
        setTimeOnControls(six);

        dialog.setOnClickListener(v -> {
            openDialogActivity();
        });

        bookNow.setOnClickListener(v ->
                openPersonActivity(effectType, dateString, timeString, variant));
    }

    public void openDialogActivity() {
        DialogActivity dialogActivity = new DialogActivity();
        dialogActivity.show(getSupportFragmentManager(), " ");
    }

    public void openPersonActivity(EffectType effectType, String dateString, String timeString, String variant) {
        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("effectType", effectType.name());
        intent.putExtra("date", dateString);
        intent.putExtra("time", timeString);
        intent.putExtra("variant", variant);
        startActivity(intent);
    }

    public void setTimeOnControls(Button button) {
        button.setOnClickListener(v -> {
            timeString = button.getText().toString();
            saveHour.setText(timeString);
            CalendarActivityHelper.lockOrUnlockButton(bookNow, timeString, dateString);
        });
    }

    private void refreshDayButtons(Calendar calendar, TextView nameOfMonth, DayCollection dayCollection) {
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

        List<Button> buttons = Arrays.asList(mon, tue, wed, thu, fri, sat, sun);
        buttons.forEach(button -> button.setTextColor(Color.parseColor("#000000")));
        markCurrentDay(buttons, calendar);
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
        List<Date> holidays = dayCollection.getHolidays();
        holidays.forEach(date -> markHoliday(date, buttons, calendar));
    }

    public void refreshAvailableHours(Integer numberOfDaysToAdd, DayCollection dayCollection) {

        Date date = calendar.getTime();
        dateString = date.toString();
        Calendar calendarCopy = (Calendar) calendar.clone();
        calendarCopy.add(Calendar.DATE, numberOfDaysToAdd);
        Date dateAfterAddDays = calendarCopy.getTime();
        List<Button> hourButtons = Arrays.asList(eight, ten, twelve, two, four, six);
        hourButtons.forEach(button -> button.setEnabled(false));
        saveHour.setText("");
        timeString = null;
        AvailableHoursForDay availableHoursForDay = dayCollection.getAvailableHoursForDay(dateAfterAddDays);

        if (availableHoursForDay != null) {
            List<Integer> hoursList = availableHoursForDay.getAvailableHours();
            hoursList
                    .forEach(integer -> {
                        if (integer == 8) {
                            eight.setEnabled(true);

                        }
                        if (integer == 10) {
                            ten.setEnabled(true);

                        }
                        if (integer == 12) {
                            twelve.setEnabled(true);

                        }
                        if (integer == 2) {
                            two.setEnabled(true);

                        }
                        if (integer == 4) {
                            four.setEnabled(true);

                        }
                        if (integer == 6) {
                            six.setEnabled(true);

                        }
                    });
        }
        String prettyDate = DateUtils.getDayAndMonth(calendarCopy.getTime());
        saveDate.setText(prettyDate);
        dateString = prettyDate;
        CalendarActivityHelper.lockOrUnlockButton(bookNow, timeString, dateString);
    }
}






