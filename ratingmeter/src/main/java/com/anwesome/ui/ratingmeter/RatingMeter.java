package com.anwesome.ui.ratingmeter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 12/01/17.
 */
public class RatingMeter {
    private Activity activity;
    private int w,h;
    public RatingMeter(Activity activity) {
        this.activity = activity;
        getDimensions();
    }
    public void getDimensions() {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display!=null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addRatings(float x,float y) {
        RatingView ratingView = new RatingView(activity.getApplicationContext());
        ratingView.setX(x);
        ratingView.setY(y);
        int r = w/2;
        if(h<w) {
            r = h/2;
        }
        activity.addContentView(ratingView, new ViewGroup.LayoutParams(r,r/7));
    }
}
