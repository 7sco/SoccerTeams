package com.example.franciscoandrade.soccerteams.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.standings.StandingModel;

import java.util.ArrayList;
import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsViewHolder> {

    List<StandingModel.TeamStandings> standingsList= new ArrayList<>();
    @NonNull
    @Override
    public StandingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_viewholder, parent, false);
        return new StandingsViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsViewHolder holder, int position) {
        StandingModel.TeamStandings standings= standingsList.get(position);
        holder.bind(standings, position);

    }

    @Override
    public int getItemCount() {
        return standingsList.size();
    }

    public void addStandings(List<StandingModel.TeamStandings> standingsList) {
        this.standingsList=standingsList;
        notifyDataSetChanged();

    }
}
