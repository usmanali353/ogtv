package com.example.helloworldsolution.ogtv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HelloWorldSolution on 4/16/2018.
 */

public interface apiendpoints {
 @GET("youtube/v3/search")
    Call<Video> get_channel_video(@Query("part") String part,@Query("order")String order,@Query("channelId")String channel_id,@Query("maxResults") int maxresults,@Query("key")String key);
}
