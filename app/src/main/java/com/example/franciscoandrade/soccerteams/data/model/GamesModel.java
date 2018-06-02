package com.example.franciscoandrade.soccerteams.data.model;

public class GamesModel {


    private int homeTeamShield;
    private int awayTeamShield;
    private String homeTeamName;
    private String awayTeamName;
    private String homeTeamScore;
    private String awayTeamScore;
    private String manOfMatchName;
    private int manOfMatchImage;
    private String highlightsUrl;


    public GamesModel(int homeTeamShield, int awayTeamShield, String homeTeamName, String awayTeamName, String homeTeamScore, String awayTeamScore, String manOfMatchName, int manOfMatchImage, String highlightsUrl) {
        this.homeTeamShield = homeTeamShield;
        this.awayTeamShield = awayTeamShield;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.manOfMatchName = manOfMatchName;
        this.manOfMatchImage = manOfMatchImage;
        this.highlightsUrl = highlightsUrl;
    }


    public int getHomeTeamShield() {
        return homeTeamShield;
    }

    public int getAwayTeamShield() {
        return awayTeamShield;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getManOfMatchName() {
        return manOfMatchName;
    }

    public int getManOfMatchImage() {
        return manOfMatchImage;
    }

    public String getHighlightsUrl() {
        return highlightsUrl;
    }
}
