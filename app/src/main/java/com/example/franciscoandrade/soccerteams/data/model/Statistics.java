package com.example.franciscoandrade.soccerteams.data.model;

import com.google.gson.annotations.SerializedName;

public class Statistics {

    @SerializedName("last_event_time")
    private String lastEventTime;
    @SerializedName("red_cards")
    private int redCards;
    @SerializedName("yellow_red_cards")
    private int yellowRedCards;
    @SerializedName("yellow_cards")
    private int yellowCards;
    @SerializedName("own_goals")
    private int ownGoals;
    @SerializedName("assists")
    private int assists;
    @SerializedName("goals_scored")
    private int goalsScored;
    @SerializedName("substituted_out")
    private int substitutedOut;
    @SerializedName("substituted_in")
    private int substitutedIn;
    @SerializedName("matches_played")
    private int matchesPlayed;

    public String getLastEventTime() {
        return lastEventTime;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getYellowRedCards() {
        return yellowRedCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getSubstitutedOut() {
        return substitutedOut;
    }

    public int getSubstitutedIn() {
        return substitutedIn;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }
}
