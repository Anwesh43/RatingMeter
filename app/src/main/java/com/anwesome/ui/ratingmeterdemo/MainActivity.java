package com.anwesome.ui.ratingmeterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.ratingmeter.RatingListener;
import com.anwesome.ui.ratingmeter.RatingMeter;
import com.anwesome.ui.ratingmeter.RatingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RatingMeter ratingMeter = new RatingMeter(this);
        RatingView ratingView = ratingMeter.addRatings(200,200);
        ratingView.setRatingListener(new RatingListener() {
            @Override
            public void on1Star(int rating) {
                Toast.makeText(MainActivity.this,"Poor",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void on2Star(int rating) {
                Toast.makeText(MainActivity.this,"Medicore",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void on3Star(int rating) {
                Toast.makeText(MainActivity.this,"Average",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void on4Star(int rating) {
                Toast.makeText(MainActivity.this,"Good",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void on5Star(int rating) {
                Toast.makeText(MainActivity.this,"Awesome",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
