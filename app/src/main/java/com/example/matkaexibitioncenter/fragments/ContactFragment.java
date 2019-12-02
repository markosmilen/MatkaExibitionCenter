package com.example.matkaexibitioncenter.fragments;

import android.content.Intent;
import android.net.Uri;
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


public class ContactFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = ContactFragment.class.getSimpleName();

    ImageView map, taxi, busUp, busDown, plane, train;
    TextView telNumber;

    public static ContactFragment newInstance () {
        ContactFragment contactFragment = new ContactFragment();
        return contactFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        map = (ImageView) view.findViewById(R.id.map_img_id);
        taxi = (ImageView) view.findViewById(R.id.taxi);
        train = (ImageView) view.findViewById(R.id.train);
        plane = (ImageView) view.findViewById(R.id.plane);
        busUp = (ImageView) view.findViewById(R.id.bus_up);
        busDown = (ImageView) view.findViewById(R.id.bus_down);
        telNumber = (TextView) view.findViewById(R.id.tel_num_id);
        map.setOnClickListener(this);
        taxi.setOnClickListener(this);
        train.setOnClickListener(this);
        plane.setOnClickListener(this);
        busUp.setOnClickListener(this);
        busDown.setOnClickListener(this);
        telNumber.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.map_img_id:
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=41.9525944,21.298674"));
                startActivity(intent);
                break;
            case R.id.tel_num_id:
                String phone = "+38972935105";
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(phoneIntent);
                break;
            case R.id.taxi:
                String url = "https://zk.mk/taksi-kompanii/skopje";
                Intent taxiIntent = new Intent(Intent.ACTION_VIEW);
                taxiIntent.setData(Uri.parse(url));
                startActivity(taxiIntent);
                break;
            case R.id.bus_up :
                String bus = "http://www.jsp.com.mk/PlanskiVozenRed.aspx";
                Intent busIntent = new Intent(Intent.ACTION_VIEW);
                busIntent.setData(Uri.parse(bus));
                startActivity(busIntent);
                break;
            case R.id.bus_down:
                String bus1 = "http://sas.com.mk/VozenRed.aspx";
                Intent intBusIntent = new Intent(Intent.ACTION_VIEW);
                intBusIntent.setData(Uri.parse(bus1));
                startActivity(intBusIntent);
                break;
            case R.id.plane:
                String plane = "http://skp.airports.com.mk/default.aspx?ItemID=345";
                Intent planeIntent = new Intent(Intent.ACTION_VIEW);
                planeIntent.setData(Uri.parse(plane));
                startActivity(planeIntent);
                break;
            case R.id.train:
                String train = "http://mzt.mk/vozen-red/";
                Intent trainIntent = new Intent(Intent.ACTION_VIEW);
                trainIntent.setData(Uri.parse(train));
                startActivity(trainIntent);
                break;
        }
    }
}
