package com.antique.heritage;

import android.content.Context;

public class Product {
    private int imageResId; // Resource ID for the image
    private String name;

    public Product(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}
