package datastructures;

public class HashMap<TKey, TValue> implements Map<TKey, TValue> {

    private int length;
    private ArrayList<LinkedList<Entry<TKey, TValue>>> buckets = new ArrayList<>();

    public HashMap() {
        for (int i = 0; i < 100; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public List<TKey> keys() {
        ArrayList<TKey> keys = new ArrayList<>();
        for (int i = 0; i < buckets.size(); i++) {
            LinkedList<Entry<TKey, TValue>> bucket = buckets.get(i);
            for (int j = 0; j < buckets.get(i).size(); j++) {
                keys.add(bucket.get(j).key);
            }
        }
        return keys;
    }

    @Override
    public void put(TKey key, TValue value) throws IllegalArgumentException {
        assertKeyNotNull(key);
        int bucketIdx = Math.abs(key.hashCode() % buckets.size());
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        boolean isPresent = false;
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key)) {
                bucket.set(new Entry<>(key, value), i);
                isPresent = true;
            }
        }
        if (!isPresent) {
            bucket.add(new Entry<>(key, value));
            length++;
        }
    }

    @Override
    public TValue get(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        int bucketIdx = Math.abs(key.hashCode() % buckets.size());
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key))
                return bucket.get(i).value;
        }
        throw new NullPointerException("Key does not exist: " + key);
    }

    @Override
    public void remove(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        int bucketIdx = Math.abs(key.hashCode() % buckets.size());
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key)) {
                bucket.remove(i);
                length--;
            }
        }
    }

    @Override
    public boolean containsKey(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        int bucketIdx = Math.abs(key.hashCode() % buckets.size());
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key)) {
                return true;
            }
        }
        return false;
    }

    private void assertKeyNotNull(Object key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
    }
}