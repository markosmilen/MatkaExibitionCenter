package com.example.matkaexibitioncenter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matkaexibitioncenter.R;
import com.example.matkaexibitioncenter.models.ExibitJsonModeltwo;
import com.example.matkaexibitioncenter.models.ExibitModel;

import org.w3c.dom.Text;

public class ExibitDetailsFragment extends Fragment {
    public static final String TAG = ExibitDetailsFragment.class.getCanonicalName();

    TextView exibit_title;
    TextView exibit_information;
    ImageView exibit_cover;


    public static ExibitDetailsFragment newInstance (){
        ExibitDetailsFragment exibitDetailsFragment = new ExibitDetailsFragment();
        return exibitDetailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exibit_details, container, false);
        exibit_title = (TextView) view.findViewById(R.id.exibit_title_id);
        exibit_information = (TextView) view.findViewById(R.id.exibitdetail_text_id);
        exibit_cover = (ImageView) view.findViewById(R.id.exibitdetails_cover_view_id);

        Bundle bundle = getArguments();
        ExibitJsonModeltwo exibitModel = (ExibitJsonModeltwo) bundle.getParcelable("EXIBIT");
        exibit_title.setText(exibitModel.getTitle());
        exibit_information.setText(exibitModel.getContent());

        String mDrawableName = exibitModel.getImages().get(0);
        int resID = getActivity().getResources().getIdentifier(mDrawableName , "drawable", getActivity().getPackageName());
        exibit_cover.setImageResource(resID);


        return view;
    }
}
