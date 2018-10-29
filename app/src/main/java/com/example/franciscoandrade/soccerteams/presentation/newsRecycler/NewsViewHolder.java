package com.example.franciscoandrade.soccerteams.presentation.newsRecycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.news_tittle)
    TextView newsTittle;
    @BindView(R.id.news_text)
    TextView newsText;
    @BindView(R.id.newsImage)
    ImageView newsImage;


    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(News.Articles articles) {

        newsTittle.setText(articles.getTitle());
        Log.d("NEWS", "bind: "+articles.getDescription());
        newsText.setText(articles.getDescription());
        Picasso.get().load(articles.getUrltoimage()).into(newsImage);

    }
}
