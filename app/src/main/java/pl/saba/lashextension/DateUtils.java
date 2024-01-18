package pl.saba.lashextension;


import android.graphics.Color;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public static String toPrettyDate(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

    public static String getNameOfMonth(Integer numberOfMonth) {

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

    public static void markHoliday(Date date, List<Button> buttons, Calendar calendar) {

        Date dateOfFirstCircle = calendar.getTime();
        long dayDifference = ChronoUnit.DAYS.between(dateOfFirstCircle.toInstant(), date.toInstant());

        if (dayDifference >= 0 && dayDifference <= 6) {
            Button button = buttons.get((int) dayDifference);
            button.setEnabled(false);
            button.setTextColor(Color.parseColor("#DD040A"));
        }
    }

    public static void markCurrentDay(List<Button> buttons, Calendar calendar) {

        Date now = new Date();
        Date dateOfFirstCircle = calendar.getTime();
        long dayDifference = ChronoUnit.DAYS.between(dateOfFirstCircle.toInstant(), now.toInstant());

        if (dayDifference >= 0 && dayDifference <= 6) {
            Button button = buttons.get((int) dayDifference);
            button.setTextColor(Color.parseColor("#7cfc00"));
        }
    }

    public static Boolean canClickPreviousButton(Calendar calendar) {

        Date now = new Date();
        return now.getTime() <= calendar.getTime().getTime();
    }

    public static long toTimestamp(String date, String hour) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.parse(date + " " + hour).getTime();

        } catch (ParseException e) {
            e.printStackTrace();

            return 0;
        }

    }
//    toTimestamp - trzeba przekonwertować tą datę i czas na timestampa.
//    google - w jaki sposob przekonwertowac string do daty (String to Date in java)
//    text konwertujemy na datę a z daty wyciągam Timestampa.


}

