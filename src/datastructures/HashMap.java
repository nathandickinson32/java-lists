package datastructures;

public class HashMap implements Map {

    private int length;
    private List<Entry> entries = new ArrayList<>();

    @Override
    public int size() {
        return length;
    }

    @Override
    public List keys() {
        ArrayList keys = new ArrayList();
        for (int i = 0; i < entries.size(); i++) {
            keys.add(entries.get(i).key);
        }
        return keys;
    }

    @Override
    public void put(Object key, Object value) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry(key, value));
        length++;
    }

    @Override
    public Object get(Object key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        throw new NullPointerException("Key does not exist: " + key);
    }

    @Override
    public void remove(Object key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                entries.remove(i);
                length--;
            }
        }
    }

    @Override
    public boolean containsKey(Object key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private void assertKeyNotNull(Object key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
    }
}