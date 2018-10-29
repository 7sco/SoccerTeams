package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.api.ClientService;
import com.example.franciscoandrade.soccerteams.data.api.NewsApi;
import com.example.franciscoandrade.soccerteams.data.api.TeamApi;
import com.example.franciscoandrade.soccerteams.data.model.GamesModel;
import com.example.franciscoandrade.soccerteams.data.model.News;
import com.example.franciscoandrade.soccerteams.data.model.recentGames.RecentGames;
import com.example.franciscoandrade.soccerteams.presentation.featureCardStack.CardStackTransformer;
import com.example.franciscoandrade.soccerteams.presentation.featureCardStack.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.franciscoandrade.soccerteams.data.model.recentGames.RecentGames.*;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.about_tv)
    TextView aboutTv;
    @BindView(R.id.players_tv)
    TextView playersTv;
    @BindView(R.id.team_tv)
    TextView teamTv;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.news_tv)
    TextView newsTv;
    @BindView(R.id.tour_tv)
    TextView tourTv;
    @BindView(R.id.tickets_tv)
    TextView ticketsTv;
    @BindView(R.id.shop_tv)
    TextView shopTv;


    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<GamesModel> mContents;
    ClientService clientService;
    private List<Results> listResults;
    private  Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        clientService = new ClientService(getString(R.string.WW_Domain_Team));

        getGames();
        String video_path = "https://www.youtube.com/watch?v=UlFkOZFQCBQ";
        uri = Uri.parse(video_path);
        uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

    }

    @OnClick({R.id.news_tv, R.id.about_tv, R.id.players_tv, R.id.team_tv, R.id.textView15, R.id.tour_tv, R.id.tickets_tv, R.id.shop_tv})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.about_tv:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.news_tv:
                intent = new Intent(this, NewsActivity.class);
                break;
            case R.id.players_tv:
                intent = new Intent(this, PlayersActivity.class);
                break;
            case R.id.team_tv:
                intent = new Intent(this, TeamActivity.class);
                break;
            case R.id.tour_tv:
                intent = new Intent(Intent.ACTION_VIEW, uri);
                break;
            case R.id.tickets_tv:
                Toast.makeText(this, "TICKETS", Toast.LENGTH_SHORT).show();
                intent=null;
                break;
            case R.id.shop_tv:
                Toast.makeText(this, "SHOP", Toast.LENGTH_SHORT).show();
                intent=null;
                break;
        }

        if (intent!=null) {
            startActivity(intent);
            //finish();
        }



    }

    public void getGames() {

        TeamApi teamApi= clientService.getTeamApi();
        Call<RecentGames> recentCall= teamApi.getRecentGames();
        recentCall.enqueue(new Callback<RecentGames>() {
            @Override
            public void onResponse(Call<RecentGames> call, Response<RecentGames> response) {
                listResults = new ArrayList<>();
                listResults = response.body().getResults();
                viewPagerAdapter = new ViewPagerAdapter( HomeActivity.this, listResults);
                viewPager.setPageTransformer(true, new CardStackTransformer());
                viewPager.setOffscreenPageLimit(10);
                viewPager.setAdapter(viewPagerAdapter);
            }

            @Override
            public void onFailure(Call<RecentGames> call, Throwable t) {
                Log.d("==", "onFailure: ");
            }
        });



    }
}
