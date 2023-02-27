package com.application.practices.mvvmDemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.application.practices.R;
import com.application.practices.databinding.InnerItemBinding;
import com.application.practices.mvvmDemo.model.AccessibleItem;

import java.util.List;

/**
 * Created by Charles Raj I on 30/04/22.
 *
 * @author Charles Raj I
 */
public class InnerDataAdapter extends RecyclerView.Adapter<InnerDataAdapter.InnerDataViewHolder> {
    private final Context context;
    private List<AccessibleItem> accessibleItem;
    public InnerDataAdapter(Context context, List<AccessibleItem> accessible) {
        this.context = context;
        this.accessibleItem = accessible;
    }

    public List<AccessibleItem> getAccessibleItem() {
        return accessibleItem;
    }

    public void setAccessibleItem(List<AccessibleItem> accessibleItem) {
        this.accessibleItem = accessibleItem;
        notifyItemChanged(0,accessibleItem);
    }

    @NonNull
    @Override
    public InnerDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerDataViewHolder(InnerItemBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerDataViewHolder holder, int position) {
        AccessibleItem accessibleItem = getAccessibleItem().get(position);
        holder.onBind(accessibleItem);
        if (getAccessibleItem().size()-1 == position){
            holder.itemView.bottomLine.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return accessibleItem.size();
    }

    public static class InnerDataViewHolder extends RecyclerView.ViewHolder{
        InnerItemBinding itemView;
        public InnerDataViewHolder(@NonNull InnerItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
        public void onBind(AccessibleItem accessibleItem){
            itemView.textOne.setText(accessibleItem.getType());
            itemView.textTwo.setText(accessibleItem.isSuccess()?"TRUE":"FALSE");

            if (accessibleItem.isSuccess()){
                changeOver(R.drawable.check_green_bg,R.color.green,R.drawable.check_box);
            }else {
                changeOver(R.drawable.check_red_bg,R.color.red,R.drawable.ic_baseline_add_circle_24);
                itemView.checkImage.setRotation(45);
            }

        }
        /*Use this method for change the color codes in the XML*/
        @SuppressLint("UseCompatLoadingForDrawables")
        public void changeOver(int background, int color, int icon){
            itemView.relativeTwo.setBackground(itemView.getRoot().getContext().getDrawable(background));
            itemView.textTwo.setTextColor(itemView.getRoot().getContext().getResources().getColor(color));
            itemView.checkImage.setColorFilter(ContextCompat.getColor(itemView.getRoot().getContext(), color), android.graphics.PorterDuff.Mode.SRC_IN);
            Drawable myDrawable = itemView.getRoot().getContext().getResources().getDrawable(icon);
            itemView.checkImage.setImageDrawable(myDrawable);
        }
    }
}
