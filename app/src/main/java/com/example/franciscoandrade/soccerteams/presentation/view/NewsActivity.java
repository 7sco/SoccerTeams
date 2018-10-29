package com.example.franciscoandrade.soccerteams.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.api.ClientService;
import com.example.franciscoandrade.soccerteams.data.api.NewsApi;
import com.example.franciscoandrade.soccerteams.data.model.News;
import com.example.franciscoandrade.soccerteams.presentation.newsRecycler.NewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        retrofit();
    }

    private void retrofit() {
        ClientService clientService = new ClientService(getString(R.string.WW_Domain_News));
        NewsApi newsApi= clientService.getNewsApi();
        Call<News> newsCall= newsApi.getNewsList();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.body()!=null) {
                    adapter.addArticles(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
                Log.d("===", "onFailure: FAIL"+t.getMessage());
            }
        });
    }

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
        onBackPressed();
        finish();
    }
}
