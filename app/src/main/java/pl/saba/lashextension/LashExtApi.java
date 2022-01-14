package pl.saba.lashextension;

import java.util.List;

import io.reactivex.Observable;
import pl.saba.lashextension.remote.dto.LashExtDto;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LashExtApi {

    @GET("/api/v1/styles")
    Observable<List<LashExtDto>> getLashExt(@Query("effect-type") EffectType effectType);

}
