package com.example.franciscoandrade.soccerteams.presentation.newsRecycler;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;

import static com.example.franciscoandrade.soccerteams.R.color.bkg_news2;

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.container)
    ConstraintLayout cont;
    @BindView(R.id.news_text)
    TextView newsText;
    @BindView(R.id.newsImage)
    ImageView newsImage;

    private News.Articles articles;


    public NewsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(News.Articles articles, int position) {
        this.articles= articles;
        if (position%2 ==0 ){
            cont.setBackgroundColor(itemView.getResources().getColor(bkg_news2));
        }
        newsText.setText(articles.getTitle());
        Picasso.get().load(articles.getUrltoimage()).into(newsImage);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(articles.getUrl()));
        itemView.getContext().startActivity(i);
    }
}
