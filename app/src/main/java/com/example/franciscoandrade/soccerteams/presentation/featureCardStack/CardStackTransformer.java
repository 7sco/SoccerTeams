package com.example.franciscoandrade.soccerteams.presentation.featureCardStack;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class CardStackTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position>=0){
            page.setScaleX(0.8f-0.05f*position);
            page.setScaleY(0.8f);

            //gives stack look
            page.setTranslationX(-page.getWidth()*position);
            //3d look- shifts every card up by 30 pixels
            page.setTranslationY(30*position);
        }
    }
}
