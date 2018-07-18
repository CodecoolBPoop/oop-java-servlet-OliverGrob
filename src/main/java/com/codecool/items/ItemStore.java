package com.codecool.items;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {

    private static List<Item> items = new ArrayList<>();
    private static List<Item> shoppingCart = new ArrayList<>();


    public static List<Item> getShopItems() {
        return items;
    }

    public static List<Item> getShoppingCartItems() {
        return shoppingCart;
    }

    public static void addItemToShop(Item item) {
        items.add(item);
    }

    public static void removeItemFromShop(Item item) {
        items.remove(item);
    }

    public static void addItemToShoppingCart(Item item) {
        shoppingCart.add(item);
    }

    public static void removeItemFromShoppingCart(String itemName) {
        for (Item item : shoppingCart) {
            if (item.getName().equals(itemName)) {
                shoppingCart.remove(item);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (Item item : items) {
            result.append("[").append(item.getId()).append(", ").append(item.getName()).append(", ").append(item.getPrice()).append("]");
        }

        result.append("]");

        return result.toString();
    }

}
