package pl.saba.lashextension;

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


}
