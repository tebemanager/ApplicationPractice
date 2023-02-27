package com.application.practices.mvvmDemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.practices.databinding.DataCardBinding;
import com.application.practices.mvvmDemo.model.DataResponse;
import com.application.practices.mvvmDemo.model.HealthItem;

/**
 * Created by Charles Raj I on 30/04/22.
 *
 * @author Charles Raj I
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private DataResponse dataResponse;
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public DataResponse getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
        notifyItemChanged(0,dataResponse);
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(DataCardBinding.inflate(LayoutInflater.from(context)));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        HealthItem healthItem = dataResponse.getData().getHealth().get(position);
        holder.onBind(healthItem);
    }

    @Override
    public int getItemCount() {
        return dataResponse != null? dataResponse.getData().getHealth().size():0;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        private final DataCardBinding dataCardBinding;
        public DataViewHolder(@NonNull DataCardBinding itemView) {
            super(itemView.getRoot());
            dataCardBinding = itemView;
        }

        /*use to set and get the data in XML*/
        public void onBind(HealthItem healthItem){
            dataCardBinding.title.setText(healthItem.getName());

            InnerDataAdapter innerDataAdapter = new InnerDataAdapter(itemView.getContext(), healthItem.getAccessible());
            innerDataAdapter.setAccessibleItem(healthItem.getAccessible());
            dataCardBinding.innerList.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            dataCardBinding.innerList.setAdapter(innerDataAdapter);
        }
    }
}
