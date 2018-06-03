package com.example.franciscoandrade.soccerteams.presentation.view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.standings.StandingModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StandingsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.teamPosition)
    TextView teamPosition;

    @BindView(R.id.teamName)
    TextView teamName;

    @BindView(R.id.playedGames)
    TextView playedGames;

    @BindView(R.id.teampts)
    TextView teampts;

    @BindView(R.id.container_viewholder)
    LinearLayout container;

    public StandingsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }




    public void bind(StandingModel.TeamStandings standings, int position) {

        if ((position%2)==0 ){
            container.setBackgroundColor(Color.WHITE);
        }
        else {
            container.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.light_gray));

        }

        teamPosition.setText(String.valueOf(standings.getRank()));
        teamName.setText(standings.getTeam().getName());
        playedGames.setText(String.valueOf(standings.getPlayed()));
        teampts.setText(String.valueOf(standings.getPoints()));
    }
}
