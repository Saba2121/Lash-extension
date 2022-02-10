package pl.saba.lashextension.servicelist;

import android.content.Context;
import android.graphics.Bitmap;
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

import pl.saba.lashextension.ImageBase64Utils;
import pl.saba.lashextension.OnChooseLashExtDtoListener;

public class LashExtAdapter extends RecyclerView.Adapter<LashExtViewHolder> {

    private List<LashExt> lashExtList = new ArrayList<>();
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

        LashExt lashExt = lashExtList.get(position);
        String lashExtName = lashExt.getLashExtName();
        holder.getLashExtNameTextView().setText(lashExtName);


        String lashExtImage = lashExt.getLashExtImage();
        Bitmap bitmap = ImageBase64Utils.getImageInBase64(lashExtImage);
        holder.getLashExtImage().setImageBitmap(bitmap);

        String lashExtPrice = lashExt.getLashExtPrice();
        holder.getLahExtPriceTextView().setText(lashExtPrice);
        RadioButton lashExtRadioBtn = holder.getLashExtRadioBtn();
        String lashExtTime = lashExt.getLashExtTime();
        holder.getLashExtTimeTextView().setText(lashExtTime);
        String lashExtVariant = lashExt.getLashExtVariant();
        holder.getLashExtVariant().setText(lashExtVariant);

        if (lashExt.equals(actual)) {
            lashExtRadioBtn.setChecked(true);
            holder.getLashExtNameTextView().setTextColor(ContextCompat.getColor(context, R.color.purple_700));

        } else {
            lashExtRadioBtn.setChecked(false);
            holder.getLashExtNameTextView().setTextColor(ContextCompat.getColor(context, R.color.purple_200));
        }
        lashExtRadioBtn.setOnClickListener(buttonView -> {
            if (actual == null) {
                actual = lashExt;

            } else {
                int positionToRefresh = lashExtList.indexOf(actual);
                actual = lashExt;
                notifyItemChanged(positionToRefresh);
            }
            onChooseLashExtDtoListener.setActualChoose(lashExt);

            notifyItemChanged(position);

        });
    }

    @Override
    public int getItemCount() {
        return lashExtList.size();
    }

    public void setLashExtList(List<LashExt> lashExtList) {
        this.lashExtList = lashExtList;
        notifyDataSetChanged();

    }
}
