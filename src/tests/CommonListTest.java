package tests;

import datastructures.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

abstract class CommonListTest {
    protected List<Integer> list;

    @Test
    public void testNewListSize() {
        assertEquals(0, list.size());
    }

    @Test
    public void testAddOneItemToList() {
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddTwoItemsToList() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testGetItemInEmptyList() {
        assertOutOfBounds(0, () -> list.get(0));
    }

    @Test
    public void testGetFirstItemInList() {
        list.add(1);
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void testGetItemOutOfBounds() {
        list.add(1);
        assertOutOfBounds(1, () -> list.get(1));
    }

    @Test
    public void testGetSecondItemInList() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
    }

    @Test
    public void testGettingNegativeIndex() {
        list.add(1);
        assertOutOfBounds(-1, () -> list.get(-1));
    }

    @Test
    public void testRemoveItemFromEmptyList() {
        assertOutOfBounds(0, () -> list.remove(0));
    }

    @Test
    public void testRemovingFirstItem() {
        list.add(1);
        list.remove(0);
        assertOutOfBounds(0, () -> list.get(0));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemovingSecondItem() {
        list.add(1);
        list.add(2);
        list.remove(1);
        assertEquals(1, list.get(0).intValue());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemovingFirstItemFromListOfTwo() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0).intValue());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemovingSecondItemFromListOfThree() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemovingItemFromListOfThree() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        assertEquals(2, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemovingItemFromListOfFour() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(0);
        assertEquals(2, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(4, list.get(2).intValue());
        assertEquals(3, list.size());
    }

    @Test
    public void testRemovingNegativeIndex() {
        assertOutOfBounds(-1, () -> list.remove(-1));
    }

    @Test
    public void testAddingToNegativeIndex() {
        assertOutOfBounds(-1, () -> list.add(1, -1));
    }

    @Test
    public void testAddToEndOfListWithIndex() {
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2, 3);
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(4, list.get(2).intValue());
        assertEquals(2, list.get(3).intValue());
    }

    @Test
    public void testAddToMiddleOfListWithIndex() {
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2, 1);
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());
        assertEquals(4, list.get(3).intValue());
    }

    @Test
    public void testAddMoreThanHundredItems() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        assertEquals(0, list.get(0).intValue());
        assertEquals(99, list.get(99).intValue());
        list.add(100);
        assertEquals(101, list.size());
    }

    @Test
    public void testAdd1000ItemsToEnd() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void testAdd1000ItemsToFront() {
        for (int i = 1000; i > 0; i--) {
            list.add(i, 0);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void testAdd1000ItemsToMiddle() {
        list.add(1);
        list.add(10000);
        for (int i = (list.size() / 2); i < 9999; i++) {
            list.add(i, 1);
        }
        assertEquals(10000, list.size());
    }

    @Test
    public void testSetOnEmptyList() {
        assertOutOfBounds(0, () -> list.set(1, 0));
    }

    @Test
    public void testSetNegativeIndex() {
        list.add(1);
        assertOutOfBounds(-1, () -> list.set(2, -1));
    }

    @Test
    public void testSetOneItem() {
        list.add(1);
        list.set(2, 0);
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void testSetTwoItems() {
        list.add(1);
        list.add(2);
        list.set(3, 0);
        list.set(4, 1);
        assertEquals(3, list.get(0).intValue());
        assertEquals(4, list.get(1).intValue());
    }

    @Test
    public void testSetDoesNotChangeSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(4, 0);
        list.set(5, 1);
        list.set(6, 2);
        assertEquals(3, list.size());
    }

    @Test
    public void testSwapOnEmptyList() {
        assertOutOfBounds(0, () -> list.swap(list, 0, 1));
    }

    @Test
    public void testSwapWithNegativeIndex() {
        list.add(1);
        list.add(2);
        assertOutOfBounds(-1, () -> list.swap(list, -1, 1));
    }

    @Test
    public void testSwapWithIndexTooLarge() {
        list.add(1);
        list.add(2);
        assertOutOfBounds(2, () -> list.swap(list, 0, 2));
    }

    @Test
    public void testSwapOneItemWithItself() {
        list.add(1);
        list.swap(list, 0, 0);
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void testSwapTwoItems() {
        list.add(1);
        list.add(2);
        int originalSize = list.size();
        list.swap(list, 0, 1);
        assertEquals(2, list.get(0).intValue());
        assertEquals(1, list.get(1).intValue());
        assertEquals(originalSize, list.size());
    }

    @Test
    public void testSublistStartNegative() {
        list.add(1);
        list.add(2);
        assertOutOfBoundsRange(-1, 1, () -> list.sublist(list, -1, 1));
    }

    @Test
    public void testSublistEndTooLarge() {
        list.add(1);
        list.add(2);
        assertOutOfBoundsRange(0, 3, () -> list.sublist(list, 0, 3));
    }

    @Test
    public void testSublistStartGreaterThanEnd() {
        list.add(1);
        list.add(2);
        assertOutOfBoundsRange(2, 1, () -> list.sublist(list, 2, 1));
    }

    @Test
    public void testSublistOnEmptyList() {
        List<Integer> sub = list.sublist(list, 0, 0);
        assertEquals(0, sub.size());
    }

    @Test
    public void testSublistStartEqualsEnd() {
        list.add(1);
        List<Integer> sub = list.sublist(list, 0, 0);
        assertEquals(0, sub.size());
    }

    @Test
    public void testSublistSingleElement() {
        list.add(10);
        List<Integer> sub = list.sublist(list, 0, 1);
        assertEquals(1, sub.size());
        assertEquals(10, sub.get(0).intValue());
    }

    @Test
    public void testSublistMultipleElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> sub = list.sublist(list, 1, 3);
        assertEquals(2, sub.size());
        assertEquals(2, sub.get(0).intValue());
        assertEquals(3, sub.get(1).intValue());
    }

    @Test
    public void testSublistFullList() {
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> sub = list.sublist(list, 0, list.size());
        assertEquals(list.size(), sub.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).intValue(), sub.get(i).intValue());
        }
    }

    private void assertOutOfBounds(int index, Runnable operation) {
        try {
            operation.run();
            fail("Expected IndexOutOfBoundsException but got nothing thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range: " + index, e.getMessage());
        }
    }

    private void assertOutOfBoundsRange(int start, int end, Runnable operation) {
        try {
            operation.run();
            fail("Expected IndexOutOfBoundsException but got nothing thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range: " + start + " to " + end, e.getMessage());
        }
    }
}