package com.gildedrose.model;

public class StandardItem implements CustomItem {

    private Item item;

    public StandardItem(Item item) {
        this.item = item;
    }

    public void updateItemState() {
        item.sellIn -= 1;
        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }
    }
}
