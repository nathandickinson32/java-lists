package datastructures;

public interface Map<TKey, TValue> {

    int size();

    List<TKey> keys();

    void put(TKey key, TValue value);

    TValue get(TKey key);

    void remove(TKey key);

    boolean containsKey(TKey key);
}