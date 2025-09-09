package datastructures;

public class Entry<TKey, TValue> {
    TKey key;
    TValue value;

    Entry(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }
}
