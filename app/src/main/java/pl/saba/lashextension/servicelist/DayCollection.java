package pl.saba.lashextension.servicelist;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import pl.saba.lashextension.AvailableHoursForDay;

public class DayCollection {
    private List<Date> holidays = Arrays.asList(new Date(System.currentTimeMillis() + (3 * 24 * 60 * 60 * 1000)));
    private List<AvailableHoursForDay> hoursForDayList = Arrays.asList(new AvailableHoursForDay(new Date(),
            Arrays.asList(8, 10)));
//    private List<UnavailableHoursForDay> unavailableHours = Arrays.asList(new )

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

