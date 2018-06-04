package com.example.franciscoandrade.soccerteams.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.franciscoandrade.soccerteams.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TourActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        ButterKnife.bind(this);

        //"<iframe width=\"100%\" height=\"100%\" src=\"\" frameholder=\"0\" allowfullscreen></iframe>"
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UlFkOZFQCBQ\" frameholder=\"0\" allowfullscreen></iframe>", "text/html", "utf-8");
    }
}
//"https://www.youtube.com/watch?v=MUEyC9W0664"