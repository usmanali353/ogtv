package com.example.helloworldsolution.ogtv;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HelloWorldSolution on 4/17/2018.
 */

public class videolist_adapter extends RecyclerView.Adapter<viewholder> {
    Context c;
    public videolist_adapter(ArrayList<Item> videolist, Context context) {
        this.videolist = videolist;
        this.c=context;
    }

    ArrayList<Item> videolist;

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v=  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_list_layout,viewGroup,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
         final Item video=videolist.get(i);
        viewholder.video_description.setText(video.getSnippet().getPublishedAt());
        viewholder.video_title.setText(video.getSnippet().getTitle());
        Picasso.get().load(video.getSnippet().getThumbnails().getHigh().getUrl()).into(viewholder.video_thumbnail);
        viewholder.videos_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(c,youtube_playback_activity.class);
                i.putExtra("video_id",video.getId().getVideoId());
                i.putExtra("video_title",video.getSnippet().getTitle());
                i.putExtra("video_description",video.getSnippet().getDescription());
                i.putExtra("video_date",video.getSnippet().getPublishedAt());
                c.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videolist.size();
    }
}
class viewholder extends RecyclerView.ViewHolder {
    ImageView video_thumbnail;
    TextView video_title,video_description;
    CardView videos_card;
    public viewholder(View itemView) {
        super(itemView);
        video_title=(TextView) itemView.findViewById(R.id.video_title);
        video_description=(TextView) itemView.findViewById(R.id.video_description);
        video_thumbnail=(ImageView) itemView.findViewById(R.id.video_thumbnail);
        videos_card=(CardView) itemView.findViewById(R.id.videos_card);
    }
}