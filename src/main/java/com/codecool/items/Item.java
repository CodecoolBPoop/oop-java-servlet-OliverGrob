package com.codecool.items;

public class Item {

    private static int uniqueID = 1;

    private int id;
    private String name;
    private double price;
    private int number;


    public Item(String name, double price, int number) {
        this.id = uniqueID++;
        this.name = name;
        this.price = price;
        this.number = number;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "[" + this.id + ", " + this.name + ", " + this.price + "]";
    }

}
