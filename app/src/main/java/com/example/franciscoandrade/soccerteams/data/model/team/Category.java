package com.example.franciscoandrade.soccerteams.data.model.team;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
