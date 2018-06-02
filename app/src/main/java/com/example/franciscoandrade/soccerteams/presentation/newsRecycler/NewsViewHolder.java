package com.example.franciscoandrade.soccerteams.presentation.newsRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.news_tittle)
    TextView newsTittle;
    @BindView(R.id.news_text)
    TextView newsText;


    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(News.Articles articles) {

        newsTittle.setText(articles.getTitle());
        newsText.setText(articles.getDescription());

    }
}
