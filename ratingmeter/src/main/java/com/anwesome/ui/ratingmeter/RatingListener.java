package com.anwesome.ui.ratingmeter;

/**
 * Created by anweshmishra on 12/01/17.
 */
public interface RatingListener {
    void on1Star(int rating);
    void on2Star(int rating);
    void on3Star(int rating);
    void on4Star(int rating);
    void on5Star(int rating);
}
