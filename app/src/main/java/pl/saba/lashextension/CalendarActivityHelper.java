package pl.saba.lashextension;

import android.widget.Button;

import java.util.Objects;

public class CalendarActivityHelper {

    public static Integer countNumberOfDayInCircle(Integer dayOfMonth, Integer numberToAdd,
                                                   Integer numberOfDaysInCurrentMonth) {
        Integer dayOfMonthCandidate = dayOfMonth + numberToAdd;
        if (dayOfMonthCandidate > numberOfDaysInCurrentMonth) {
            return dayOfMonthCandidate - numberOfDaysInCurrentMonth;

        } else {
            return dayOfMonthCandidate;
        }
    }

    public static void lockOrUnlockButton(Button bookNow, String dateString, String timeString) {
        Boolean result = Objects.nonNull(dateString) && Objects.nonNull(timeString);
        bookNow.setEnabled(result);
    }
}
