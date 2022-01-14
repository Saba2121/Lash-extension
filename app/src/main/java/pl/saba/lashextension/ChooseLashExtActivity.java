package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.saba.lashextension.http.api.LashExtApi;
import pl.saba.lashextension.remote.dto.LashExtDto;
import pl.saba.lashextension.servicelist.LashExt;
import pl.saba.lashextension.servicelist.LashExtAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChooseLashExtActivity extends AppCompatActivity implements OnChooseLashExtDtoListener {
    private LashExt actualChoose = null;
    private Button makeABooking;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lash_ext_choose);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        makeABooking = findViewById(R.id.makeABooking);
        RecyclerView recyclerView = findViewById(R.id.servicesRecyclerView);
        LashExtAdapter lashExtAdapter = new LashExtAdapter(this);

//        List<Style> allServices = Arrays.asList(
//        allServices = allServices.stream()
//                .filter(serviceDto -> serviceDto.getEffectType().equals(effectType))
//                .collect(Collectors.toList());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(lashExtAdapter);

        LashExtApi lashExtApi = retrofit.create(LashExtApi.class);
        lashExtApi.getLashExt(effectType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LashExtDto>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<LashExtDto> lashExtDtos) {

                        List<LashExt> cosmeticServices = lashExtDtos.stream()
                                .map(lashExtDto -> new LashExt(lashExtDto.getEffectType().toString(),
                                        lashExtDto.getServiceImage(),
                                        lashExtDto.getServicePrice(),
                                        lashExtDto.getServiceTime(),
                                        lashExtDto.getEffectType(),
                                        lashExtDto.getServiceVariant()))
                                .collect(Collectors.toList());
                        lashExtAdapter.setServiceList(cosmeticServices);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        makeABooking.setEnabled(false);
        makeABooking.setOnClickListener(v -> openCalendarActivity(effectType, actualChoose.getServiceVariant()));

    }

    public void openCalendarActivity(EffectType effectType, String variant) {
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("effectType", effectType.name());
        intent.putExtra("variant", variant);
        startActivity(intent);
    }

    @Override
    public void setActualChoose(LashExt lashExt) {
        this.actualChoose = lashExt;
        makeABooking.setEnabled(true);
    }

}



