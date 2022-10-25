package com.gildedrose;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.CustomItem;
import com.gildedrose.model.Item;
import com.gildedrose.util.Util;

class GildedRose {

    private static final int MIN_QUALITY_VAL = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            createItem(item).updateItemState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = MIN_QUALITY_VAL;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = Util.maxValue(item);
            }
        }
    }

    private CustomItem createItem(Item item) {
        return new ItemFactory(item).createItem(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < MIN_QUALITY_VAL;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > Util.maxValue(item);
    }
}