package com.example.matkaexibitioncenter.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.models.ExibitModel;

import java.util.ArrayList;

public class ExibitsAdapter extends RecyclerView.Adapter<ExibitsAdapter.ExibitsViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<ExibitModel> exibits;

    public ExibitsAdapter(Context context, ArrayList<ExibitModel> exibits) {
        this.context = context;
        this.exibits = exibits;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ExibitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_exibit, parent, false);
        return new ExibitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExibitsViewHolder holder, int position) {
        ExibitModel exibitModel = exibits.get(position);
        holder.exibitTitle.setText(exibitModel.getTitle());
        holder.exibitimage.setImageResource(exibitModel.getImage());
    }

    @Override
    public int getItemCount() {
        return exibits.size();
    }

    public class ExibitsViewHolder extends RecyclerView.ViewHolder {

        ImageView exibitimage;
        TextView exibitTitle;

        public ExibitsViewHolder(@NonNull View itemView) {
            super(itemView);
            exibitimage = (ImageView) itemView.findViewById(R.id.item_exibitcard_img_id);
            exibitTitle = (TextView) itemView.findViewById(R.id.item_exibitcard_title_id);
        }
    }
}
