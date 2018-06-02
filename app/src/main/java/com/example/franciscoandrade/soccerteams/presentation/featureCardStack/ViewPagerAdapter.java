package com.example.franciscoandrade.soccerteams.presentation.featureCardStack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.GamesModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerAdapter extends PagerAdapter{
    @BindView(R.id.home_team)ImageView homeTeamImage;
    @BindView(R.id.home_score)TextView homeScore;
    @BindView(R.id.away_score)TextView awayScore;
    @BindView(R.id.away_team)ImageView awayTeamImage;
    @BindView(R.id.match_player)ImageView matchPlayerImage;
    @BindView(R.id.match_player_name)TextView matchPlayerName;
    @BindView(R.id.highlights_btn)TextView highlightsButton;



    private List<GamesModel> contents;
    private Context context;

    public ViewPagerAdapter(List<GamesModel> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view== (CardView)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.games_viewholder, container, false);
        container.addView(view);
        ButterKnife.bind(container);

        homeTeamImage = view.findViewById(R.id.home_team);
        homeScore = view.findViewById(R.id.home_score);
        awayScore = view.findViewById(R.id.away_score);
        awayTeamImage = view.findViewById(R.id.away_team);
        matchPlayerImage = view.findViewById(R.id.match_player);
        matchPlayerName = view.findViewById(R.id.match_player_name);
        highlightsButton = view.findViewById(R.id.highlights_btn);

        homeTeamImage.setImageResource(contents.get(position).getHomeTeamShield());
        awayTeamImage.setImageResource(contents.get(position).getAwayTeamShield());
        homeScore.setText(contents.get(position).getHomeTeamScore());
        awayScore.setText(contents.get(position).getAwayTeamScore());
        matchPlayerName.setText(contents.get(position).getManOfMatchName());
        matchPlayerImage.setImageResource(contents.get(position).getManOfMatchImage());
        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
