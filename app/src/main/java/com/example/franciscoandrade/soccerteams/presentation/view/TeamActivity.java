package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamActivity extends AppCompatActivity {

    @BindView(R.id.back_btn)
    ImageView backBtn;
    @BindView(R.id.calendar_tv)
    TextView calendarTv;
    @BindView(R.id.calendar_underline)
    TextView calendarUnderline;
    @BindView(R.id.standings_tv)
    TextView standingsTv;
    @BindView(R.id.standings_underline)
    TextView standingsUnderline;

    private Fragment fragmentCalendar, fragmentStandings;
    private FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        calendarUnderline.setVisibility(View.VISIBLE);
        standingsUnderline.setVisibility(View.INVISIBLE);
        calendarTv.setTextColor(getResources().getColor(R.color.color_yellow));
        fragmentCalendar= fragmentManager.findFragmentById(R.id.conainer);
        fragmentStandings= fragmentManager.findFragmentById(R.id.conainer);
        fragmentCalendar= new ScheduleFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.conainer, fragmentCalendar)
                .commit();

    }

    @OnClick(R.id.back_btn)
    public void onViewClicked() {
        onBackPressed();
        finish();
    }

    private void showUnderlineStandings() {
        if(standingsUnderline.getVisibility()!=View.VISIBLE){
            standingsTv.setTextColor(getResources().getColor(R.color.color_yellow));
            calendarTv.setTextColor(getResources().getColor(R.color.white));
            standingsUnderline.setVisibility(View.VISIBLE);
            calendarUnderline.setVisibility(View.INVISIBLE);
        }
    }

    private void showUnderlineCalendar() {
        if(calendarUnderline.getVisibility()!=View.VISIBLE){
            standingsTv.setTextColor(getResources().getColor(R.color.white));
            calendarTv.setTextColor(getResources().getColor(R.color.color_yellow));
            calendarUnderline.setVisibility(View.VISIBLE);
            standingsUnderline.setVisibility(View.INVISIBLE);

        }
    }

    @OnClick({R.id.calendar_tv, R.id.standings_tv})
    public void onViewClicked(View view) {


        switch (view.getId()) {
            case R.id.calendar_tv:
                if (fragmentCalendar==null){
                    fragmentCalendar= new ScheduleFragment();
                }
                showUnderlineCalendar();
                fragmentManager.beginTransaction()
                        .replace(R.id.conainer, fragmentCalendar)
                        .commit();
                break;
            case R.id.standings_tv:
                if (fragmentStandings==null){
                    fragmentStandings= new StandingsFragment();
                }
                showUnderlineStandings();
                fragmentManager.beginTransaction()
                        .replace(R.id.conainer, fragmentStandings)
                        .commit();
                break;
        }
    }


}
