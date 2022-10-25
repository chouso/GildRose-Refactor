package com.gildedrose.model;

public class AgedBrie implements CustomItem {

    private Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        item.sellIn -= 1;
        item.quality += 1;

    }
}
