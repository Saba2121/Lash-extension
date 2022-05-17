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
import pl.saba.lashextension.remote.dto.VisitDto;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        TextView value = findViewById(R.id.orderLashExtTypeValue);
        TextView valueDate = findViewById(R.id.orderLashExtDateValue);
        TextView valueTime = findViewById(R.id.orderLashExtHourValue);
        TextView valueVariant = findViewById(R.id.orderLashExtVariantValue);
        TextView valueName = findViewById(R.id.orderLashExtNameValue);
        TextView valueSurname = findViewById(R.id.orderLashExtSurnameValue);
        TextView valueNumberPhone = findViewById(R.id.orderLashExtPhoneNumberValue);
        Button submit = findViewById(R.id.submitBtn);

        String name = getIntent().getStringExtra("name");
        valueName.setText(name);

        String surname = getIntent().getStringExtra("surname");
        valueSurname.setText(surname);

        String numberPhone = getIntent().getStringExtra("numberPhone");
        valueNumberPhone.setText(numberPhone);

        String date = getIntent().getStringExtra("date");
        valueDate.setText(date);

        String time = getIntent().getStringExtra("time");
        valueTime.setText(time);
        Long timestamp = DateUtils.toTimestamp(date, time);

        String effectTypeString = getIntent().getStringExtra("effectType");
        value.setText(effectTypeString);
        EffectType effectType = EffectType.valueOf(effectTypeString);

        String variant = getIntent().getStringExtra("variant");
        valueVariant.setText(variant);


        submit.setOnClickListener(v -> {
            addVisit(name, surname, numberPhone, timestamp, effectType, variant);

        });

    }

    public void addVisit(String name, String surname, String numberPhone, Long timestamp,
                         EffectType effectType, String variant) {

        VisitDto visitDto = new VisitDto(name, surname, numberPhone, timestamp, effectType, variant);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        LashExtApi lashExtApi = retrofit.create(LashExtApi.class);
        lashExtApi.addVisit(visitDto)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("on complete");
                        openMainActivity();


                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            Integer responseCode = httpException.code();
                            if (responseCode == 434) {
                                showMessageVisitAlreadyExist();
                                return;
                            }
                        }
                        e.printStackTrace();


                    }
                });

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Your visit is confirmed", Toast.LENGTH_SHORT).show();

    }

    private void showMessageVisitAlreadyExist() {
        Toast.makeText(this, "Visit already exists on this date. Please choose another", Toast.LENGTH_SHORT).show();
        System.out.println("Visit already exists");
    }

}
