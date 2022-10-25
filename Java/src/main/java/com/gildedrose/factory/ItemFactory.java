package com.gildedrose.factory;

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

    public CustomItem createItem(Item item) {
        if (item.name.equals(SULFURAS)) {
            return new Sulfuras(item);
        } else if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            return new BackstagePasses(item);
        } else if (item.name.equals(CONJURED)) {
            return new ConjuredItem(item);
        } else {
            return new StandardItem(item);
        }
    }
}
