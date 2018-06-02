package com.example.franciscoandrade.soccerteams.presentation.contract;

import com.example.franciscoandrade.soccerteams.data.model.GamesModel;

import java.util.List;

public interface HomeContract {
    interface View{
        void setStack(List<GamesModel> gamesList);
        void showMessage();
    }

    interface Presenter{
        void getGamesList();

    }

}
