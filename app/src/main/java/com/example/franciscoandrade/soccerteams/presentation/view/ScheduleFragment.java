package com.example.franciscoandrade.soccerteams.presentation.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.api.ClientService;
import com.example.franciscoandrade.soccerteams.data.api.TeamApi;
import com.example.franciscoandrade.soccerteams.data.model.ScheduleTeam;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    @BindView(R.id.recyclerGames)
    RecyclerView recyclerGames;
    Unbinder unbinder;
    View view;
    ClientService clientService;
    CalendarAdapter adapter;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schedule, container, false);
        unbinder = ButterKnife.bind(this, view);
        clientService = new ClientService(getString(R.string.WW_Domain_Team));

        adapter= new CalendarAdapter();
        recyclerGames.setAdapter(adapter);
        getGamesList();

        return view;
    }

    private void getGamesList() {
        TeamApi teamApi = clientService.getTeamApi();
        Call<ScheduleTeam> scheduleCall = teamApi.getSchedule();
        scheduleCall.enqueue(new Callback<ScheduleTeam>() {
            @Override
            public void onResponse(Call<ScheduleTeam> call, Response<ScheduleTeam> response) {
              Log.d("CALENDAR", "onResponse: "+response);
              if (response.body()!=null){
                adapter.addData(response.body().getSchedule());
              }
            }

            @Override
            public void onFailure(Call<ScheduleTeam> call, Throwable t) {

            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
