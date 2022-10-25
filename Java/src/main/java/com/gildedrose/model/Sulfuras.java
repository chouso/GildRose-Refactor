package com.gildedrose.model;

public class Sulfuras implements CustomItem {

    private Item item;

    public Sulfuras(Item item) {
    }

    @Override
    public void updateItemState() {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality 
    }
}
