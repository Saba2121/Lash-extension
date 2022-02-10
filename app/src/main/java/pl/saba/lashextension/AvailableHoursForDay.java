package pl.saba.lashextension;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.List;

public class AvailableHoursForDay {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
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


