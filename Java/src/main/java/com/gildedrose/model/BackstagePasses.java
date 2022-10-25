package com.gildedrose.model;

public class BackstagePasses extends Item {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItemState() {
        sellIn -= 1;
        if (sellIn >= 11) {
            quality += 1;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn > 0) {
            quality += 3;
        } else {
            quality = 0;
        }
    }
}
