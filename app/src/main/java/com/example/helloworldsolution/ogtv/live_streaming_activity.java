package com.example.helloworldsolution.ogtv;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class live_streaming_activity extends AppCompatActivity {
    VideoView video;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024,1024);
        setContentView(R.layout.activity_live_streaming);
        video=(VideoView) findViewById(R.id.surface);
        setup_media_player();
    }
    void setup_media_player(){
        progress=new ProgressDialog(live_streaming_activity.this);
        progress.setTitle("Live Tv");
        progress.setMessage("Buffering");
        progress.setIndeterminate(true);
        progress.setCancelable(false);
        progress.show();
        try{
            MediaController controller=new MediaController(live_streaming_activity.this);
            controller.setAnchorView(video);
            video.setMediaController(controller);
            video.setVideoURI(Uri.parse("http://cdn28.live247stream.com/overseastv/global/playlist.m3u8"));
        }catch(Exception e){
            e.printStackTrace();
        }
        video.requestFocus();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progress.dismiss();
                video.start();
            }
        });
        video.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return true;
            }
        });
    }
}
