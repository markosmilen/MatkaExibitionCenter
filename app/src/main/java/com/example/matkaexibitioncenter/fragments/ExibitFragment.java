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

import com.example.matkaexibitioncenter.ExibitsActivity;
import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.adapters.ExibitsAdapter;
import com.example.matkaexibitioncenter.interfaces.ExibitClickListener;
import com.example.matkaexibitioncenter.models.ExibitJsonModel;
import com.example.matkaexibitioncenter.models.ExibitJsonModeltwo;
import com.example.matkaexibitioncenter.models.ExibitModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExibitFragment extends Fragment implements ExibitClickListener {

    public static final String TAG = ExibitFragment.class.getSimpleName();

    RecyclerView recyclerView;
    ExibitsAdapter adapter;
    ArrayList<ExibitJsonModeltwo> listOfExponates  = new ArrayList<>();
    Gson gson;

    public static ExibitFragment newInstance(){
        ExibitFragment exibitFragment = new ExibitFragment();
        return exibitFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibit, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.exibit_recyclerview_horizontal_id);
        gson = new Gson();
        String myjson = loadJSONFromAsset();
        ExibitJsonModel exibitJsonModel = gson.fromJson(myjson, ExibitJsonModel.class);
        listOfExponates = exibitJsonModel.getEksponati();

        adapter = new ExibitsAdapter(getActivity(), listOfExponates, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onExibitClicked(ExibitJsonModeltwo selectedExibit) {
        ExibitDetailsFragment exibitDetailsFragment = new ExibitDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXIBIT", selectedExibit);
        exibitDetailsFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_id, exibitDetailsFragment, ExibitDetailsFragment.TAG).addToBackStack(null).commit();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("myJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
