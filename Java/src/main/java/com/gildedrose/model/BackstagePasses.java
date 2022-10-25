package com.gildedrose.model;

public class BackstagePasses implements CustomItem {

    private Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        item.sellIn -= 1;
        if (item.sellIn >= 11) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }

    }
}
