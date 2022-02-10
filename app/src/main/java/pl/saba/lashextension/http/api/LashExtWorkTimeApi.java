package pl.saba.lashextension.http.api;

import io.reactivex.Observable;
import pl.saba.lashextension.remote.dto.WorkTimeDto;
import retrofit2.http.GET;

public interface LashExtWorkTimeApi {

    @GET("/api/v1/work-time")
    Observable<WorkTimeDto> getWorkTime();


}
