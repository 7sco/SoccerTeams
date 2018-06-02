package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.Player;
import com.example.franciscoandrade.soccerteams.presentation.featureScrollView.PlayerAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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


    private List<Player> listPlayer;
    PlayerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);


        listPlayer= new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if(i%2==0){
            listPlayer.add(new Player("S. Ramos", R.drawable.sergio_ramos, R.drawable.ramos_head, i*5, i*3, i*2, i*i));
            }
            else {
                listPlayer.add(new Player("G. Bale", R.drawable.g_bale, R.drawable.bale_head, i*5, i*3, i*2, i*i));
            }

        }



        adapter= new PlayerAdapter();
        adapter.addMovies(listPlayer);





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

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCurrentItemChanged(@Nullable PlayerAdapter.ViewHolder holder, int adapterPosition) {

        if (holder != null) {
            //forecastView.setForecast(forecasts.get(position));
            holder.showText();


            Log.d("===", "onCurrentItemChanged: "+listPlayer.get(adapterPosition).getName());
            Log.d("===", "onCurrentItemChanged: "+listPlayer.get(adapterPosition).getAssist());
            Log.d("===", "onCurrentItemChanged: "+listPlayer.get(adapterPosition).getGames());
            Log.d("===", "onCurrentItemChanged: "+listPlayer.get(adapterPosition).getGoals());
            Log.d("===", "onCurrentItemChanged: "+listPlayer.get(adapterPosition).getShots());

            playerImg.setImageResource(listPlayer.get(adapterPosition).getPlayerImage());
            gamesNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getGames()));
            goalsNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getGoals()));
            assistNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getAssist()));
            shotsNumber.setText(String.valueOf(listPlayer.get(adapterPosition).getShots()));


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
