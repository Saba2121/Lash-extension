package pl.saba.lashextension.http.api;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import pl.saba.lashextension.EffectType;
import pl.saba.lashextension.remote.dto.LashExtDto;
import pl.saba.lashextension.remote.dto.VisitAddDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LashExtApi {

    @GET("/api/v1/styles")
    Observable<List<LashExtDto>> getLashExt(@Query("effect-type") EffectType effectType);

    @POST("/api/v1/visits")
    Completable addVisit(@Body VisitAddDto visitAddDto);
}
