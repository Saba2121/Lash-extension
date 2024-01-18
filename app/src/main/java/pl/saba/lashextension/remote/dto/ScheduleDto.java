package pl.saba.lashextension.remote.dto;

import java.util.Date;
import java.util.List;

public class ScheduleDto {

    private List<Date> holidayDates;
    private List<WorkHourDto> availableHours;

    public ScheduleDto(List<Date> holidayDates, List<WorkHourDto> availableHours) {
        this.holidayDates = holidayDates;
        this.availableHours = availableHours;
    }

    public List<Date> getHolidayDates() {
        return holidayDates;
    }

    public List<WorkHourDto> getAvailableHours() {
        return availableHours;
    }

    public void setHolidayDates(List<Date> holidayDates) {
        this.holidayDates = holidayDates;
    }

    public void setAvailableHours(List<WorkHourDto> availableHours) {
        this.availableHours = availableHours;
    }
}
