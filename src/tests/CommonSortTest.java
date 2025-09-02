package tests;

import algorithms.Sort;
import datastructures.List;
import org.junit.Assert;
import org.junit.Test;

public abstract class CommonSortTest {
    protected Sort sorter;
    protected List list;

    @Test
    public void testEmptyArray() {
        sorter.sort(list);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testOneItem() {
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void testAlreadySorted() {
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(3, list.get(2));
    }

    @Test
    public void testTwoItemsOutOfOrder() {
        list.add(2);
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(2, list.get(1));
    }

    @Test
    public void testThreeItemsOutOfOrder() {
        list.add(3);
        list.add(2);
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(3, list.get(2));
    }

    @Test
    public void testWithDuplicates() {
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(2, list.get(2));
        Assert.assertEquals(3, list.get(3));
        Assert.assertEquals(3, list.get(4));
    }

    @Test
    public void testWithNegatives() {
        list.add(1);
        list.add(-2);
        list.add(0);
        list.add(-1);
        sorter.sort(list);
        Assert.assertEquals(-2, list.get(0));
        Assert.assertEquals(-1, list.get(1));
        Assert.assertEquals(0, list.get(2));
        Assert.assertEquals(1, list.get(3));
    }
}