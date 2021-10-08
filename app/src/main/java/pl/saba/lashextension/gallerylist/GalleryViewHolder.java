package pl.saba.lashextension.gallerylist;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

public class GalleryViewHolder extends RecyclerView.ViewHolder {
    private final ImageView galleryImage;

    public GalleryViewHolder(@NonNull View itemView) {
        super(itemView);

        galleryImage = itemView.findViewById(R.id.imgId1);
    }

    public ImageView getGalleryImage() {
        return this.galleryImage;
    }
}
