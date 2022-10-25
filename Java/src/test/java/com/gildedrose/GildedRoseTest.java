package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
        GildedRose app = createGildedRose("Aged Brie", 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testBackstagePassesItemDec() {
        GildedRose app = createGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 0);

        app.updateQuality();

        assertEquals(-1, getSellIn(app));
    }

    @Test
    public void testSulfurasItemDoesNotDec() {
        GildedRose app = createGildedRose("Sulfuras, Hand of Ragnaros", 0, 0);

        app.updateQuality();

        assertEquals(0, getSellIn(app));
    }

    @Test
    public void testBrieIncreasesInQualityEachTime() {
        GildedRose app = createGildedRose("Aged Brie", 1, 1);

        app.updateQuality();

        assertEquals(2, getQuality(app));
    }

    @Test
    public void testBrieQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = createGildedRose("Aged Brie", 1, 49);

        app.updateQuality();
        app.updateQuality();

        assertEquals(50, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByOneIfMoreThanElevenDays() {
        GildedRose app = createGildedRose("Backstage passes to a TAFKAL80ETC concert", 12, 1);

        app.updateQuality();

        assertEquals(2, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByTwoIfLessThanElevenDays() {
        GildedRose app = createGildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 1);

        app.updateQuality();

        assertEquals(3, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemDecQualityByThreeIfLessThanSix() {
        GildedRose app = createGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 1);

        app.updateQuality();

        assertEquals(4, getQuality(app));
    }

    @Test
    public void testBackstagePassesItemQualityDropsToZeroIfHasPassed() {
        GildedRose app = createGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 50);

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
        GildedRose app = createGildedRose("Sulfuras, Hand of Ragnaros", 1, 1);

        app.updateQuality();

        assertEquals(1, getQuality(app));
        assertEquals(1, getSellIn(app));
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
