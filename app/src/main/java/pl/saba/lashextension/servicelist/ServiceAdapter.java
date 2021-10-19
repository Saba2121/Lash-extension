package pl.saba.lashextension.servicelist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.saba.lashextension.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceViewHolder> {

    private List<StyleDto> serviceList = new ArrayList<>();
    private Context context;
    private StyleDto actual = null;
    private OnChooseServiceDtoListener onChooseServiceDtoListener;


    public ServiceAdapter(OnChooseServiceDtoListener onChooseServiceDtoListener) {
        this.onChooseServiceDtoListener = onChooseServiceDtoListener;

    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(itemView);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {

        StyleDto service = serviceList.get(position);
        String serviceName = service.getServiceName();
        holder.getServiceNameTextView().setText(serviceName);
        Drawable serviceImage = service.getServiceImage();
        holder.getServiceImage().setBackground(serviceImage);
        String servicePrice = service.getServicePrice();
        holder.getServicePriceTextView().setText(servicePrice);
        RadioButton serviceRadioBtn = holder.getServiceRadioBtn();
        String serviceTime = service.getServiceTime();
        holder.getServiceTimeTextView().setText(serviceTime);
        String serviceVariant = service.getServiceVariant();
        holder.getServiceVariant().setText(serviceVariant);

        if (service.equals(actual)) {
            serviceRadioBtn.setChecked(true);
            holder.getServiceNameTextView().setTextColor(ContextCompat.getColor(context, R.color.purple_700));

        } else {
            serviceRadioBtn.setChecked(false);
            holder.getServiceNameTextView().setTextColor(ContextCompat.getColor(context, R.color.purple_200));
        }
        serviceRadioBtn.setOnClickListener(buttonView -> {
            if (actual == null) {
                actual = service;

            } else {
                int positionToRefresh = serviceList.indexOf(actual);
                actual = service;
                notifyItemChanged(positionToRefresh);
            }
            onChooseServiceDtoListener.setActualChoose(service);

            notifyItemChanged(position);

        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public void setServiceList(List<StyleDto> serviceList) {
        this.serviceList = serviceList;

    }
}
