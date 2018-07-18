package com.codecool.items;

public class ItemFactory {

    public Item getItem(Integer item) {
        if (item == null) {
            return null;
        }

        if (item == 0) {
            return new Item("Blue", 200.0, 0);
        } else if (item == 1) {
            return new Item("Green", 300.0, 1);
        } else if (item == 2) {
            return new Item("Red", 800.0, 2);
        } else if (item == 3) {
            return new Item("Yellow", 600.0, 3);
        } else if (item == 4) {
            return new Item("Pink", 1000.0, 4);
        } else if (item == 5) {
            return new Item("Orange", 1500.0, 5);
        } else if (item == 6) {
            return new Item("Purple", 1200.0, 6);
        } else if (item == 7) {
            return new Item("Brown", 100.0, 7);
        }

        return null;
    }

}
