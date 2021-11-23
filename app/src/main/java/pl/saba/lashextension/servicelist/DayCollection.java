package pl.saba.lashextension.servicelist;

import java.util.Arrays;
import java.util.List;

public class DayCollection {
    private List<Day> holidays = Arrays.asList(new Day(27, 11, 2021));

    public List<Day> getHolidays() {
        return holidays;
    }
}

