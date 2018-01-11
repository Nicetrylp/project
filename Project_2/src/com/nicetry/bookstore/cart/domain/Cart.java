package com.nicetry.bookstore.cart.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static Map<String,CartItem> carMap = new HashMap<>();

    public static Map<String, CartItem> getCarMap() {
        return carMap;
    }

    public static void setCarMap(String key,CartItem value) {
        carMap.put(key, value);
    }

    public Cart() {

    }

    public Cart(Map<String, CartItem> carMap) {

        this.carMap = carMap;
    }
}
