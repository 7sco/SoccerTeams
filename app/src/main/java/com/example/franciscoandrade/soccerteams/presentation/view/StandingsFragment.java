package com.example.franciscoandrade.soccerteams.presentation.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.franciscoandrade.soccerteams.data.model.standings.StandingModel;

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
public class StandingsFragment extends Fragment {


    View view;
    Unbinder unbinder;
     StandingsAdapter adapter;
    ClientService clientService;
    List<StandingModel.TeamStandings> standingsList;
    @BindView(R.id.recyclerStandings)
    RecyclerView recyclerStandings;


    public StandingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_standings, container, false);
        unbinder = ButterKnife.bind(this, view);
        clientService = new ClientService(getString(R.string.WW_Domain_Team));

        adapter= new StandingsAdapter();
        recyclerStandings.setAdapter(adapter);


        return view;
    }

    @Override public void onViewCreated(
        @NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getStandings();
    }

    private void getStandings() {

        TeamApi teamApi = clientService.getTeamApi();
        Call<StandingModel> scheduleCall = teamApi.getStandings();
        scheduleCall.enqueue(new Callback<StandingModel>() {
            @Override
            public void onResponse(Call<StandingModel> call, Response<StandingModel> response) {
                if (response.body()!=null) {
                    adapter.addStandings(response
                        .body()
                        .getStandings()
                        .get(0)
                        .getGroups()
                        .get(0)
                        .getTeamStandings());
                }
            }

            @Override
            public void onFailure(Call<StandingModel> call, Throwable t) {
                Log.d("stands", "onFailure: FAIL");
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
