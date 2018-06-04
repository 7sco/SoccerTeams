package com.example.franciscoandrade.soccerteams.data.model.team;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamProfile {


    @SerializedName("statistics")
    private Statistics statistics;
    @SerializedName("players")
    private List<Players> players;
    @SerializedName("jerseys")
    private List<Jerseys> jerseys;
    @SerializedName("venue")
    private Venue venue;
    @SerializedName("team")
    private Team team;
    @SerializedName("schema")
    private String schema;
    @SerializedName("generated_at")
    private String generatedAt;

    public Statistics getStatistics() {
        return statistics;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public List<Jerseys> getJerseys() {
        return jerseys;
    }

    public Venue getVenue() {
        return venue;
    }

    public Team getTeam() {
        return team;
    }

    public String getSchema() {
        return schema;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public static class Statistics {
        @SerializedName("seasons")
        private List<Seasons> seasons;

        public List<Seasons> getSeasons() {
            return seasons;
        }
    }

    public static class Seasons {
        @SerializedName("form")
        private Form form;
        @SerializedName("tournament")
        private Tournament tournament;
        @SerializedName("statistics")
        private Statistics statistics;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public Form getForm() {
            return form;
        }

        public Tournament getTournament() {
            return tournament;
        }

        public Statistics getStatistics() {
            return statistics;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    public static class Form {
        @SerializedName("away")
        private String away;
        @SerializedName("home")
        private String home;
        @SerializedName("total")
        private String total;

        public String getAway() {
            return away;
        }

        public String getHome() {
            return home;
        }

        public String getTotal() {
            return total;
        }
    }

    public static class Tournament {
        @SerializedName("category")
        private Category category;
        @SerializedName("sport")
        private Sport sport;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public Category getCategory() {
            return category;
        }

        public Sport getSport() {
            return sport;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    public static class Category {
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

    public static class Sport {
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



    public static class Players {
        @SerializedName("gender")
        private String gender;
        @SerializedName("preferred_foot")
        private String preferredFoot;
        @SerializedName("jersey_number")
        private int jerseyNumber;
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

        public int getJerseyNumber() {
            return jerseyNumber;
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

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    public static class Jerseys {
        @SerializedName("shirt_type")
        private String shirtType;
        @SerializedName("split")
        private boolean split;
        @SerializedName("horizontal_stripes")
        private boolean horizontalStripes;
        @SerializedName("stripes")
        private boolean stripes;
        @SerializedName("squares_color")
        private String squaresColor;
        @SerializedName("squares")
        private boolean squares;
        @SerializedName("number")
        private String number;
        @SerializedName("sleeve")
        private String sleeve;
        @SerializedName("base")
        private String base;
        @SerializedName("type")
        private String type;

        public String getShirtType() {
            return shirtType;
        }

        public boolean getSplit() {
            return split;
        }

        public boolean getHorizontalStripes() {
            return horizontalStripes;
        }

        public boolean getStripes() {
            return stripes;
        }

        public String getSquaresColor() {
            return squaresColor;
        }

        public boolean getSquares() {
            return squares;
        }

        public String getNumber() {
            return number;
        }

        public String getSleeve() {
            return sleeve;
        }

        public String getBase() {
            return base;
        }

        public String getType() {
            return type;
        }
    }

    public static class Venue {
        @SerializedName("country_code")
        private String countryCode;
        @SerializedName("map_coordinates")
        private String mapCoordinates;
        @SerializedName("country_name")
        private String countryName;
        @SerializedName("city_name")
        private String cityName;
        @SerializedName("capacity")
        private int capacity;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public String getCountryCode() {
            return countryCode;
        }

        public String getMapCoordinates() {
            return mapCoordinates;
        }

        public String getCountryName() {
            return countryName;
        }

        public String getCityName() {
            return cityName;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    public static class Team {
        @SerializedName("abbreviation")
        private String abbreviation;
        @SerializedName("category")
        private Category category;
        @SerializedName("sport")
        private Sport sport;
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

        public Category getCategory() {
            return category;
        }

        public Sport getSport() {
            return sport;
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

}
