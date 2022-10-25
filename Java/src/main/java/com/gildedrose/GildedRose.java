package com.gildedrose;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.Item;
import com.gildedrose.model.Util;

class GildedRose {

    private static final int MIN_QUALITY_VAL = 0;
    private final ItemFactory itemFactory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.itemFactory = new ItemFactory();
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            itemFactory.createItem(item).updateItemState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = MIN_QUALITY_VAL;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = Util.maxValue(item);
            }
        }
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < MIN_QUALITY_VAL;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > Util.maxValue(item);
    }
}