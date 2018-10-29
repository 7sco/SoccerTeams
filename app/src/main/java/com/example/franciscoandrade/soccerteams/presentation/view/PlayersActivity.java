package com.example.franciscoandrade.soccerteams.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.api.ClientService;
import com.example.franciscoandrade.soccerteams.data.api.TeamApi;
import com.example.franciscoandrade.soccerteams.data.model.team.PlayerInfo;
import com.example.franciscoandrade.soccerteams.data.model.team.TeamProfile;
import com.example.franciscoandrade.soccerteams.presentation.PlayersListBody;
import com.example.franciscoandrade.soccerteams.presentation.featureScrollView.PlayerAdapter;
import com.squareup.picasso.Picasso;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersActivity extends AppCompatActivity implements
        DiscreteScrollView.ScrollStateChangeListener<PlayerAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<PlayerAdapter.ViewHolder> {

    @BindView(R.id.back_btn)
    ImageView backBtn;
    @BindView(R.id.player_picker)
    DiscreteScrollView playerPicker;
    @BindView(R.id.player_img)
    ImageView playerImg;
    @BindView(R.id.games_tv)
    TextView gamesTv;
    @BindView(R.id.goals_tv)
    TextView goalsTv;
    @BindView(R.id.assist_tv)
    TextView assistTv;
    @BindView(R.id.shots_tv)
    TextView shotsTv;
    @BindView(R.id.games_number)
    TextView gamesNumber;
    @BindView(R.id.goals_number)
    TextView goalsNumber;
    @BindView(R.id.assist_number)
    TextView assistNumber;
    @BindView(R.id.shots_number)
    TextView shotsNumber;
    @BindView(R.id.constrain)
    ConstraintLayout background;

    private ClientService clientService;
    private List<TeamProfile.Players> listPlayer;
    private PlayerAdapter adapter;

    private PlayersListBody playersInfo;
    TeamApi teamApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
        adapter= new PlayerAdapter();
        clientService = new ClientService(getString(R.string.WW_Domain_Team));
        getListPlayersName();
        playerPicker.setSlideOnFling(true);
        playerPicker.setAdapter(adapter);
        playerPicker.addOnItemChangedListener(this);
        playerPicker.addScrollStateChangeListener(this);
        playerPicker.scrollToPosition(2);
        playerPicker.setItemTransitionTimeMillis(150);
        playerPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.5f)
                .setMinScale(0.8f)
                .build());
      playersInfo = new PlayersListBody();

        teamApi = clientService.getTeamApi();
    }

    private void getListPlayersName() {
        TeamApi teamApi= clientService.getTeamApi();
        Call<TeamProfile> teamCall= teamApi.getTeamList();
        teamCall.enqueue(new Callback<TeamProfile>() {
            @Override
            public void onResponse(Call<TeamProfile> call, Response<TeamProfile> response) {
                listPlayer= new ArrayList<>();
                listPlayer.addAll(response.body().getPlayers());
                adapter.addMovies(listPlayer);
            }

            @Override
            public void onFailure(Call<TeamProfile> call, Throwable t) {
                Log.d("==", "onFailure: FAIL"+t.getMessage());
            }
        });
    }

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
        onBackPressed();
        finish();
    }

    @Override
    public void onCurrentItemChanged(@Nullable PlayerAdapter.ViewHolder holder, int adapterPosition) {

        if (holder != null) {
            holder.showText();
            Integer player = listPlayer.get(adapterPosition).getJerseyNumber();
            String playerUrl="https://www.Realmadrid.com/cs/Satellite?blobcol=urldata&blobheader=image%2Fpng&blobkey=id&blobtable=MungoBlobs&blobwhere="+ playersInfo.bodyList.get(player)+"&ssbinary=true";
            Picasso.get().load(playerUrl).error(R.drawable.realmadridshield).into(playerImg);

            Call<PlayerInfo> playerCall= teamApi.getPlayerInfo(listPlayer.get(adapterPosition).getId());
            playerCall.enqueue(new Callback<PlayerInfo>() {
                @Override
                public void onResponse(Call<PlayerInfo> call, Response<PlayerInfo> response) {
                    PlayerInfo playerInfo= response.body();
                    if(playerInfo != null){
                        gamesNumber.setText(String.valueOf(playerInfo.getStatistics().getTotals().getMatchesPlayed()));
                        goalsNumber.setText(String.valueOf(playerInfo.getStatistics().getTotals().getGoalsScored()));
                        assistNumber.setText(String.valueOf(playerInfo.getStatistics().getTotals().getAssists()));
                        shotsNumber.setText(String.valueOf(String.valueOf(playerInfo.getStatistics().getTotals().getYellowCards())));
                    }
                }

                @Override
                public void onFailure(Call<PlayerInfo> call, Throwable t) {
                    Log.d("==", "onFailure: "+t.getMessage());
                }
            });
        }

    }

    @Override
    public void onScrollStart(@NonNull PlayerAdapter.ViewHolder currentItemHolder, int adapterPosition) {
        currentItemHolder.hideText();

    }

    @Override
    public void onScrollEnd(@NonNull PlayerAdapter.ViewHolder currentItemHolder, int adapterPosition) {

    }

    @Override
    public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable PlayerAdapter.ViewHolder currentHolder, @Nullable PlayerAdapter.ViewHolder newCurrent) {

    }
}
