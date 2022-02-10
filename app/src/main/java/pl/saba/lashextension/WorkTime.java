package pl.saba.lashextension;

import java.util.Date;
import java.util.List;

import pl.saba.lashextension.remote.dto.AvailableHoursDto;

public class WorkTime {

    private List<Date> holidayDates;
    private List<AvailableHoursDto> availableHours;

    public WorkTime(List<Date> holidayDates, List<AvailableHoursDto> availableHours) {
        this.holidayDates = holidayDates;
        this.availableHours = availableHours;
    }

    public List<Date> getHolidayDates() {
        return holidayDates;
    }

    public List<AvailableHoursDto> getAvailableHours() {
        return availableHours;
    }

    public void setHolidayDates(List<Date> holidayDates) {
        this.holidayDates = holidayDates;
    }

    public void setAvailableHours(List<AvailableHoursDto> availableHours) {
        this.availableHours = availableHours;
    }


}
