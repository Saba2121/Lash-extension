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
    Integer numberOfDaysInCurrentMonth = 0;

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
        Button right = findViewById(R.id.rightBtn);
        Button left = findViewById(R.id.leftBtn);
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

        right.setOnClickListener(v -> {
            setDateOfMonthOnButtons(3, 26, 31, 30);
            setNameOfMonth(5);
        });
        left.setOnClickListener(v -> {
            setDateOfMonthOnButtons(3, 19, 31, 30);
        });

        mon.setOnClickListener(v -> {
            saveDate.setText("18.10.2021");
//            dateString =date;
            lockAndUnlockButton(bookNow);
        });

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Integer month = calendar.get(Calendar.MONTH);

//        Month month1 = Month.FEBRUARY;
//        System.out.println(month1.length(true));
//        Month month2 = Month.MAY;
//        System.out.println(month2.length(false));
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);


        setDateOfMonthOnButtons(dayOfWeek, dayOfMonth, 31, 30);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("dayOfMonth = " + dayOfMonth);
        setNameOfMonth(1);

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

    private void setDateOfMonthOnButtons(Integer dayOfWeek, Integer dayOfMonth, Integer numberOfDaysInCurrentMonth, Integer numberOfDaysInPreviousMonth) {
        mon.setText(String.valueOf(dayOfMonth - dayOfWeek + 2));
        tue.setText(String.valueOf(dayOfMonth - dayOfWeek + 3));
        wed.setText(String.valueOf(dayOfMonth - dayOfWeek + 4));
        thu.setText(String.valueOf(dayOfMonth - dayOfWeek + 5));
        fri.setText(String.valueOf(dayOfMonth - dayOfWeek + 6));
        sat.setText(String.valueOf(dayOfMonth - dayOfWeek + 7));
        sun.setText(String.valueOf(dayOfMonth - dayOfWeek + 8));
//        sun.setBackgroundColor(Color.parseColor("#DD090A"));

        if (numberOfDaysInCurrentMonth <= 0) {
            numberOfDaysInCurrentMonth = 30;
        }
    }

    private void setNameOfMonth(Integer numberOfMonth) {
        String daysInMonth;

//        if (numberOfMonth == 4) ||numberOfMonth == 6 || numberOfMonth == 9 || numberOfMonth = 11) {
//            daysInMonth = 30;
//        }else{
//            if (numberOfMonth== 2) {
//                daysInMonth = 28;
//            } else {
//                numberOfMonth = 31;
//            }
//        }

        switch (numberOfMonth) {
            case 0:
                System.out.println("January");
            case 1:
                System.out.println("February");
            default:
        }

        String month;

        if (numberOfMonth == 0) {
            month = "January";
        } else if (numberOfMonth == 1) {
            month = "February";
        } else if (numberOfMonth == 2) {
            month = "March";
        } else if (numberOfMonth == 3) {
            month = "April";
        } else if (numberOfMonth == 4) {
            month = "May";
        } else if (numberOfMonth == 5) {
            month = "June";
        } else if (numberOfMonth == 6) {
            month = "July";


        } else {
            month = "December";
        }

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

}
