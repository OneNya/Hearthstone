package com.example.hearthstone;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class ModelClass {
   String Name;
   int rank;
   String image;
   double winrate;

    public String getName() {
        return Name;
    }
    public String getImage(){
        return image;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getWinrate() {
        return winrate;
    }

    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }
}
