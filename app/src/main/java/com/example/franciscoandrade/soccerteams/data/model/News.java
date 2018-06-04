package com.example.franciscoandrade.soccerteams.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("articles")
    private List<Articles> articles;
    @SerializedName("totalResults")
    private int totalresults;
    @SerializedName("status")
    private String status;

    public List<Articles> getArticles() {
        return articles;
    }

    public int getTotalresults() {
        return totalresults;
    }

    public String getStatus() {
        return status;
    }

    public static class Articles {
        @SerializedName("publishedAt")
        private String publishedat;
        @SerializedName("urlToImage")
        private String urltoimage;
        @SerializedName("url")
        private String url;
        @SerializedName("description")
        private String description;
        @SerializedName("title")
        private String title;
        @SerializedName("author")
        private String author;
        @SerializedName("source")
        private Source source;

        public String getPublishedat() {
            return publishedat;
        }

        public String getUrltoimage() {
            return urltoimage;
        }

        public String getUrl() {
            return url;
        }

        public String getDescription() {
            return description;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public Source getSource() {
            return source;
        }
    }

    public static class Source {
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
