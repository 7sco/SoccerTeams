package com.example.franciscoandrade.soccerteams.data.model;

public class Player {

    private String name;
    private int playerImage;
    private int playerImageHead;
    private int games;
    private int goals;
    private int assist;
    private int shots;

    public Player(String name, int playerImage, int playerImageHead, int games, int goals, int assist, int shots) {
        this.name = name;
        this.playerImage = playerImage;
        this.playerImageHead = playerImageHead;
        this.games = games;
        this.goals = goals;
        this.assist = assist;
        this.shots = shots;
    }


    public String getName() {
        return name;
    }

    public int getPlayerImage() {
        return playerImage;
    }

    public int getPlayerImageHead() {
        return playerImageHead;
    }

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssist() {
        return assist;
    }

    public int getShots() {
        return shots;
    }
}
