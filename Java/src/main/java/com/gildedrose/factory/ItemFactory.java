package com.gildedrose.factory;

import java.util.HashMap;
import java.util.Map;

import com.gildedrose.model.AgedBrie;
import com.gildedrose.model.BackstagePasses;
import com.gildedrose.model.ConjuredItem;
import com.gildedrose.model.CustomItem;
import com.gildedrose.model.Item;
import com.gildedrose.model.StandardItem;
import com.gildedrose.model.Sulfuras;

public class ItemFactory {

    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String AGED_BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED = "Conjured";
    private final static Map<String, CustomItem> ITEM_CATEG_LIST = new HashMap<>();

    public ItemFactory(Item item) {
        ITEM_CATEG_LIST.put(SULFURAS, new Sulfuras());
        ITEM_CATEG_LIST.put(AGED_BRIE, new AgedBrie(item));
        ITEM_CATEG_LIST.put(BACKSTAGE_PASSES, new BackstagePasses(item));
        ITEM_CATEG_LIST.put(CONJURED, new ConjuredItem(item));
    }

    public CustomItem createItem(Item item) {
        if (isStandardItem(item)) {
            return new StandardItem(item);
        }
        return ITEM_CATEG_LIST.get(item.name);
    }

    private boolean isStandardItem(Item item) {
        return !ITEM_CATEG_LIST.keySet().contains(item.name);
    }
}
