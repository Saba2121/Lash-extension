package pl.saba.lashextension;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


public class ImageBase64Utils {

    public static Bitmap getImageInBase64(String imageInBase64) {

        byte[] bytes = Base64.decode(imageInBase64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return bitmap;


    }
}