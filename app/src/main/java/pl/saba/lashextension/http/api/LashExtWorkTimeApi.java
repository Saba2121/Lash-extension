package pl.saba.lashextension.http.api;

import io.reactivex.Observable;
import pl.saba.lashextension.remote.dto.ScheduleDto;
import retrofit2.http.GET;

public interface LashExtWorkTimeApi {

    @GET("/api/v1/android/work-time")
    Observable<ScheduleDto> getWorkTime();
}
























