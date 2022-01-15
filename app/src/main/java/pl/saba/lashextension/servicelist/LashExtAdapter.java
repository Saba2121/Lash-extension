package pl.saba.lashextension.servicelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
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

import pl.saba.lashextension.ImageUtils;
import pl.saba.lashextension.OnChooseLashExtDtoListener;

public class LashExtAdapter extends RecyclerView.Adapter<LashExtViewHolder> {

    private List<LashExt> serviceList = new ArrayList<>();
    private Context context;
    private LashExt actual = null;
    private OnChooseLashExtDtoListener onChooseLashExtDtoListener;

    public LashExtAdapter(OnChooseLashExtDtoListener onChooseLashExtDtoListener) {
        this.onChooseLashExtDtoListener = onChooseLashExtDtoListener;

    }

    @Override
    public LashExtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lash_ext, parent, false);
        return new LashExtViewHolder(itemView);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public void onBindViewHolder(@NonNull LashExtViewHolder holder, int position) {

        LashExt service = serviceList.get(position);
        String serviceName = service.getServiceName();
        holder.getServiceNameTextView().setText(serviceName);
        String serviceImage = service.getServiceImage();

        // decode base64 string
        byte[] bytes = Base64.decode(ImageUtils.getImageInBase64(), Base64.DEFAULT);
        // Initialize bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        // set bitmap on imageView
        holder.getServiceImage().setImageBitmap(bitmap);

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
            onChooseLashExtDtoListener.setActualChoose(service);

            notifyItemChanged(position);

        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public void setServiceList(List<LashExt> serviceList) {
        this.serviceList = serviceList;
        notifyDataSetChanged();

    }
}
