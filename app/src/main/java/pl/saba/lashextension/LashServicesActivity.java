package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.saba.lashextension.R;

public class LashServicesActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lash_services);

        Button naturalEffect = findViewById(R.id.naturalEffectBtn);
        Button lightVolume = findViewById(R.id.lightVolumeBtn);
        Button kimEffect = findViewById(R.id.kimEffectBtn);
        Button megaVolume = findViewById(R.id.megaVolumeBtn);
        Button contact = findViewById(R.id.contactBtn);
        Button gallery = findViewById(R.id.galleryBtn);

        naturalEffect.setOnClickListener(v -> openChooseServiceActivity(EffectType.NATURAL));
        lightVolume.setOnClickListener(v -> openChooseServiceActivity(EffectType.LIGHT));
        megaVolume.setOnClickListener(v -> openChooseServiceActivity(EffectType.VOLUME));
        kimEffect.setOnClickListener(v -> openChooseServiceActivity(EffectType.KIM));

        contact.setOnClickListener(v -> openContactActivity());
        gallery.setOnClickListener(v -> openGalleryActivity());

    }

    public void openChooseServiceActivity(EffectType effectType) {
        Intent intent = new Intent(this, ChooseServiceActivity.class);
        intent.putExtra("effectType", effectType.name());
        startActivity(intent);
    }

    public void openGalleryActivity() {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void openContactActivity() {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}
