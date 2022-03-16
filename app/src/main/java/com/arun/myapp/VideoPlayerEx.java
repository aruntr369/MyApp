package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_ex);

        VideoView videoView=(VideoView) findViewById(R.id.videoView);

        MediaController mediaController=new MediaController(this);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_demo);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}