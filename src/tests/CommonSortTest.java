package tests;

import algorithms.Sort;
import datastructures.List;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public abstract class CommonSortTest {
    protected Sort sorter;
    protected List list;
    private Random random = new Random();

    private void printList(List list) {
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

    @Test
    public void test1000RandomNumbers() {
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(1000));
        }

//        System.out.println("Before:");
//        printList(list);

        sorter.sort(list);
//        System.out.println("*************************************************");
//        System.out.println("After:");
//        printList(list);
    }
}