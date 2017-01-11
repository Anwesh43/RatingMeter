package com.anwesome.ui.ratingmeterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.ratingmeter.RatingMeter;
import com.anwesome.ui.ratingmeter.RatingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RatingMeter ratingMeter = new RatingMeter(this);
        RatingView ratingView = ratingMeter.addRatings(200,200);
    }
}
