package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.saba.lashextension.servicelist.OnChooseServiceDtoListener;
import pl.saba.lashextension.servicelist.ServiceAdapter;
import pl.saba.lashextension.servicelist.StyleDto;

import static pl.saba.lashextension.EffectType.KIM;
import static pl.saba.lashextension.EffectType.LIGHT;
import static pl.saba.lashextension.EffectType.NATURAL;
import static pl.saba.lashextension.EffectType.VOLUME;


public class ChooseServiceActivity extends AppCompatActivity implements OnChooseServiceDtoListener {
    private StyleDto actualChoose = null;
    private Button makeABooking;
    private String variant;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_choose);

        String effectTypeString = getIntent().getStringExtra("effectType");
        EffectType effectType = EffectType.valueOf(effectTypeString);

        makeABooking = findViewById(R.id.makeABooking);
        RecyclerView recyclerView = findViewById(R.id.servicesRecyclerView);
        ServiceAdapter serviceAdapter = new ServiceAdapter(this);
        List<StyleDto> allServices = Arrays.asList(
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_1), "120 pln", "Approx. 120 mins", NATURAL, "1:1-1"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_2), "120 pln", "Approx. 120 mins", NATURAL, "1:1-2"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_3), "120 pln", "Approx. 120 mins", NATURAL, "1:1-3"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_4), "120 pln", "Approx. 120 mins", NATURAL, "1:1-4"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_5), "120 pln", "Approx. 120 mins", NATURAL, "1:1-5"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_6), "120 pln", "Approx. 120 mins", NATURAL, "1:1-6"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_7), "120 pln", "Approx. 120 mins", NATURAL, "1:1-7"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_8), "120 pln", "Approx. 120 mins", NATURAL, "1:1-8"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_9), "120 pln", "Approx. 120 mins", NATURAL, "1:1-9"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_10), "120 pln", "Approx. 120 mins", NATURAL, "1:1-10"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_11), "120 pln", "Approx. 120 mins", NATURAL, "1:1-11"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_12), "120 pln", "Approx. 120 mins", NATURAL, "1:1-12"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_13), "120 pln", "Approx. 120 mins", NATURAL, "1:1-13"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_14), "120 pln", "Approx. 120 mins", NATURAL, "1:1-14"),
                new StyleDto("1:1", getResources().getDrawable(R.drawable.service_ne_15), "120 pln", "Approx. 120 mins", NATURAL, "1:1-15"),
                new StyleDto("2D", getResources().getDrawable(R.drawable.service_lv_1), "130 pln", "Approx. 120 mins", LIGHT, "2D-1"),
                new StyleDto("2D", getResources().getDrawable(R.drawable.service_lv_2), "130 pln", "Approx. 120 mins", LIGHT, "2D-2"),
                new StyleDto("2D", getResources().getDrawable(R.drawable.service_lv_3), "130 pln", "Approx. 120 mins", LIGHT, "2D-3"),
                new StyleDto("2D", getResources().getDrawable(R.drawable.service_lv_4), "130 pln", "Approx. 120 mins", LIGHT, "2D-4"),
                new StyleDto("2D", getResources().getDrawable(R.drawable.service_lv_5), "130 pln", "Approx. 120 mins", LIGHT, "2D-5"),
                new StyleDto("3D", getResources().getDrawable(R.drawable.service_lv_6), "140 pln", "Approx. 120 mins", LIGHT, "3D-1"),
                new StyleDto("3D", getResources().getDrawable(R.drawable.service_lv_7), "140 pln", "Approx. 120 mins", LIGHT, "3D-2"),
                new StyleDto("3D", getResources().getDrawable(R.drawable.service_lv_8), "140 pln", "Approx. 120 mins", LIGHT, "3D-"),
                new StyleDto("3D", getResources().getDrawable(R.drawable.service_lv_9), "140 pln", "Approx. 120 mins", LIGHT, "3D-4"),
                new StyleDto("3D", getResources().getDrawable(R.drawable.service_lv_10), "140 pln", "Approx. 120 mins", LIGHT, "3D-5"),
                new StyleDto("4D", getResources().getDrawable(R.drawable.service_lv_11), "150 pln", "Approx. 120 mins", LIGHT, "4D-1"),
                new StyleDto("4D", getResources().getDrawable(R.drawable.service_lv_12), "150 pln", "Approx. 120 mins", LIGHT, "4D-2"),
                new StyleDto("4D", getResources().getDrawable(R.drawable.service_lv_13), "150 pln", "Approx. 120 mins", LIGHT, "4D-3"),
                new StyleDto("4D", getResources().getDrawable(R.drawable.service_lv_14), "150 pln", "Approx. 120 mins", LIGHT, "4D-4"),
                new StyleDto("4D", getResources().getDrawable(R.drawable.service_lv_15), "150 pln", "Approx. 120 mins", LIGHT, "4D-5"),
                new StyleDto("5D", getResources().getDrawable(R.drawable.service_mv_1), "160 pln", "Approx. 120 mins", VOLUME, "5D-1"),
                new StyleDto("5D", getResources().getDrawable(R.drawable.service_mv_2), "160 pln", "Approx. 120 mins", VOLUME, "5D-2"),
                new StyleDto("5D", getResources().getDrawable(R.drawable.service_mv_3), "160 pln", "Approx. 120 mins", VOLUME, "5D-3"),
                new StyleDto("5D", getResources().getDrawable(R.drawable.service_mv_4), "160 pln", "Approx. 120 mins", VOLUME, "5D-4"),
                new StyleDto("5D", getResources().getDrawable(R.drawable.service_mv_5), "160 pln", "Approx. 120 mins", VOLUME, "5D-5"),
                new StyleDto("6D", getResources().getDrawable(R.drawable.service_mv_6), "170 pln", "Approx. 120 mins", VOLUME, "6D-1"),
                new StyleDto("6D", getResources().getDrawable(R.drawable.service_mv_7), "170 pln", "Approx. 120 mins", VOLUME, "6D-2"),
                new StyleDto("6D", getResources().getDrawable(R.drawable.service_mv_8), "170 pln", "Approx. 120 mins", VOLUME, "6D-3"),
                new StyleDto("6D", getResources().getDrawable(R.drawable.service_mv_9), "170 pln", "Approx. 120 mins", VOLUME, "6D-4"),
                new StyleDto("6D", getResources().getDrawable(R.drawable.service_mv_10), "170 pln", "Approx. 120 mins", VOLUME, "6D-5"),
                new StyleDto("7D", getResources().getDrawable(R.drawable.service_mv_11), "180 pln", "Approx. 120 mins", VOLUME, "7D-1"),
                new StyleDto("7D", getResources().getDrawable(R.drawable.service_mv_12), "180 pln", "Approx. 120 mins", VOLUME, "7D-2"),
                new StyleDto("7D", getResources().getDrawable(R.drawable.service_mv_13), "180 pln", "Approx. 120 mins", VOLUME, "7D-3"),
                new StyleDto("7D", getResources().getDrawable(R.drawable.service_mv_14), "180 pln", "Approx. 120 mins", VOLUME, "7D-4"),
                new StyleDto("7D", getResources().getDrawable(R.drawable.service_mv_15), "180 pln", "Approx. 120 mins", VOLUME, "7D-5"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_1), "190 pln", "Approx. 120 mins", KIM, "KIM-1"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_2), "190 pln", "Approx. 120 mins", KIM, "KIM-2"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_3), "190 pln", "Approx. 120 mins", KIM, "KIM-3"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_4), "190 pln", "Approx. 120 mins", KIM, "KIM,-4"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_5), "190 pln", "Approx. 120 mins", KIM, "KIM-5"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_6), "190 pln", "Approx. 120 mins", KIM, "KIM-6"),
                new StyleDto("Kim effect", getResources().getDrawable(R.drawable.service_ke_7), "190 pln", "Approx. 120 mins", KIM, "KIM-7"));

        allServices = allServices.stream()
                .filter(serviceDto -> serviceDto.getEffectType().equals(effectType))
                .collect(Collectors.toList());

        serviceAdapter.setServiceList(allServices);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(serviceAdapter);

        makeABooking.setEnabled(false);
        makeABooking.setOnClickListener(v -> openCalendarActivity(effectType, variant));

    }

    public void openCalendarActivity(EffectType effectType, String variant) {
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("effectType", effectType.name());
        intent.putExtra("variant", variant);
        startActivity(intent);

    }

    @Override
    public void setActualChoose(StyleDto serviceDto) {
        this.actualChoose = serviceDto;
        makeABooking.setEnabled(true);
    }

}



