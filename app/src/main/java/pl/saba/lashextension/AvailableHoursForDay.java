package pl.saba.lashextension;

import java.util.Date;
import java.util.List;

public class AvailableHoursForDay {

    private Date date;
    private List<Integer> availableHours;


    public AvailableHoursForDay(Date date, List<Integer> availableHours) {
        this.date = date;
        this.availableHours = availableHours;
    }

    public Date getDate() {
        return date;
    }

    public List<Integer> getAvailableHours() {
        return availableHours;
    }
}


