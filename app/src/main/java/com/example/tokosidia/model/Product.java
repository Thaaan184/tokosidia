package com.example.tokosidia.model;
public class Product {
    private String name;
    private double price;
    private String description;
    private float rating;
    private int imageResId;
// Konstruktor untuk menginisialisasi objek Product
public Product(String name, double price, String description, float rating, int imageResId) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.rating = rating;
    this.imageResId = imageResId;
}
    // Getter method untuk mengambil nilai 'name'
    public String getName() { return name; }
    // Getter method untuk mengambil nilai 'price'
    public double getPrice() { return price; }
    // Getter method untuk mengambil nilai 'description'
    public String getDescription() { return description; }
    // Getter method untuk mengambil nilai 'rating'
    public float getRating() { return rating; }
    // Getter method untuk mengambil nilai 'imageResId'
    public int getImageResId() { return imageResId; }
}