package com.example.matkaexibitioncenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoview;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void learnMore(View view) {
        Intent intent = new Intent(this, ExibitsActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        continueButton = findViewById(R.id.continueButtonID);

        videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }
}
