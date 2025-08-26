package com.example.model;


public abstract class Furniture {
  
    private String name;
    private double price;
    private String material;

    public Furniture(String name, double price, String material) {
        this.name = name;
        this.price = price;
        this.material = material;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return name + " (Price: $" + price + ")";
    }
    public String getMaterial() {
        return name + " (Material is " + material + ")";
    }

}

