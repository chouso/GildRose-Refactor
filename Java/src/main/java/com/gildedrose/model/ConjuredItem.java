package com.gildedrose.model;

public class ConjuredItem implements CustomItem {

    private final Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateItemState() {
        item.sellIn -= 1;
        if (item.sellIn > 0) {
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }

    }

}
