package com.example.franciscoandrade.soccerteams.data.model.team;

import com.example.franciscoandrade.soccerteams.data.model.Player;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerInfo {

    @SerializedName("statistics")
    private Statistics statistics;
    @SerializedName("roles")
    private List<Roles> roles;
    @SerializedName("teams")
    private List<Teams> teams;
    @SerializedName("playerInfo")
    private Player player;
    @SerializedName("schema")
    private String schema;
    @SerializedName("generated_at")
    private String generatedAt;

    public Statistics getStatistics() {
        return statistics;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public Player getPlayer() {
        return player;
    }

    public String getSchema() {
        return schema;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public static class Statistics {
        @SerializedName("totals")
        private Totals totals;
        @SerializedName("seasons")
        private List<Seasons> seasons;

        public Totals getTotals() {
            return totals;
        }

        public List<Seasons> getSeasons() {
            return seasons;
        }
    }

    public static class Totals {
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

    public static class Seasons {
        @SerializedName("season_coverage_info")
        private SeasonCoverageInfo seasonCoverageInfo;
        @SerializedName("tournament")
        private Tournament tournament;
        @SerializedName("team")
        private Team team;
        @SerializedName("statistics")
        private Statistics statistics;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public SeasonCoverageInfo getSeasonCoverageInfo() {
            return seasonCoverageInfo;
        }

        public Tournament getTournament() {
            return tournament;
        }

        public Team getTeam() {
            return team;
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

    public static class SeasonCoverageInfo {
        @SerializedName("min_coverage_level")
        private String minCoverageLevel;
        @SerializedName("max_covered")
        private int maxCovered;
        @SerializedName("max_coverage_level")
        private String maxCoverageLevel;
        @SerializedName("played")
        private int played;
        @SerializedName("scheduled")
        private int scheduled;
        @SerializedName("season_id")
        private String seasonId;

        public String getMinCoverageLevel() {
            return minCoverageLevel;
        }

        public int getMaxCovered() {
            return maxCovered;
        }

        public String getMaxCoverageLevel() {
            return maxCoverageLevel;
        }

        public int getPlayed() {
            return played;
        }

        public int getScheduled() {
            return scheduled;
        }

        public String getSeasonId() {
            return seasonId;
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



    public static class Roles {
        @SerializedName("jersey_number")
        private int jerseyNumber;
        @SerializedName("end_date")
        private String endDate;
        @SerializedName("start_date")
        private String startDate;
        @SerializedName("team")
        private Team team;
        @SerializedName("active")
        private String active;
        @SerializedName("type")
        private String type;

        public int getJerseyNumber() {
            return jerseyNumber;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public Team getTeam() {
            return team;
        }

        public String getActive() {
            return active;
        }

        public String getType() {
            return type;
        }
    }

    public static class Teams {
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
