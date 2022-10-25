package com.gildedrose;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.Item;

class GildedRose {

    private static final int MIN_QUALITY_VAL = 0;
    private static final int MAX_QUALITY_VAL = 50;
    private final ItemFactory itemFactory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.itemFactory = new ItemFactory();
        this.items = items;
    }

    public void updateQuality() {
        customizeItems();
        for (Item item : items) {
            item.updateItemState();
            if (hasReachedMinValue(item.quality)) {
                item.quality = MIN_QUALITY_VAL;
            } else if (hasReachedMaxValue(item.quality)) {
                item.quality = MAX_QUALITY_VAL;
            }
        }
    }

    private void customizeItems() {
        for (Item item : items) {
            items = new Item[] { itemFactory.createItem(item.name, item.sellIn, item.quality) };
        }
    }

    private boolean hasReachedMinValue(int itemQuality) {
        return itemQuality < MIN_QUALITY_VAL;
    }

    private boolean hasReachedMaxValue(int itemQuality) {
        return itemQuality > MAX_QUALITY_VAL;
    }
}