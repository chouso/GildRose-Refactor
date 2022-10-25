package com.gildedrose.factory;

import com.gildedrose.model.AgedBrie;
import com.gildedrose.model.BackstagePasses;
import com.gildedrose.model.CustomItem;
import com.gildedrose.model.Item;
import com.gildedrose.model.StandardItem;
import com.gildedrose.model.Sulfuras;

public class ItemFactory {

    public CustomItem createItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras(item);
        } else if (item.name.equals("Aged Brie")) {
            return new AgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePasses(item);
        } else {
            return new StandardItem(item);
        }
    }
}
