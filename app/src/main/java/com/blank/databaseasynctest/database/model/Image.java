package com.blank.databaseasynctest.database.model;

/**
 * Created by Christian Moreno on 1/27/2016.
 */
public class Image {

    private int id;
    private int imageLocation;

    public Image() {}

    public Image(int id, int img) {
        this.id = id;
        this.imageLocation = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageLocation(int img) {
        this.imageLocation = img;
    }

    public int getId() {
        return this.id;
    }

    public int getImageLocation() {
        return this.imageLocation;
    }

}
