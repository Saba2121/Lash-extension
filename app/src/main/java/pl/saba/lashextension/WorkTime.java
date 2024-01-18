package pl.saba.lashextension;

import java.util.Date;
import java.util.List;

import pl.saba.lashextension.remote.dto.WorkHourDto;

public class WorkTime {

    private List<Date> holidayDates;
    private List<WorkHourDto> availableHours;

    public WorkTime(List<Date> holidayDates, List<WorkHourDto> availableHours) {
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
