package pl.saba.lashextension.remote.dto;

import java.util.Date;
import java.util.List;

public class WorkTimeDto {

    private List<Date> holidayDates;
    private List<AvailableHoursLongDto> availableHours;

    public WorkTimeDto(List<Date> holidayDates, List<AvailableHoursLongDto> availableHours) {
        this.holidayDates = holidayDates;
        this.availableHours = availableHours;
    }

    public List<Date> getHolidayDates() {
        return holidayDates;
    }

    public List<AvailableHoursLongDto> getAvailableHours() {
        return availableHours;
    }

    public void setHolidayDates(List<Date> holidayDates) {
        this.holidayDates = holidayDates;
    }

    public void setAvailableHours(List<AvailableHoursLongDto> availableHours) {
        this.availableHours = availableHours;
    }
}
