package com.example.franciscoandrade.soccerteams.data.model.standings;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StandingModel {

    @SerializedName("standings")
    private List<Standings> standings;
    @SerializedName("season")
    private Season season;
    @SerializedName("tournament")
    private Tournament tournament;
    @SerializedName("schema")
    private String schema;
    @SerializedName("generated_at")
    private String generatedAt;

    public List<Standings> getStandings() {
        return standings;
    }

    public Season getSeason() {
        return season;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public String getSchema() {
        return schema;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public static class Standings {
        @SerializedName("groups")
        private List<Groups> groups;
        @SerializedName("type")
        private String type;
        @SerializedName("tie_break_rule")
        private String tieBreakRule;

        public List<Groups> getGroups() {
            return groups;
        }

        public String getType() {
            return type;
        }

        public String getTieBreakRule() {
            return tieBreakRule;
        }
    }

    public static class Groups {
        @SerializedName("team_standings")
        private List<TeamStandings> teamStandings;

        public List<TeamStandings> getTeamStandings() {
            return teamStandings;
        }
    }

    public static class TeamStandings {
        @SerializedName("points")
        private int points;
        @SerializedName("goal_diff")
        private int goalDiff;
        @SerializedName("goals_against")
        private int goalsAgainst;
        @SerializedName("goals_for")
        private int goalsFor;
        @SerializedName("loss")
        private int loss;
        @SerializedName("draw")
        private int draw;
        @SerializedName("win")
        private int win;
        @SerializedName("played")
        private int played;
        @SerializedName("current_outcome")
        private String currentOutcome;
        @SerializedName("rank")
        private int rank;
        @SerializedName("team")
        private Team team;

        public int getPoints() {
            return points;
        }

        public int getGoalDiff() {
            return goalDiff;
        }

        public int getGoalsAgainst() {
            return goalsAgainst;
        }

        public int getGoalsFor() {
            return goalsFor;
        }

        public int getLoss() {
            return loss;
        }

        public int getDraw() {
            return draw;
        }

        public int getWin() {
            return win;
        }

        public int getPlayed() {
            return played;
        }

        public String getCurrentOutcome() {
            return currentOutcome;
        }

        public int getRank() {
            return rank;
        }

        public Team getTeam() {
            return team;
        }
    }

    public static class Team {
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

    public static class Tournament {
        @SerializedName("current_season")
        private CurrentSeason currentSeason;
        @SerializedName("category")
        private Category category;
        @SerializedName("sport")
        private Sport sport;
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private String id;

        public CurrentSeason getCurrentSeason() {
            return currentSeason;
        }

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

    public static class CurrentSeason {
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
}
