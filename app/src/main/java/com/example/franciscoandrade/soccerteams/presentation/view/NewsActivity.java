package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.presentation.newsRecycler.NewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.back_btn)
    ImageView backBtn;
    @BindView(R.id.recycler_news)
    RecyclerView recyclerNews;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);


        adapter= new NewsAdapter();

        recyclerNews.setAdapter(adapter);






    }

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
        Intent intent= new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();

    }
}
