package com.example.matkaexibitioncenter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.interfaces.HistoryImgListener;
import com.example.matkaexibitioncenter.models.HistoryModel;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    LayoutInflater inflater;
    List<HistoryModel> historyData;
    Context context;
    HistoryImgListener listener;

    public HistoryAdapter(List<HistoryModel> historyData, Context context, HistoryImgListener listener) {
        this.historyData = historyData;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        HistoryModel history = historyData.get(position);
        holder.historyPic.setImageResource(history.getImage());
    }

    @Override
    public int getItemCount() {
        return historyData.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        ImageView historyPic;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            historyPic = (ImageView) itemView.findViewById(R.id.history_pic_id);
            historyPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onHistoryImgClicked(historyData.get(getAdapterPosition()));
                }
            });
        }
    }
}
