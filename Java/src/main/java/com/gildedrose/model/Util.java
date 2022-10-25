package com.gildedrose.model;

public final class Util {

    public static int maxValue(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return 80;
        }
        return 50;
    }

    private Util() {
        throw new IllegalStateException("Utility class");
    }
}
