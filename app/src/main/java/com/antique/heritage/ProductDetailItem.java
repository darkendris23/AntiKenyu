package com.antique.heritage;

public class ProductDetailItem {

    private int imageResId;
    private String title;
    private int price;
    private String description;

    public ProductDetailItem(int imageResId, String title, int quantity, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.price = quantity;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

