package com.gildedrose.model;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItemState() {
        sellIn -= 1;
        quality += 1;
    }
}
