package pl.saba.lashextension.servicelist;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

public class ServiceViewHolder extends RecyclerView.ViewHolder {
    private final TextView serviceNameTextView;
    private final ImageView serviceImage;
    private final TextView servicePriceTextView;
    private final RadioButton serviceRadioBtn;
    private final TextView serviceTimeTextView;

    public ServiceViewHolder(@NonNull View itemView) {
        super(itemView);

        serviceNameTextView = itemView.findViewById(R.id.serviceName);
        serviceImage = itemView.findViewById(R.id.serviceImage);
        servicePriceTextView = itemView.findViewById(R.id.servicePrice);
        serviceRadioBtn = itemView.findViewById(R.id.serviceRadioBtn);
        serviceTimeTextView = itemView.findViewById(R.id.serviceTime);
    }

    public TextView getServiceNameTextView() {
        return this.serviceNameTextView;
    }

    public ImageView getServiceImage() {
        return this.serviceImage;
    }

    public TextView getServicePriceTextView() {
        return this.servicePriceTextView;
    }

    public RadioButton getServiceRadioBtn() {
        return this.serviceRadioBtn;
    }

    public TextView getServiceTimeTextView() {
        return this.serviceTimeTextView;
    }
}

