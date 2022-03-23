package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.saba.lashextension.http.api.LashExtApi;
import pl.saba.lashextension.remote.dto.VisitAddDto;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderDetailsActivity extends AppCompatActivity {

    private Long timestamp;
    private String effectType;
    private String variant;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        TextView value = findViewById(R.id.orderLashExtTypeValue);
        TextView valueDate = findViewById(R.id.orderLashExtDateValue);
        TextView valueTime = findViewById(R.id.orderLashExtHourValue);
        TextView valueVariant = findViewById(R.id.orderLashExtVariantValue);
        Button submit = findViewById(R.id.submitBtn);

        String effectTypeString = getIntent().getStringExtra("effectType");
        value.setText(effectTypeString);

        String date = getIntent().getStringExtra("date");
        valueDate.setText(date);

        String time = getIntent().getStringExtra("time");
        valueTime.setText(time);
        Long timestamp = DateUtils.toTimestamp(date, time);

        String variant = getIntent().getStringExtra("variant");
        valueVariant.setText(variant);

        submit.setOnClickListener(v -> {
            openMainActivity();
            Toast.makeText(this, "Your visit is confirmed", Toast.LENGTH_SHORT).show();
            addVisit();
        });

    }

    public void addVisit() {


        VisitAddDto visitAddDto = new VisitAddDto(null, null, null);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        LashExtApi lashExtApi = retrofit.create(LashExtApi.class);
        lashExtApi.addVisit(visitAddDto)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("on complete");


                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }
                });

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
