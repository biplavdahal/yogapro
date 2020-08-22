package com.binod.yoga;

public class Modelling {

    private int id;
    private String title;
    private String discountType;
    private int image;

    public Modelling(int id, String title, String discountType, int image) {
        this.id = id;
        this.title = title;
        this.discountType = discountType;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getImage() {
        return image;
    }
}
