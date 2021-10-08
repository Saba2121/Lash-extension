package pl.saba.lashextension;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

import java.util.Arrays;
import java.util.List;

import pl.saba.lashextension.gallerylist.GalleryAdapter;
import pl.saba.lashextension.gallerylist.GalleryDto;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        RecyclerView recyclerView = findViewById(R.id.galleryRecyclerView);
        GalleryAdapter galleryAdapter = new GalleryAdapter();
        List<GalleryDto> allGallery = Arrays.asList(
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_1)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_2)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_3)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_4)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_5)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_6)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_7)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_8)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_9)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_10)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_11)),
                new GalleryDto(getResources().getDrawable(R.drawable.gallery_12)));

        galleryAdapter.setGalleryList(allGallery);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(galleryAdapter);

        Button goBackGallery = findViewById(R.id.goBackGallery);
        goBackGallery.setOnClickListener(v -> {
            openLashServicesActivity();

        });

    }

    public void openLashServicesActivity() {
        Intent intent = new Intent(this, LashServicesActivity.class);
        startActivity(intent);
    }

}
