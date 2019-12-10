package com.example.matkaexibitioncenter.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.adapters.VideoAdapter;
import com.example.matkaexibitioncenter.interfaces.VideoListener;
import com.example.matkaexibitioncenter.models.ExibitModel;

import java.util.ArrayList;

public class VideoFragment extends Fragment implements VideoListener {
    public static final String TAG = VideoFragment.class.getSimpleName();
    ImageView coverImage;
    RecyclerView recyclerView;
    VideoAdapter adapter;
    ArrayList<ExibitModel> videos = new ArrayList<>();

    public static VideoFragment newInstance(){
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viceo, container, false);
        coverImage = (ImageView) view.findViewById(R.id.imgcover_videofragment_id);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_videofragment_id);

        getVideos();
        adapter = new VideoAdapter(getContext(), videos, this);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoId = "Y0roxYTwLwQ";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
                intent.putExtra("VIDEO_ID", videoId);
                intent.putExtra("force_fullscreen",true);
                startActivity(intent);
            }
        });

        return view;




    }

    public  void getVideos(){
        ExibitModel video1 = new ExibitModel();
        video1.setImage(R.drawable.video_img_1);
        video1.setTitle("Денот на Тесла");
        videos.add(video1);

        ExibitModel video2 = new ExibitModel();
        video2.setImage(R.drawable.video_img_2);
        video2.setTitle("Цртежи – Денот на Тесла");
        videos.add(video2);

        ExibitModel video3 = new ExibitModel();
        video3.setImage(R.drawable.video_img_3);
        video3.setTitle("Историја на електрификација во Македонија");
        videos.add(video3);

        ExibitModel video4 = new ExibitModel();
        video4.setImage(R.drawable.video_img_4);
        video4.setTitle("Енергетска ефикасност");
        videos.add(video4);

        ExibitModel video5 = new ExibitModel();
        video5.setImage(R.drawable.video_img_5);
        video5.setTitle("Патот на струјата");
        videos.add(video5);

        ExibitModel video6 = new ExibitModel();
        video6.setImage(R.drawable.video_img_6);
        video6.setTitle("Како се пренесува струјата?");
        videos.add(video6);

        ExibitModel video7 = new ExibitModel();
        video7.setImage(R.drawable.video_img_7);
        video7.setTitle("Обновливи извори на енергија");
        videos.add(video7);

        ExibitModel video8 = new ExibitModel();
        video8.setImage(R.drawable.video_img_8);
        video8.setTitle("Што е струја?");
        videos.add(video8);




    }
    public void openYoutube(View view, int position) {
       String videoId = null;
       switch (position){
            case 0:
                videoId = "ui2-ca-Cr7o";
                break;
            case 1:
                videoId = "g28xG1R15Lo";
                break;
            case 2:
                videoId = "ci93H59m2IY";
                break;
            case 3:
                videoId = "u8Yr9vqyU_8";
                break;
            case 4:
                videoId = "mXEulg0a1Yk";
                break;
            case 5:
                videoId = "Y0roxYTwLwQ";
                break;
            case 6:
                videoId = "qwkQVShCklw";
                break;
            case 7:
                videoId = "ohWQvr7y93k";
                break;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
        intent.putExtra("VIDEO_ID", videoId);
        intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }


}
