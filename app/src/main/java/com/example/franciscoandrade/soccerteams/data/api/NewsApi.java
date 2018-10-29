package com.example.franciscoandrade.soccerteams.data.api;

import com.example.franciscoandrade.soccerteams.data.model.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("top-headlines?sources=talksport&apiKey=3db6df998d64463e8203dc5a58793324&pageSize=20")
    Call<News> getNewsList();

}
