package tests;

import datastructures.HashMap;
import datastructures.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    protected HashMap map = new HashMap();

    @Test
    public void testNewMapSize() {
        assertEquals(0, map.size());
    }

    @Test
    public void testPutNullKey() {
        assertIllegalArg(() -> map.put(null, 1));
    }

    @Test
    public void testPutOneItemInMap() {
        map.put("test", 1);
        assertEquals(1, map.size());
    }

    @Test
    public void testPutTwoItemsInMap() {
        map.put("test1", 1);
        map.put("test2", 2);
        assertEquals(2, map.size());
    }

    @Test
    public void testGetNullKey() {
        assertIllegalArg(() -> map.get(null));
    }

    @Test
    public void testGetItemInEmptyMap() {
        assertNullPointer(() -> map.get("test"), "test");
    }

    @Test
    public void testGetItemNotInMap() {
        map.put("Fail", 1);
        assertNullPointer(() -> map.get("test"), "test");
    }

    @Test
    public void testGetOneItem() {
        map.put("test", 1);
        assertEquals(1, map.get("test"));
    }

    @Test
    public void testContainsNullKey() {
        assertIllegalArg(() -> map.containsKey(null));
    }

    @Test
    public void testContainsKeyOnEmptyMap() {
        assertFalse(map.containsKey("test"));
    }

    @Test
    public void testContainsKeySingleItem() {
        map.put("test", 1);
        assertTrue(map.containsKey("test"));
    }

    @Test
    public void testRemoveNullKeyThrows() {
        assertIllegalArg(() -> map.remove(null));
    }

    @Test
    public void testRemoveItemFromEmptyList() {
        map.remove("test");
        assertEquals(0, map.size());
    }

    @Test
    public void testRemoveItemFromListOfOne() {
        map.put("test", 1);
        map.remove("test");
        assertEquals(0, map.size());
        assertFalse(map.containsKey("test"));
    }

    @Test
    public void testGetKeysFromEmptyList() {
        assertEquals(0, map.keys().size());
    }

    @Test
    public void testGetKeysFromListOfOne() {
        map.put("test", 1);
        assertEquals(1, map.keys().size());
        assertEquals("test", map.keys().get(0));
    }


    @Test
    public void testGetFirstInsert() {
        map.put("test1", 1);
        map.put("test2", 2);
        assertEquals(1, map.get("test1"));
    }

    @Test
    public void testGetMultipleItems() {
        map.put("test1", 1);
        map.put("test2", 2);
        assertEquals(2, map.get("test2"));
        assertEquals(1, map.get("test1"));
    }

    @Test
    public void testContainsKeyMultipleItemList() {
        map.put("test1", 1);
        map.put("test2", 2);
        assertTrue(map.containsKey("test1"));
        assertTrue(map.containsKey("test2"));
    }

    @Test
    public void testRemoveFirstItemInTwo() {
        map.put("test1", 1);
        map.put("test2", 2);
        map.remove("test1");
        assertEquals(1, map.size());
        assertFalse(map.containsKey("test1"));
        assertTrue(map.containsKey("test2"));
    }

    @Test
    public void testKeysMultipleItems() {
        map.put("test1", 1);
        map.put("test2", 2);
        List keys = map.keys();
        assertEquals("test1", keys.get(0));
        assertEquals("test2", keys.get(1));
    }

    @Test
    public void testOverwriteExistingKey() {
        map.put("test", 1);
        map.put("test", 2);
        assertEquals(1, map.size());
        assertEquals(2, map.get("test"));
    }

    private void assertNullPointer(Runnable operation, Object key) {
        try {
            operation.run();
            fail("Expected NullPointerException but got nothing thrown");
        } catch (NullPointerException e) {
            assertEquals("Key does not exist: " + key, e.getMessage());
        }
    }

    private void assertIllegalArg(Runnable operation) {
        try {
            operation.run();
            fail("Expected IllegalArgumentException but got nothing thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Key cannot be null", e.getMessage());
        }
    }
}