package com.example.matkaexibitioncenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.matkaexibitioncenter.fragments.ContactFragment;
import com.example.matkaexibitioncenter.fragments.ExibitDetailsFragment;
import com.example.matkaexibitioncenter.fragments.ExibitFragment;
import com.example.matkaexibitioncenter.fragments.HistoryFragment;
import com.example.matkaexibitioncenter.fragments.VideoFragment;
import com.example.matkaexibitioncenter.interfaces.ExibitClickListener;
import com.example.matkaexibitioncenter.models.ExibitModel;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExibitsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibits);
        bottomNavigationItemView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(this);
        bottomNavigationItemView.setSelectedItemId(R.id.bn_exibits_id);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.bn_exibits_id:
                ft.replace(R.id.frame_layout_id, ExibitFragment.newInstance(), ExibitFragment.TAG);
                ft.addToBackStack(null);
                ft.commit();
                return true;
            case R.id.bn_videos_id:
                ft.replace(R.id.frame_layout_id, VideoFragment.newInstance(), VideoFragment.TAG);
                ft.addToBackStack(null);
                ft.commit();
                return true;
            case R.id.bn_history_id:
                ft.replace(R.id.frame_layout_id, HistoryFragment.newInstance(), HistoryFragment.TAG);
                ft.addToBackStack(null);
                ft.commit();
                return true;
            case R.id.bn_contact_id:
                ft.replace(R.id.frame_layout_id, ContactFragment.newInstance(), ContactFragment.TAG);
                ft.addToBackStack(null);
                ft.commit();
                return true;
        }
        return false;
    }

}
