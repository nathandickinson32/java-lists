import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

abstract class CommonListTest {
    protected List list;

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
        assertEquals(1, list.get(0));
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
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
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
        assertEquals(1, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemovingFirstItemFromListOfTwo() {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemovingSecondItemFromListOfThree() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemovingItemFromListOfThree() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemovingItemFromListOfFour() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(0);
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
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
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(2, list.get(3));
    }

    @Test
    public void testAddToMiddleOfListWithIndex() {
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2, 1);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testAddMoreThanHundredItems() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        assertEquals(0, list.get(0));
        assertEquals(99, list.get(99));
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
        assertOutOfBounds(0, () -> list.set(0, 1));
    }

    @Test
    public void testSetNegativeIndex() {
        list.add(1);
        assertOutOfBounds(-1, () -> list.set(-1, 2));
    }

    @Test
    public void testSetOneItem() {
        list.add(1);
        list.set(0, 2);
        assertEquals(2, list.get(0));
    }

    @Test
    public void testSetTwoItems() {
        list.add(1);
        list.add(2);
        list.set(0, 3);
        list.set(1, 4);
        assertEquals(3, list.get(0));
        assertEquals(4, list.get(1));
    }

    @Test
    public void testSetDoesNotChangeSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(0, 4);
        list.set(1, 5);
        list.set(2, 6);
        int originalSize = list.size();
        assertEquals(originalSize, list.size());
    }

    private void assertOutOfBounds(int index, Runnable operation) {
        try {
            operation.run();
            fail("Expected IndexOutOfBoundsException but got nothing thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of range: " + index, e.getMessage());
        }
    }
}