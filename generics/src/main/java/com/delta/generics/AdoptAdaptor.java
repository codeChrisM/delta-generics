package com.delta.generics;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Christopher on 4/7/2016.
 */
public class AdoptAdaptor<T extends Animal & Adoptable> {

    private Activity activity;
    private TextView name;
    private TextView description;
    private RatingBar ratingBar;
    private ImageView imageView;

    //T stands for type
    private T t;

    public AdoptAdaptor(Activity aActivity, TextView aName, TextView aDescription, RatingBar aBar, ImageView aImageView){
        this.activity = aActivity;
        this.name = aName;
        this.description = aDescription;
        this.ratingBar = aBar;
        this.imageView = aImageView;
    }

    public void set(T t){
        this.t = t;
        updateView();
    }

    public  T get(){
        return t;
    }

    public void  updateView(){
        int resID = t.getImageResourceId(activity);
        imageView.setImageResource(resID);
        name.setText(t.getName());
        description.setText(t.getDescription());
        ratingBar.setNumStars(5);
        ratingBar.setRating(t.getRating());
    }

}
