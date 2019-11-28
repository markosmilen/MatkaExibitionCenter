package com.example.matkaexibitioncenter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.adapters.ExibitsAdapter;
import com.example.matkaexibitioncenter.models.ExibitModel;

import java.util.ArrayList;

public class ExibitFragment extends Fragment {

    public static final String TAG = ExibitFragment.class.getSimpleName();

    RecyclerView recyclerView;
    ExibitsAdapter adapter;
    ArrayList<ExibitModel> listOfExibits = new ArrayList<>();

    public static ExibitFragment newInstance(){
        ExibitFragment exibitFragment = new ExibitFragment();
        return exibitFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibit, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.exibit_recyclerview_horizontal_id);
        generateExibits();
        adapter = new ExibitsAdapter(getActivity(), listOfExibits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void generateExibits() {
        ExibitModel exibit1 = new ExibitModel();
        exibit1.setImage(R.drawable.exibitone);
        exibit1.setTitle("Приказ на електро дистрибутивен систем");
        listOfExibits.add(exibit1);

        ExibitModel exibit3 = new ExibitModel();
        exibit3.setImage(R.drawable.kontrolna_soba);
        exibit3.setTitle("Контролна соба");
        listOfExibits.add(exibit3);

        ExibitModel exibit4 = new ExibitModel();
        exibit4.setImage(R.drawable.dispecerska_tabla);
        exibit4.setTitle("Диспечерска табла");
        listOfExibits.add(exibit4);


        ExibitModel exibit5 = new ExibitModel();
        exibit5.setImage(R.drawable.svetilki);
        exibit5.setTitle("Светилки");
        listOfExibits.add(exibit5);

        ExibitModel exibit6 = new ExibitModel();
        exibit6.setImage(R.drawable.fotovoltaici);
        exibit6.setTitle("Фотоволтаици");
        listOfExibits.add(exibit6);

        ExibitModel exibit7 = new ExibitModel();
        exibit7.setImage(R.drawable.veternica);
        exibit7.setTitle("Ветерница");
        listOfExibits.add(exibit7);

        ExibitModel exibit8 = new ExibitModel();
        exibit8.setImage(R.drawable.vandegrav);
        exibit8.setTitle("Ван де Граф");
        listOfExibits.add(exibit8);

        ExibitModel exibit9 = new ExibitModel();
        exibit9.setImage(R.drawable.plazma_topka);
        exibit9.setTitle("Плазма топка");
        listOfExibits.add(exibit9);




    }


}
