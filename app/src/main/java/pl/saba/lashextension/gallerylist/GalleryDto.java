package pl.saba.lashextension.gallerylist;

import android.graphics.drawable.Drawable;

public class GalleryDto {
    private final Drawable galleryImg;


    public GalleryDto(Drawable galleryImg) {
        this.galleryImg = galleryImg;

    }

    public Drawable getGalleryImg() {
        return this.galleryImg;
    }

}
