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
import com.example.franciscoandrade.soccerteams.data.model.recentGames.RecentGames;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerAdapter extends PagerAdapter{
    @BindView(R.id.home_team)ImageView homeTeamImage;
    @BindView(R.id.away_team)ImageView awayTeamImage;
    @BindView(R.id.home_score)TextView homeScore;
    @BindView(R.id.away_score)TextView awayScore;
    @BindView(R.id.competition)TextView competition;
    @BindView(R.id.homeName)TextView homeName;
    @BindView(R.id.awayName)TextView awayName;




    private List<RecentGames.Results> contents;
    private Context context;

    public ViewPagerAdapter(Context context, List<RecentGames.Results> listResults) {
        this.context = context;
        contents=listResults;
    }

    public void addData(List<RecentGames.Results> data){

        contents.addAll(data);
        notifyDataSetChanged();
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
        ButterKnife.bind(this,view);

//        homeTeamImage = view.findViewById(R.id.home_team);
//        homeScore = view.findViewById(R.id.home_score);
//        awayScore = view.findViewById(R.id.away_score);
//        competition = view.findViewById(R.id.competition);



        homeTeamImage.setImageResource(R.drawable.realmadridshield);
        homeScore.setText(String.valueOf(contents.get(position).getSportEventStatus().getHomeScore()));
        awayScore.setText(String.valueOf(contents.get(position).getSportEventStatus().getAwayScore()));
        competition.setText(contents.get(position).getSportEvent().getTournament().getName());
        homeName.setText(contents.get(position).getSportEvent().getCompetitors().get(0).getName());
        awayName.setText(contents.get(position).getSportEvent().getCompetitors().get(1).getName());


        setShieldHomeTeam(position);
        setShieldAwayTeam(position);


        return view;
    }

    private void setShieldHomeTeam(int position) {
        switch (contents.get(position).getSportEvent().getCompetitors().get(0).getName()){
            case "Liverpool FC":
                homeTeamImage.setImageResource(R.drawable.liverpool_escudo);
                break;
            case "Villarreal CF":
                homeTeamImage.setImageResource(R.drawable.villarreal_escudo);
                break;
            case "Celta de Vigo":
                homeTeamImage.setImageResource(R.drawable.celta_escudo);
                break;
            case "Sevilla FC":
                homeTeamImage.setImageResource(R.drawable.sevilla_escudo);
                break;
            case "FC Barcelona":
                homeTeamImage.setImageResource(R.drawable.barcelona_escudo);
                break;
            case "Bayern Munich":
                homeTeamImage.setImageResource(R.drawable.bayern_escudo);
                break;
            case "CD Leganes":
                homeTeamImage.setImageResource(R.drawable.leganes_escudo);
                break;
            case "Athletic Bilbao":
                homeTeamImage.setImageResource(R.drawable.athletic_escudo);
                break;
            case "Malaga CF":
                homeTeamImage.setImageResource(R.drawable.malaga_escudo);
                break;

                default:
                    homeTeamImage.setImageResource(R.drawable.realmadridshield);
        }
    }
    private void setShieldAwayTeam(int position) {
        switch (contents.get(position).getSportEvent().getCompetitors().get(1).getName()){
            case "Liverpool FC":
                awayTeamImage.setImageResource(R.drawable.liverpool_escudo);
                break;
            case "Villarreal CF":
                awayTeamImage.setImageResource(R.drawable.villarreal_escudo);
                break;
            case "Celta de Vigo":
                awayTeamImage.setImageResource(R.drawable.celta_escudo);
                break;
            case "Sevilla FC":
                awayTeamImage.setImageResource(R.drawable.sevilla_escudo);
                break;
            case "FC Barcelona":
                awayTeamImage.setImageResource(R.drawable.barcelona_escudo);
                break;
            case "Bayern Munich":
                awayTeamImage.setImageResource(R.drawable.bayern_escudo);
                break;
            case "CD Leganes":
                awayTeamImage.setImageResource(R.drawable.leganes_escudo);
                break;
            case "Athletic Bilbao":
                awayTeamImage.setImageResource(R.drawable.athletic_escudo);
                break;
            case "Malaga CF":
                awayTeamImage.setImageResource(R.drawable.malaga_escudo);
                break;

            default:
                awayTeamImage.setImageResource(R.drawable.realmadridshield);
        }
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
