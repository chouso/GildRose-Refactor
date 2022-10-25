package com.gildedrose.util;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.Item;

public final class Util {

    public static int maxValue(Item item) {
        if (item.name.equals(ItemFactory.SULFURAS)) {
            return 80;
        }
        return 50;
    }

    private Util() {
        throw new IllegalStateException("Utility class");
    }
}
