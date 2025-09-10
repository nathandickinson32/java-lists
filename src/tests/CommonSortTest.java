package tests;

import algorithms.Sort;
import datastructures.List;
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public abstract class CommonSortTest {
    protected Sort<Integer> sorter;
    protected List<Integer> list;
    private final Random RANDOM = new Random();

    private void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testEmptyArray() {
        sorter.sort(list);
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testAlreadySorted() {
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void testTwoItemsOutOfOrder() {
        list.add(2);
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
    }

    @Test
    public void testThreeItemsOutOfOrder() {
        list.add(3);
        list.add(2);
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void testTenItemsOutOfOrder() {
        list.add(9);
        list.add(10);
        list.add(7);
        list.add(8);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
        Assert.assertEquals(4, list.get(3).intValue());
        Assert.assertEquals(5, list.get(4).intValue());
        Assert.assertEquals(6, list.get(5).intValue());
        Assert.assertEquals(7, list.get(6).intValue());
        Assert.assertEquals(8, list.get(7).intValue());
        Assert.assertEquals(9, list.get(8).intValue());
        Assert.assertEquals(10, list.get(9).intValue());
    }

    @Test
    public void testWithDuplicates() {
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        Assert.assertEquals(1, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(2, list.get(2).intValue());
        Assert.assertEquals(3, list.get(3).intValue());
        Assert.assertEquals(3, list.get(4).intValue());
    }

    @Test
    public void testWithNegatives() {
        list.add(1);
        list.add(-2);
        list.add(0);
        list.add(-1);
        sorter.sort(list);
        Assert.assertEquals(-2, list.get(0).intValue());
        Assert.assertEquals(-1, list.get(1).intValue());
        Assert.assertEquals(0, list.get(2).intValue());
        Assert.assertEquals(1, list.get(3).intValue());
    }

    @Test
    public void test1000RandomNumbers() {
        for (int i = 0; i < 1000; i++) {
            list.add(RANDOM.nextInt(1000));
        }

        sorter.sort(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                Assert.fail("List is not sorted at index " + i);
            }
        }
    }
}