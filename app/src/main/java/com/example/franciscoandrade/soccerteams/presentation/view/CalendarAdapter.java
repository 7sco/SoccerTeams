package com.example.franciscoandrade.soccerteams.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.ScheduleTeam;
import com.example.franciscoandrade.soccerteams.presentation.newsRecycler.NewsViewHolder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private List<ScheduleTeam.Schedule> data= new ArrayList<>();

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.next_games_viewholder, parent, false);
        return new CalendarViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        ScheduleTeam.Schedule team= data.get(position);

        Log.d("==", "onBindViewHolder: AAPTER");
        try {
            holder.bind(team);
            //Log.d("date", "onBindViewHolder: ");
        } catch (ParseException e) {
            e.printStackTrace();
            //Log.d("date", "onBindViewHolder: ");
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<ScheduleTeam.Schedule> scheduleList){
        data.clear();
        data.addAll(scheduleList);
        notifyDataSetChanged();
    }
}
