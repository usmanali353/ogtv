package com.example.helloworldsolution.ogtv;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    NavigationView nv;
  DrawerLayout drawerlayout;
    ActionBarDrawerToggle drawerToggle;
    RecyclerView videolist;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nv=(NavigationView) findViewById(R.id.nav_view);
        drawerlayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        pb=(ProgressBar) findViewById(R.id.pb);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerlayout, toolbar, R.string.drawer_open, R.string.drawer_close);
                drawerlayout.setDrawerListener(drawerToggle);
         nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 if(menuItem.getItemId()==R.id.action_settings){
                     Intent i=new Intent(MainActivity.this,live_streaming_activity.class);
                     startActivity(i);
                 }else if(menuItem.getItemId()==R.id.go_to_our_website){
                     Intent i=new Intent(MainActivity.this,go_to_our_website.class);
                     startActivity(i);
                 }else if(menuItem.getItemId()==R.id.share_this_app){
                     String message = "http://creativeexperts.com.pk/oslotv";
                     Intent share = new Intent(Intent.ACTION_SEND);
                     share.setType("text/plain");
                     share.putExtra(Intent.EXTRA_TEXT, message);

                     startActivity(Intent.createChooser(share, "Where you want to share it"));
                 }
                 return true;
             }
         });
        videolist=(RecyclerView) findViewById(R.id.videolist);
        videolist.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        videolist.addItemDecoration(new VerticalSpace(20));
        apiendpoints service=apiclient.getClient().create(apiendpoints.class);
               Call<Video> call=service.get_channel_video("snippet","date","UCMC4M6-I50ZZ8K5jpHMDUOA",20,"AIzaSyAdDix7i7a3an-gyXiquTV_14cIsr8-DZg");
             pb.setVisibility(View.VISIBLE);
         call.enqueue(new Callback<Video>() {
             @Override
             public void onResponse(Call<Video> call, Response<Video> response) {
                 pb.setVisibility(View.GONE);
                 videolist.setAdapter(new videolist_adapter(response.body().getItems(),MainActivity.this));

             }

             @Override
             public void onFailure(Call<Video> call, Throwable throwable) {
                 pb.setVisibility(View.GONE);
                 Toast.makeText(MainActivity.this,throwable.toString(),Toast.LENGTH_LONG).show();
             }
         });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }


}
