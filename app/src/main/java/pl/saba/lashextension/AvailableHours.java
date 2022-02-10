package pl.saba.lashextension;

import java.util.Date;
import java.util.List;

public class AvailableHours {

    private Date date;
    private List<Integer> hours;

    public AvailableHours(Date date, List<Integer> hours) {
        this.date = date;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }
}
