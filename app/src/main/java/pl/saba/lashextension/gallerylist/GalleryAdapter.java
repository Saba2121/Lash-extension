package pl.saba.lashextension.gallerylist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    private List<GalleryDto> galleryList = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new GalleryViewHolder(itemView);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

        GalleryDto gallery = galleryList.get(position);
        Drawable galleryImage = gallery.getGalleryImg();
        holder.getGalleryImage().setBackground(galleryImage);

    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public void setGalleryList(List<GalleryDto> galleryList) {
        this.galleryList = galleryList;
    }
}