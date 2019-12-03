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
import com.example.matkaexibitioncenter.interfaces.ExibitClickListener;
import com.example.matkaexibitioncenter.models.ExibitJsonModel;
import com.example.matkaexibitioncenter.models.ExibitJsonModeltwo;
import com.example.matkaexibitioncenter.models.ExibitModel;

import java.util.ArrayList;
import java.util.List;

public class ExibitsAdapter extends RecyclerView.Adapter<ExibitsAdapter.ExibitsViewHolder> {

    Context context;
    LayoutInflater inflater;
    ExibitClickListener listener;
    ArrayList<ExibitJsonModeltwo> exibitlist;


    public ExibitsAdapter(Context context, ArrayList<ExibitJsonModeltwo> exibits, ExibitClickListener listener) {
        this.context = context;
        this.exibitlist = exibits;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExibitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_exibit, parent, false);
        return new ExibitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExibitsViewHolder holder, int position) {
      ///  ExibitModel exibitModel = exibits.get(position);
        ExibitJsonModeltwo exibit = exibitlist.get(position);

        String mDrawableName = exibit.getImages().get(0);
        int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());

        holder.exibitTitle.setText(exibit.getTitle());
        holder.exibitimage.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return exibitlist.size();
    }

    public class ExibitsViewHolder extends RecyclerView.ViewHolder {

        ImageView exibitimage;
        TextView exibitTitle;

        public ExibitsViewHolder(@NonNull View itemView) {
            super(itemView);
            exibitimage = (ImageView) itemView.findViewById(R.id.item_exibitcard_img_id);
            exibitTitle = (TextView) itemView.findViewById(R.id.item_exibitcard_title_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onExibitClicked(exibitlist.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
