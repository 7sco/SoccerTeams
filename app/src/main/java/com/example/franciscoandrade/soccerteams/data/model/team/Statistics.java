package com.example.franciscoandrade.soccerteams.data.model.team;

import com.google.gson.annotations.SerializedName;

public class Statistics {
    @SerializedName("group_position")
    private int groupPosition;
    @SerializedName("goals_conceded")
    private int goalsConceded;
    @SerializedName("goals_scored")
    private int goalsScored;
    @SerializedName("matches_lost")
    private int matchesLost;
    @SerializedName("matches_drawn")
    private int matchesDrawn;
    @SerializedName("matches_won")
    private int matchesWon;
    @SerializedName("matches_played")
    private int matchesPlayed;

    public int getGroupPosition() {
        return groupPosition;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}
