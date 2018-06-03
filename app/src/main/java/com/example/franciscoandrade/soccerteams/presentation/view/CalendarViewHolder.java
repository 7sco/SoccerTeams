package com.example.franciscoandrade.soccerteams.presentation.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.franciscoandrade.soccerteams.R;
import com.example.franciscoandrade.soccerteams.data.model.ScheduleTeam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.homeTeam)
    TextView hometeam;
    @BindView(R.id.awayTeam)
    TextView awayTeam;

    public CalendarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bind(ScheduleTeam.Schedule team) throws ParseException {

        hometeam.setText(team.getCompetitors().get(0).getName());
        awayTeam.setText(team.getCompetitors().get(1).getName());

        String [] array= team.getScheduled().split("T");
        String s;
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(array[0]);
        formatter = new SimpleDateFormat("MM.dd.yy");
        s = formatter.format(date1);

        String [] timeArray=array[1].split(":");

        Log.d("date==", "bind: "+timeArray[0]);
        //Log.d("date==", "bind: "+timeArray[1]);
        int hour;
        if (timeArray[0].equals("00")){
          hour=0;
        }
        else {
            hour=Integer.valueOf(timeArray[0]);
        }
        if(hour<4){
            hour=24+hour;
        }
        if(hour==0){
            hour= 24;
        }
        hour=hour-4;
        date.setText(s);
        String gameTime=hour+":"+timeArray[1];
        time.setText(gameTime);
    }
}
