 package com.example.assignment1;

public class Item {
    private String name;
    private String time;
    private String calories;
    private int imageResId;
    private int quantity;
    private String price; // keep as String for simplicity

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }
    public Item(String name, String time, String calories, int imageResId, int quantity) {
        this.name = name;
        this.time = time;
        this.calories = calories;
        this.imageResId = imageResId;
        this.quantity = quantity;
    }
    public Item(String name) {
        this.name = name;
    }
    public String getPrice() { return price; }

    public String toDisplayString() {
        return name + " - $" + price;
    }

    public String getName() { return name; }
    public String getTime() { return time; }
    public String getCalories() { return calories; }
    public int getImageResId() { return imageResId; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


