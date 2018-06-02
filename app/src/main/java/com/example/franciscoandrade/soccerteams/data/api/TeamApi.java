package com.example.franciscoandrade.soccerteams.data.api;

import com.example.franciscoandrade.soccerteams.data.model.News;
import com.example.franciscoandrade.soccerteams.data.model.team.TeamProfile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamApi {
    @GET("/soccer-xt3/eu/en/teams/sr:competitor:2829/profile.json?api_key=kz93euznkrqasajzgutcxmkm")
    Call<TeamProfile> getTeamList();

}
