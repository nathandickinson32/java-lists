package datastructures;

public class HashMap<TKey, TValue> implements Map<TKey, TValue> {

    private int length;
    private ArrayList<LinkedList<Entry<TKey, TValue>>> buckets = new ArrayList<>();

    private static final double GROWTH_FACTOR = 0.75;

    public HashMap() {
        initBuckets(16);
    }

    private void initBuckets(int size) {
        for (int i = 0; i < size; i++) {
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
            for (int j = 0; j < bucket.size(); j++) {
                keys.add(bucket.get(j).key);
            }
        }
        return keys;
    }

    @Override
    public void put(TKey key, TValue value) throws IllegalArgumentException {
        assertKeyNotNull(key);
        expandMapIfNeeded();
        int bucketIdx = getBucketIdx(key);
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
        Entry<TKey, TValue> entry = findEntry(key);
        if (entry != null) {
            return entry.value;
        }
        throw new NullPointerException("Key does not exist: " + key);
    }

    @Override
    public void remove(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        int bucketIdx = getBucketIdx(key);
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key)) {
                bucket.remove(i);
                length--;
                return;
            }
        }
    }

    @Override
    public boolean containsKey(TKey key) throws IllegalArgumentException {
        assertKeyNotNull(key);
        Entry<TKey, TValue> entry = findEntry(key);
        return entry != null;
    }

    private Entry<TKey, TValue> findEntry(TKey key) {
        int bucketIdx = getBucketIdx(key);
        LinkedList<Entry<TKey, TValue>> bucket = buckets.get(bucketIdx);
        for (int i = 0; i < bucket.size(); i++) {
            if (key.equals(bucket.get(i).key)) {
                return bucket.get(i);
            }
        }
        return null;
    }

    private int getBucketIdx(TKey key) {
        return Math.abs(key.hashCode() % buckets.size());
    }

    private void expandMapIfNeeded() {
        if ((double) (length + 1) / buckets.size() > GROWTH_FACTOR) {
            resize();
        }
    }

    private void resize() {
        ArrayList<LinkedList<Entry<TKey, TValue>>> oldBuckets = buckets;
        buckets = new ArrayList<>();
        initBuckets(oldBuckets.size() * 2);
        length = 0;
        for (int i = 0; i < oldBuckets.size(); i++) {
            LinkedList<Entry<TKey, TValue>> bucket = oldBuckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                Entry<TKey, TValue> entry = bucket.get(j);
                put(entry.key, entry.value);
            }
        }
    }

    private void assertKeyNotNull(Object key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
    }
}