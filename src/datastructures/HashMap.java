package datastructures;

public class HashMap<TKey, TValue> implements Map<TKey, TValue> {

    private int length;
    private List<Entry<TKey, TValue>> entries = new ArrayList<>();

    @Override
    public int size() {
        return length;
    }

    @Override
    public List<TKey> keys() {
        ArrayList<TKey> keys = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            keys.add(entries.get(i).key);
        }
        return keys;
    }

    @Override
    public void put(TKey key, TValue value) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry<TKey, TValue> entry = entries.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry<>(key, value));
        length++;
    }

    @Override
    public TValue get(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry<TKey, TValue> entry = entries.get(i);
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        throw new NullPointerException("Key does not exist: " + key);
    }

    @Override
    public void remove(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry<TKey, TValue> entry = entries.get(i);
            if (entry.key.equals(key)) {
                entries.remove(i);
                length--;
            }
        }
    }

    @Override
    public boolean containsKey(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        for (int i = 0; i < entries.size(); i++) {
            Entry<TKey, TValue> entry = entries.get(i);
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