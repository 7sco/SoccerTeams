package com.example.franciscoandrade.soccerteams;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.news_tv)
    TextView newsTv;
    @BindView(R.id.players_tv)
    TextView playersTv;
    @BindView(R.id.team_tv)
    TextView teamTv;
    @BindView(R.id.tour_tv)
    TextView tourTv;
    @BindView(R.id.tickets_tv)
    TextView ticketsTv;
    @BindView(R.id.shop_tv)
    TextView shopTv;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<GamesModel> mContents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mContents= new ArrayList<>();

        for (int i = 0; i <5; i++) {
            mContents.add(new GamesModel(R.drawable.realmadridshield, R.drawable.realmadridshield, "Real Madrid F.C", "Liverpool F.C. ",i+"",

                    (5-i)+"", "Gareth Bale", R.drawable.bale_head, "URL Here"));
        }

        viewPagerAdapter= new ViewPagerAdapter( mContents, this);
        viewPager.setPageTransformer(true, new CardStackTransformer());
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(viewPagerAdapter);









    }

    @OnClick({R.id.news_tv, R.id.players_tv, R.id.team_tv, R.id.tour_tv, R.id.tickets_tv, R.id.shop_tv, R.id.textView15})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.news_tv:
                Toast.makeText(this, "NEWS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.players_tv:
                Toast.makeText(this, "PLAYERS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.team_tv:
                Toast.makeText(this, "TEAM", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tour_tv:
                Toast.makeText(this, "TOUR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tickets_tv:
                Toast.makeText(this, "TICKETS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shop_tv:
                Toast.makeText(this, "SHOP", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
