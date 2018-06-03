package com.example.franciscoandrade.soccerteams.data.api;

import com.example.franciscoandrade.soccerteams.data.model.News;
import com.example.franciscoandrade.soccerteams.data.model.ScheduleTeam;
import com.example.franciscoandrade.soccerteams.data.model.standings.StandingModel;
import com.example.franciscoandrade.soccerteams.data.model.team.PlayerInfo;
import com.example.franciscoandrade.soccerteams.data.model.team.TeamProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeamApi {
    @GET("/soccer-xt3/eu/en/teams/sr:competitor:2829/profile.json?api_key=kz93euznkrqasajzgutcxmkm")
    Call<TeamProfile> getTeamList();

    @GET("/soccer-xt3/eu/en/players/{id}/profile.json?api_key=kz93euznkrqasajzgutcxmkm")
    Call<PlayerInfo> getPlayerInfo(@Path("id") String id);


    @GET("/soccer-xt3/eu/en/teams/sr:competitor:2829/schedule.json?api_key=kz93euznkrqasajzgutcxmkm")
    Call<ScheduleTeam> getSchedule();

    @GET("/soccer-xt3/eu/en/tournaments/sr:tournament:8/standings.json?api_key=kz93euznkrqasajzgutcxmkm")
    Call<StandingModel> getStandings();
}