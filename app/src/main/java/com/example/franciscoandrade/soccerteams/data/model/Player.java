package com.example.franciscoandrade.soccerteams.data.model;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("gender")
    private String gender;
    @SerializedName("preferred_foot")
    private String preferredFoot;
    @SerializedName("weight")
    private int weight;
    @SerializedName("height")
    private int height;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("nationality")
    private String nationality;
    @SerializedName("date_of_birth")
    private String dateOfBirth;
    @SerializedName("type")
    private String type;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;

    public String getGender() {
        return gender;
    }

    public String getPreferredFoot() {
        return preferredFoot;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


}
