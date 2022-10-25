package com.gildedrose.factory;

import com.gildedrose.model.AgedBrie;
import com.gildedrose.model.BackstagePasses;
import com.gildedrose.model.Item;
import com.gildedrose.model.StandardItem;
import com.gildedrose.model.Sulfuras;

public class ItemFactory {

    public Item createItem(String itemName, int sellIn, int quality) {
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            return new Sulfuras(itemName, sellIn, quality);
        } else if (itemName.equals("Aged Brie")) {
            return new AgedBrie(itemName, sellIn, quality);
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePasses(itemName, sellIn, quality);
        } else {
            return new StandardItem(itemName, sellIn, quality);
        }
    }
}
