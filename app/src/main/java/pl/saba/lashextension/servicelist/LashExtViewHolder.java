package pl.saba.lashextension.servicelist;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

public class LashExtViewHolder extends RecyclerView.ViewHolder {
    private final TextView lashExtNameTextView;
    private final ImageView lashExtImage;
    private final TextView lahExtPriceTextView;
    private final RadioButton lashExtRadioBtn;
    private final TextView lashExtTimeTextView;
    private final TextView lashExtVariant;

    public LashExtViewHolder(@NonNull View itemView) {
        super(itemView);

        lashExtNameTextView = itemView.findViewById(R.id.lashExtName);
        lashExtImage = itemView.findViewById(R.id.lashExtImage);
        lahExtPriceTextView = itemView.findViewById(R.id.servicePrice);
        lashExtRadioBtn = itemView.findViewById(R.id.lashExtRadioBtn);
        lashExtTimeTextView = itemView.findViewById(R.id.lashExtTime);
        lashExtVariant = itemView.findViewById(R.id.lashExtVariant);
    }

    public TextView getLashExtNameTextView() {
        return this.lashExtNameTextView;
    }

    public ImageView getLashExtImage() {
        return this.lashExtImage;
    }

    public TextView getLahExtPriceTextView() {
        return this.lahExtPriceTextView;
    }

    public RadioButton getLashExtRadioBtn() {
        return this.lashExtRadioBtn;
    }

    public TextView getLashExtTimeTextView() {
        return this.lashExtTimeTextView;
    }

    public TextView getLashExtVariant() {
        return this.lashExtVariant;
    }
}

