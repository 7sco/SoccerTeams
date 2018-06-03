package com.example.franciscoandrade.soccerteams.data.model;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("abbreviation")
    private String abbreviation;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("country")
    private String country;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
