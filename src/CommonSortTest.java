import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonSortTest {
    protected Sort sorter = new BubbleSort();
    private List list = new ArrayList();

    @Test
    public void testEmptyArray() {
        sorter.sort(list);
        assertEquals(0, list.size());
    }

    @Test
    public void testOneItem() {
        list.add(1);
        sorter.sort(list);
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAlreadySorted() {
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testTwoItemsOutOfOrder() {
        list.add(2);
        list.add(1);
        sorter.sort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testThreeItemsOutOfOrder() {
        list.add(3);
        list.add(2);
        list.add(1);
        sorter.sort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testWithDuplicates() {
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        sorter.sort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(3, list.get(4));
    }

    @Test
    public void testWithNegatives() {
        list.add(1);
        list.add(-2);
        list.add(0);
        list.add(-1);
        sorter.sort(list);
        assertEquals(-2, list.get(0));
        assertEquals(-1, list.get(1));
        assertEquals(0, list.get(2));
        assertEquals(1, list.get(3));
    }
}
