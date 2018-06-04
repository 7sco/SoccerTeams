package com.example.franciscoandrade.soccerteams.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleTeam {


    @SerializedName("schedule")
    private List<Schedule> schedule;
    @SerializedName("team")
    private Team team;
    @SerializedName("schema")
    private String schema;
    @SerializedName("generated_at")
    private String generatedAt;

    public List<Schedule> getSchedule() {
        return schedule;
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

    public static class Schedule {
        @SerializedName("competitors")
        private List<Competitors> competitors;
        @SerializedName("tournament")
        private Tournament tournament;
        @SerializedName("season")
        private Season season;
        @SerializedName("tournament_round")
        private TournamentRound tournamentRound;
        @SerializedName("status")
        private String status;
        @SerializedName("start_time_tbd")
        private boolean startTimeTbd;
        @SerializedName("scheduled")
        private String scheduled;
        @SerializedName("id")
        private String id;

        public List<Competitors> getCompetitors() {
            return competitors;
        }

        public Tournament getTournament() {
            return tournament;
        }

        public Season getSeason() {
            return season;
        }

        public TournamentRound getTournamentRound() {
            return tournamentRound;
        }

        public String getStatus() {
            return status;
        }

        public boolean getStartTimeTbd() {
            return startTimeTbd;
        }

        public String getScheduled() {
            return scheduled;
        }

        public String getId() {
            return id;
        }
    }

    public static class Competitors {
        @SerializedName("qualifier")
        private String qualifier;
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

        public String getQualifier() {
            return qualifier;
        }

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

    public static class Season {
        @SerializedName("tournament_id")
        private String tournamentId;
        @SerializedName("year")
        private String year;
        @SerializedName("end_date")
        private String endDate;
        @SerializedName("start_date")
        private String startDate;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public String getTournamentId() {
            return tournamentId;
        }

        public String getYear() {
            return year;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }

    public static class TournamentRound {
        @SerializedName("number")
        private int number;
        @SerializedName("type")
        private String type;

        public int getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }
    }

    public static class Team {
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
}
