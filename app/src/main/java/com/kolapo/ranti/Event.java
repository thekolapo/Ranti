package com.kolapo.ranti;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by Kolapo on 8/1/2015.
 */
public class Event {
    public String name;
    public String date;
    public Bitmap bitmap;

    public Event(String name, String date, Bitmap bitmap){
        this.name = name;
        this.date = date;
        this.bitmap = bitmap;
    }
}
