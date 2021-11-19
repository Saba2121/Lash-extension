package pl.saba.lashextension;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getDayAndMonth(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM", Locale.ENGLISH);
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
}

