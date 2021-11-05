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
        TextView monthAndYear = findViewById(R.id.monthAndYearTextView);
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
            setDateOfMonthOnButtons(calendar, monthAndYear);
        });

        previous.setOnClickListener(v -> {
            calendar.add(Calendar.DATE, -7);
            setDateOfMonthOnButtons(calendar, monthAndYear);

        });
        mon.setOnClickListener(v -> {
            saveDate.setText("date");
//            dateString =date;
            lockAndUnlockButton(bookNow);
        });

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        setDateOfMonthOnButtons(calendar, monthAndYear);

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

    private Integer countNumberOfDayInCircle(Integer dayOfMonth, Integer dayOfWeek,
                                             Integer circleOfNumber, Integer numberOfDaysInCurrentMonth,
                                             Integer numberOfDaysInPreviousMonth) {
        Integer different = dayOfMonth - dayOfWeek + circleOfNumber;
        if (different > numberOfDaysInCurrentMonth) {
            return different - numberOfDaysInCurrentMonth;
        } else if (different < 1) {
            return different + numberOfDaysInPreviousMonth;
        } else {
            return different;
        }
    }

    private void setDateOfMonthOnButtons(Calendar calendar, TextView monthAndYear) {
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH) + 1;
        Integer daysInMonth = YearMonth.of(year, month).lengthOfMonth();
        Integer daysInPreviousMonth = YearMonth.of(year, month).lengthOfMonth();

        mon.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                2, daysInMonth, daysInPreviousMonth)));
        tue.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                3, daysInMonth, daysInPreviousMonth)));
        wed.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                4, daysInMonth, daysInPreviousMonth)));
        thu.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                5, daysInMonth, daysInPreviousMonth)));
        fri.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                6, daysInMonth, daysInPreviousMonth)));
        sat.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                7, daysInMonth, daysInPreviousMonth)));
        sun.setText(String.valueOf(countNumberOfDayInCircle(dayOfMonth, dayOfWeek,
                8, daysInMonth, daysInPreviousMonth)));
        monthAndYear.setText(((setNameOfMonths(calendar.get(Calendar.JANUARY)))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.FEBRUARY))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.MARCH))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.APRIL))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.MAY))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.JUNE))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.JULY))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.AUGUST))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.SEPTEMBER))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.OCTOBER))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.NOVEMBER))));
        monthAndYear.setText((setNameOfMonths(calendar.get(Calendar.DECEMBER))));
//        sun.setBackgroundColor(Color.parseColor("#DD090A"));

    }

    private String setNameOfMonths(Integer numberOfMonth) {

        String nameOfMonth;

        switch (numberOfMonth) {
            case 0:
                return "January 2021";
            case 1:
                return "February 2021";
            case 2:
                return "March 2021";
            case 3:
                return "April 2021";
            case 4:
                return "May 2021";
            case 5:
                return "June 2021";
            case 6:
                return "July 2021";
            case 7:
                return "August 2021";
            case 8:
                return "September 2021";
            case 9:
                return "October 2021";
            case 10:
                return "November 2021";
            case 11:
                return "December 2021";
        }
//        return numberOfMonth;
        return "January";


//        String month;
//
//        if (numberOfMonth == 0) {
//            month = "January";
//        } else if (numberOfMonth == 1) {
//            month = "February";
//        } else if (numberOfMonth == 2) {
//            month = "March";
//        } else if (numberOfMonth == 3) {
//            month = "April";
//        } else if (numberOfMonth == 4) {
//            month = "May";
//        } else if (numberOfMonth == 5) {
//            month = "June";
//        } else if (numberOfMonth == 6) {
//            month = "July";
//
//
//        } else {
//            month = "December";
//        }

//        switch (numberOfMonth) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                System.out.println("31");
//            case 2:
//                System.out.println("28");
//            default:
//                System.out.println("30");
//        }


    }
//    private static String getDay (String month, String year){
//        int mm = Integer.parseInt(month);
//        int yy = Integer.parseInt(year);
//        LocalDate dt = LocalDate.of(mm, yy);
//        return dt.getDayOfWeek().toString().toUpperCase();
//    }
}
