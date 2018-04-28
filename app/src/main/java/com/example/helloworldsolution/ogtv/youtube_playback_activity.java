package com.example.helloworldsolution.ogtv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtube_playback_activity extends YouTubeBaseActivity {
YouTubePlayerView ypv;
    TextView video_title,video_description,video_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_playback);
        ypv=(YouTubePlayerView)findViewById(R.id.youtube_player);
        video_title=(TextView) findViewById(R.id.video_title);
        video_description=(TextView) findViewById(R.id.video_description);
        video_date=(TextView) findViewById(R.id.video_date);
        video_title.setText(getIntent().getStringExtra("video_title"));
        video_description.setText(getIntent().getStringExtra("video_description"));
        video_date.setText(getIntent().getStringExtra("video_date"));
        ypv.initialize("AIzaSyAdDix7i7a3an-gyXiquTV_14cIsr8-DZg", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(getIntent().getStringExtra("video_id"));
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
