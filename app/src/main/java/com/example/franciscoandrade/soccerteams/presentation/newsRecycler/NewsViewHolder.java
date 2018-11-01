package com.example.franciscoandrade.soccerteams.presentation.newsRecycler;

import android.support.constraint.ConstraintLayout;
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

import static com.example.franciscoandrade.soccerteams.R.color.bkg_news2;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.container)
    ConstraintLayout cont;
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

    public void bind(News.Articles articles, int position) {
        if (position%2 ==0 ){
            cont.setBackgroundColor(itemView.getResources().getColor(bkg_news2));
        }

        newsTittle.setText(articles.getTitle());
        Log.d("NEWS", "bind: "+articles.getDescription());
        newsText.setText(articles.getDescription());
        Picasso.get().load(articles.getUrltoimage()).into(newsImage);

    }
}
