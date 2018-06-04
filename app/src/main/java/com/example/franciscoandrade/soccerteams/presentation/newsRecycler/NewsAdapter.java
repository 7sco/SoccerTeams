package com.example.franciscoandrade.soccerteams.presentation.newsRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    List<News.Articles> data= new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_viewholder, parent, false);
        return new NewsViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News.Articles articles= data.get(position);
        holder.bind(articles);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addArticles(List<News.Articles> newsList) {
        data.clear();
        data.addAll(newsList);
        notifyDataSetChanged();
    }
}
