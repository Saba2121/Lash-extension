package pl.saba.lashextension.remote.dto;

import java.util.List;

public class WorkHourDto {

    private Long dateTimeStamp;
    private List<Integer> hours;

    public WorkHourDto(Long dateTimeStamp, List<Integer> hours) {
        this.dateTimeStamp = dateTimeStamp;
        this.hours = hours;
    }

    public Long getDate() {
        return dateTimeStamp;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public void setDate(Long date) {
        this.dateTimeStamp = date;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }
}
