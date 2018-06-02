package com.example.franciscoandrade.soccerteams.data.api;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientService {
    private Retrofit retrofit;
    public ClientService(@NonNull String domain) {
        retrofit = new Retrofit.Builder()
                .baseUrl(domain)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public NewsApi getNewsApi() {
        return retrofit.create(NewsApi.class);
    }

    @NonNull
    public TeamApi getTeamApi() {
        return retrofit.create(TeamApi.class);
    }
}