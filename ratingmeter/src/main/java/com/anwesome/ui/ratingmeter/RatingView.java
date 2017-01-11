package com.anwesome.ui.ratingmeter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.*;
/**
 * Created by anweshmishra on 12/01/17.
 */
public class RatingView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int w,h;
    int time = 0;
    private List<Star> stars = new ArrayList<>();
    public RatingView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
        }
        for(int i=0;i<5;i++) {
            stars.add(new Star(i*w/7+i*w/14+w/14,h/2));
        }
        for(Star star:stars) {
            star.draw(canvas,paint);
        }
        time++;
    }
    public void handleFill(int fillIndex) {
        if(fillIndex!=-1) {
            for(int i=0;i<fillIndex;i++) {
                Star star = stars.get(i);
                star.setFill(true);
            }
            for(int i=fillIndex+1;i<stars.size();i++) {
                Star star = stars.get(i);
                star.setFill(false);
            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int index = 0,fillIndex = -1;
                for(Star star:stars) {
                    if(star.handleTap(x,y)) {
                        fillIndex = index;
                        break;
                    }
                    index++;
                }
                handleFill(fillIndex);
                postInvalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }
    private class Star {
        private boolean fill = false;
        private float x=0,y=0;
        public Star(float x,float y) {
            this.x = x;
            this.y = y;
        }
        public void draw(Canvas canvas,Paint paint) {
            if(fill) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.parseColor("#E6BC27"));
            }
            else {
                paint.setColor(Color.GRAY);
                paint.setStyle(Paint.Style.STROKE);
            }
            Path path = new Path();
            float r2 = w/14, r1 = w/28;
            path.moveTo(x+r1,y);
            for(int i = 0;i<6;i++) {
                float x1 = (float)(x+r1*Math.cos(i*60*Math.PI/180)),y1 = (float)(y+r1*Math.sin(i*60*Math.PI/180));
                float x2 = (float)(x+r1*Math.cos((i+1)*60*Math.PI/180)),y2 = (float)(y+r1*Math.sin((i+1)*60*Math.PI/180));
                float x3= (float)(x+r2*Math.cos((i*60+30)*Math.PI/180)),y3 = (float)(y+r2*Math.sin((i*60+30)*Math.PI/180));
                path.lineTo(x1,y1);
                path.lineTo(x3,y3);
                path.lineTo(x2,y2);
            }
            canvas.drawPath(path,paint);
        }
        public boolean handleTap(float x,float y) {
            if(x>this.x-w/14 && x<this.x+w/14 && y>this.y-w/14 && y<this.y+w/14) {
                fill=true;
                return true;
            }
            return false;
        }
        public int hashCode() {
            return (int)x+(int)y;
        }
        public void setFill(boolean fill) {
            this.fill = fill;
        }
    }
}
