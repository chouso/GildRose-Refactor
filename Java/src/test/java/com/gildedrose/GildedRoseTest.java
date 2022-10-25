package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.model.Item;

public class GildedRoseTest {

    @Test
    public void testFoo() {
        GildedRose app = createGildedRose("foo", 0, 0);

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testItemDec() {
        GildedRose app = createGildedRose("item", 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testBrieDec() {
        GildedRose app = createGildedRose(ItemFactory.AGED_BRIE, 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testBackstagePassesItemDec() {
        GildedRose app = createGildedRose(ItemFactory.BACKSTAGE_PASSES, 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testSulfurasItemDoesNotDec() {
        GildedRose app = createGildedRose(ItemFactory.SULFURAS, 0, 0);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
    }

    @Test
    public void conjuredItemDecr() {
        GildedRose app = createGildedRose(ItemFactory.CONJURED, 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testBrieIncreasesInQualityEachTime() {
        GildedRose app = createGildedRose(ItemFactory.AGED_BRIE, 1, 1);

        app.updateQuality();

        assertEquals(2, getQuality(app));
    }

    @Test
    public void testBrieQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = createGildedRose(ItemFactory.AGED_BRIE, 1, 49);

        app.updateQuality();
        app.updateQuality();

        assertEquals(50, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByOneIfMoreThanElevenDays() {
        GildedRose app = createGildedRose(ItemFactory.BACKSTAGE_PASSES, 12, 1);

        app.updateQuality();

        assertEquals(2, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByTwoIfLessThanElevenDays() {
        GildedRose app = createGildedRose(ItemFactory.BACKSTAGE_PASSES, 10, 1);

        app.updateQuality();

        assertEquals(3, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByThreeIfLessThanSix() {
        GildedRose app = createGildedRose(ItemFactory.BACKSTAGE_PASSES, 5, 1);

        app.updateQuality();

        assertEquals(4, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemQualityDropsToZeroIfHasPassed() {
        GildedRose app = createGildedRose(ItemFactory.BACKSTAGE_PASSES, 0, 50);

        app.updateQuality();

        assertEquals(0, getQuality(app));
    }

    @Test
    public void testNormalItemDecQualityByOneIfIsAboveZero() {
        GildedRose app = createGildedRose("foo", 2, 1);

        app.updateQuality();

        assertEquals(0, getQuality(app));
    }

    @Test
    public void testNormalItemDecQualityByTwoOnceHasPassed() {
        GildedRose app = createGildedRose("foo", 0, 5);

        app.updateQuality();

        assertEquals(3, getQuality(app));
    }

    @Test
    public void testNormalItemCannotHaveQualityBelowZero() {
        GildedRose app = createGildedRose("foo", 0, 0);

        app.updateQuality();

        assertEquals(0, getQuality(app));
    }

    @Test
    public void testNothingHappensToSulfurasItem() {
        GildedRose app = createGildedRose(ItemFactory.SULFURAS, 1, 1);

        app.updateQuality();

        assertEquals(1, getQuality(app));
        assertEquals(1, getSellIn(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByTwoIfSellByDayIsAboveZero() {
        GildedRose app = createGildedRose(ItemFactory.CONJURED, 2, 5);

        app.updateQuality();

        assertEquals(3, getQuality(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByFourOnceSellByDayIsZeroOrLess() {
        GildedRose app = createGildedRose(ItemFactory.CONJURED, 0, 5);

        app.updateQuality();

        assertEquals(1, getQuality(app));
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        GildedRose app = createGildedRose(ItemFactory.CONJURED, 0, 0);

        app.updateQuality();

        assertEquals(0, getQuality(app));
    }

    private int getSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int getQuality(GildedRose app) {
        return app.items[0].quality;
    }

    private GildedRose createGildedRose(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        return new GildedRose(items);
    }

}
