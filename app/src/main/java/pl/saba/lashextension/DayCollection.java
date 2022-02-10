package pl.saba.lashextension;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class DayCollection {

    private List<Date> holidays;
    private List<AvailableHoursForDay> hoursForDayList;


    public void setHolidays(List<Date> holidays) {
        this.holidays = holidays;
    }

    public void setHoursForDayList(List<AvailableHoursForDay> hoursForDayList) {
        this.hoursForDayList = hoursForDayList;
    }

    public List<Date> getHolidays() {
        return holidays;
    }

    public List<AvailableHoursForDay> getHoursForDayList() {
        return hoursForDayList;
    }

    public AvailableHoursForDay getAvailableHoursForDay(Date date) {
        return hoursForDayList.stream()
                .filter(availableHoursForDay -> {
                    long dayDifference = ChronoUnit.DAYS.between(availableHoursForDay.getDate().toInstant(), date.toInstant());
                    return dayDifference == 0;
                })
                .findFirst()
                .orElse(null);

    }
}

