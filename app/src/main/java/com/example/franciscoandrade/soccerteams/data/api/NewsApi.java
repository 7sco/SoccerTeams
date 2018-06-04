package com.example.franciscoandrade.soccerteams.data.api;

import com.example.franciscoandrade.soccerteams.data.model.News;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("top-headlines?sources=talksport&apiKey=bb9882ead46d4fb4a8c5c158a3754d85&pageSize=20")
    Call<News> getNewsList();

}
