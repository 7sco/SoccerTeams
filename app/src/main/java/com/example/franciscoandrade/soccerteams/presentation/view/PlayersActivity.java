package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
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
import com.example.franciscoandrade.soccerteams.presentation.featureScrollView.PlayerAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);




//        listPlayer= new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            if(i%2==0){
//            listPlayer.add(new PlayerInfo("S. Ramos", R.drawable.sergio_ramos, R.drawable.ramos_head, i*5, i*3, i*2, i*i));
//            }
//            else {
//                listPlayer.add(new PlayerInfo("G. Bale", R.drawable.g_bale, R.drawable.bale_head, i*5, i*3, i*2, i*i));
//            }
//
//        }



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
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
       // overridePendingTransition  ( R.anim.right_slide_out,R.anim.right_slide_in);
        onBackPressed();
        finish();
    }

    @Override
    public void onCurrentItemChanged(@Nullable PlayerAdapter.ViewHolder holder, int adapterPosition) {

        if (holder != null) {
            holder.showText();
            if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("keylo")){
                playerImg.setImageResource(R.drawable.keylor_body);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("dani")){
                playerImg.setImageResource(R.drawable.carvajal_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("jesus")){
                playerImg.setImageResource(R.drawable.vallejo_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("sergio")){
                playerImg.setImageResource(R.drawable.sergio_ramos);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("raphael")){
                playerImg.setImageResource(R.drawable.varane_body);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("nacho")){
                playerImg.setImageResource(R.drawable.nacho_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("ronaldo")){
                playerImg.setImageResource(R.drawable.cristiano_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("toni")){
                playerImg.setImageResource(R.drawable.kroos_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("karim")){
                playerImg.setImageResource(R.drawable.benzema_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("luka")){
                playerImg.setImageResource(R.drawable.modric_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("gareth")){
                playerImg.setImageResource(R.drawable.g_bale);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("marcelo")){
                playerImg.setImageResource(R.drawable.marcelo_body);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("kiko")){
                playerImg.setImageResource(R.drawable.casilla_body);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("casemiro")){
                playerImg.setImageResource(R.drawable.casemiro_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("theo")){
                playerImg.setImageResource(R.drawable.theo_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("lucas")){
                playerImg.setImageResource(R.drawable.lucas_body);
            }

            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("marcos")){
                playerImg.setImageResource(R.drawable.llorente_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("achraf")){
                playerImg.setImageResource(R.drawable.achraf_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("marco")){
                playerImg.setImageResource(R.drawable.asensio_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("borja")){
                playerImg.setImageResource(R.drawable.mayoral_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("isco")){
                playerImg.setImageResource(R.drawable.isco_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("mateo")){
                playerImg.setImageResource(R.drawable.kovacic_body);
            }
            else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("dani")){
                playerImg.setImageResource(R.drawable.ceballos_body);
            }
           else if (listPlayer.get(adapterPosition).getName().toLowerCase().contains("zidane")){
                playerImg.setImageResource(R.drawable.zidane_body);
            }

            TeamApi teamApi= clientService.getTeamApi();
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


//            playerImg.setImageResource(listPlayer.get(adapterPosition).getPlayerImage());
//            gamesNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getGames()));
//            goalsNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getGoals()));
//            assistNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getAssist()));
//            shotsNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getShots()));


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


//    public void showText() {
//        int parentHeight = ((View) background.getParent()).getHeight();
//        float scale = (parentHeight - textView.getHeight()) / (float) background.getHeight();
//        textView.setPivotX(textView.getWidth() *  0.5f);
//        textView.setPivotY(0);
//        textView.animate().scaleX(scale)
//                .withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setVisibility(View.VISIBLE);
//                        //imageView.setColorFilter(Color.BLACK);
//                    }
//                })
//                .scaleY(scale).setDuration(200)
//                .start();
//    }

//    public void hideText() {
//        //imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.grayIconTint));
//        textView.setVisibility(View.INVISIBLE);
//        textView.animate().scaleX(1f).scaleY(1f)
//                .setDuration(200)
//                .start();
//    }
}
