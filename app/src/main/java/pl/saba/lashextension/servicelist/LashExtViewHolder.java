package pl.saba.lashextension.servicelist;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

public class LashExtViewHolder extends RecyclerView.ViewHolder {
    private final TextView serviceNameTextView;
    //    private final TextView serviceImage;
    private final TextView servicePriceTextView;
    private final RadioButton serviceRadioBtn;
    private final TextView serviceTimeTextView;
    private final TextView serviceVariant;

    public LashExtViewHolder(@NonNull View itemView) {
        super(itemView);

        serviceNameTextView = itemView.findViewById(R.id.serviceName);
//        serviceImage = itemView.findViewById(R.id.serviceImage);
        servicePriceTextView = itemView.findViewById(R.id.servicePrice);
        serviceRadioBtn = itemView.findViewById(R.id.serviceRadioBtn);
        serviceTimeTextView = itemView.findViewById(R.id.serviceTime);
        serviceVariant = itemView.findViewById(R.id.serviceVariant);
    }

    public TextView getServiceNameTextView() {
        return this.serviceNameTextView;
    }

//    public TextView getServiceImage() {
//        return this.serviceImage;
//    }

    public TextView getServicePriceTextView() {
        return this.servicePriceTextView;
    }

    public RadioButton getServiceRadioBtn() {
        return this.serviceRadioBtn;
    }

    public TextView getServiceTimeTextView() {
        return this.serviceTimeTextView;
    }

    public TextView getServiceVariant() {
        return this.serviceVariant;
    }
}

