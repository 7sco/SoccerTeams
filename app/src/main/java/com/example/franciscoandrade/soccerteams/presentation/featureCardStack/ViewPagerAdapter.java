package com.example.franciscoandrade.soccerteams.presentation.featureCardStack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.recentGames.RecentGames;
import com.example.franciscoandrade.soccerteams.presentation.TeamsIcon;
import com.squareup.picasso.Picasso;
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
    private TeamsIcon icons= new TeamsIcon();

    public ViewPagerAdapter(Context context, List<RecentGames.Results> listResults) {
        this.context = context;
        contents=listResults;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view==object; }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.games_viewholder, container, false);
        container.addView(view);
        ButterKnife.bind(this,view);
        homeTeamImage.setImageResource(R.drawable.realmadridshield);
        homeScore.setText(String.valueOf(contents.get(position).getSportEventStatus().getHomeScore()));
        awayScore.setText(String.valueOf(contents.get(position).getSportEventStatus().getAwayScore()));
        competition.setText(contents.get(position).getSportEvent().getTournament().getName());
        homeName.setText(contents.get(position).getSportEvent().getCompetitors().get(0).getName());
        awayName.setText(contents.get(position).getSportEvent().getCompetitors().get(1).getName());
        setShieldHomeTeam(position);
        return view;
    }

    private void setShieldHomeTeam(int position) {
        for (String shield: icons.iconMap.keySet()        ) {
            if (contents.get(position).getSportEvent().getCompetitors().get(0).getName().toLowerCase().contains(shield)){
                Picasso.get().load(icons.iconMap.get(shield)).error(R.drawable.realmadridshield).into(homeTeamImage);
                awayTeamImage.setImageResource(R.drawable.realmadridshield);
            }
            else if (contents.get(position).getSportEvent().getCompetitors().get(1).getName().toLowerCase().contains(shield)){
                Picasso.get().load(icons.iconMap.get(shield)).error(R.drawable.realmadridshield).into(awayTeamImage);
                homeTeamImage.setImageResource(R.drawable.realmadridshield);
            }
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
