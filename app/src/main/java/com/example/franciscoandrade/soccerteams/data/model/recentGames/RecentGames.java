package com.example.franciscoandrade.soccerteams.data.model.recentGames;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecentGames {


    @SerializedName("results")
    private List<Results> results;
    @SerializedName("team")
    private Team team;
    @SerializedName("schema")
    private String schema;
    @SerializedName("generated_at")
    private String generatedAt;

    public List<Results> getResults() {
        return results;
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

    public static class Results {
        @SerializedName("sport_event_status")
        private SportEventStatus sportEventStatus;
        @SerializedName("sport_event")
        private SportEvent sportEvent;

        public SportEventStatus getSportEventStatus() {
            return sportEventStatus;
        }

        public SportEvent getSportEvent() {
            return sportEvent;
        }
    }

    public static class SportEventStatus {
        @SerializedName("period_scores")
        private List<PeriodScores> periodScores;
        @SerializedName("winner_id")
        private String winnerId;
        @SerializedName("away_score")
        private int awayScore;
        @SerializedName("home_score")
        private int homeScore;
        @SerializedName("match_status")
        private String matchStatus;
        @SerializedName("status")
        private String status;

        public List<PeriodScores> getPeriodScores() {
            return periodScores;
        }

        public String getWinnerId() {
            return winnerId;
        }

        public int getAwayScore() {
            return awayScore;
        }

        public int getHomeScore() {
            return homeScore;
        }

        public String getMatchStatus() {
            return matchStatus;
        }

        public String getStatus() {
            return status;
        }
    }

    public static class PeriodScores {
        @SerializedName("number")
        private int number;
        @SerializedName("type")
        private String type;
        @SerializedName("away_score")
        private int awayScore;
        @SerializedName("home_score")
        private int homeScore;

        public int getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        public int getAwayScore() {
            return awayScore;
        }

        public int getHomeScore() {
            return homeScore;
        }
    }

    public static class SportEvent {
        @SerializedName("venue")
        private Venue venue;
        @SerializedName("competitors")
        private List<Competitors> competitors;
        @SerializedName("tournament")
        private Tournament tournament;
        @SerializedName("season")
        private Season season;
        @SerializedName("tournament_round")
        private TournamentRound tournamentRound;
        @SerializedName("start_time_tbd")
        private boolean startTimeTbd;
        @SerializedName("scheduled")
        private String scheduled;
        @SerializedName("id")
        private String id;

        public Venue getVenue() {
            return venue;
        }

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
        @SerializedName("name")
        private String name;
        @SerializedName("type")
        private String type;

        public String getName() {
            return name;
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
