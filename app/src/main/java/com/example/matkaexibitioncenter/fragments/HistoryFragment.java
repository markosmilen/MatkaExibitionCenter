package com.example.matkaexibitioncenter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.adapters.HistoryAdapter;
import com.example.matkaexibitioncenter.interfaces.HistoryImgListener;
import com.example.matkaexibitioncenter.models.HistoryModel;
import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;

import java.util.ArrayList;

public class HistoryFragment extends Fragment implements HistoryImgListener{
    public static final String TAG = HistoryFragment.class.getSimpleName();

    RecyclerView recyclerView2;
    HistoryAdapter adapterHorizontal;
    ArrayList<HistoryModel> list = new ArrayList<>();


    public static HistoryFragment newInstance(){
        HistoryFragment historyFragment = new HistoryFragment();
        return historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerveiw_history_id);
        getHistoryPic();
        adapterHorizontal = new HistoryAdapter(list, getActivity(), this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setAdapter(adapterHorizontal);

        return view;
    }

    private void getHistoryPic(){
        HistoryModel model1 = new HistoryModel();
        model1.setImage(R.drawable.histry_one);
        list.add(model1);

        HistoryModel model2 = new HistoryModel();
        model2.setImage(R.drawable.history_two);
        list.add(model2);

        HistoryModel model3 = new HistoryModel();
        model3.setImage(R.drawable.history__three);
        list.add(model3);

        HistoryModel model4 = new HistoryModel();
        model4.setImage(R.drawable.history_four);
        list.add(model4);
    }

    @Override
    public void onHistoryImgClicked(HistoryModel historyModel, int position) {
        new StfalconImageViewer.Builder<>(getActivity(), list, new ImageLoader<HistoryModel>() {
            @Override
            public void loadImage(ImageView imageView, HistoryModel drawableRes) {
                imageView.setImageResource(drawableRes.getImage());
                imageView.setBackgroundColor(getResources().getColor(R.color.text_color_black));
            }
        }).withStartPosition(position).show();
    }
}
