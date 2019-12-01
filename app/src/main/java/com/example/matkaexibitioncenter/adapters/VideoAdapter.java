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
import com.example.matkaexibitioncenter.interfaces.VideoListener;
import com.example.matkaexibitioncenter.models.ExibitModel;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    Context context;
    ArrayList<ExibitModel> dataVideos;
    LayoutInflater inflater;
    VideoListener listener;

    public VideoAdapter(Context context, ArrayList<ExibitModel> dataVideos, VideoListener listener) {
        this.context = context;
        this.dataVideos = dataVideos;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        ExibitModel video1 = dataVideos.get(position);
        holder.image.setImageResource(video1.getImage());
        holder.title.setText(video1.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataVideos.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_video_videoimg_id);
            title = (TextView) itemView.findViewById(R.id.item_video_title_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.openYoutube(v);
                }
            });
        }
    }
}
