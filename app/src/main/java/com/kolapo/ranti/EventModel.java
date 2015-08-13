package com.kolapo.ranti;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by Kolapo on 8/1/2015.
 */
public class EventModel {
    public String eName;
    public String eDate;
    public Bitmap ebitmap;

    public EventModel(String name, String date, Bitmap bitmap){
        this.eName = name;
        this.eDate = date;
        this.ebitmap = bitmap;
    }

    public String getName(){
        return eName;
    }

    public String getDate(){
        return eDate;
    }

    public Bitmap getBitmap(){
        return ebitmap;
    }
}
