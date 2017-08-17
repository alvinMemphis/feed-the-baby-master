package com.example.alvin.feedthebaby;

import android.widget.ImageView;

/**
 * Created by alvin on 8/14/17.
 */

public class Babysetting {
   private String babyName;
    private String babyAge;
    private boolean sex;
    private ImageView babyImage;

    public ImageView getBabyImage() {
        return babyImage;
    }

    public void setBabyImage(ImageView babyImage) {
        this.babyImage = babyImage;
    }



    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(String babyAge) {
        this.babyAge = babyAge;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }


}
