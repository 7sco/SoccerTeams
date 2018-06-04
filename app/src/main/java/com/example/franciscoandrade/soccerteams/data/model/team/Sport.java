package com.example.franciscoandrade.soccerteams.data.model.team;

import com.google.gson.annotations.SerializedName;

public class Sport {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
