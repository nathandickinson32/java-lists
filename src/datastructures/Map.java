package datastructures;

public interface Map<TKey, TValue> {

    int size();

    List<TKey> keys();

    void put(TKey key, TValue value) throws IllegalArgumentException;

    TValue get(TKey key) throws IllegalArgumentException;

    void remove(TKey key) throws IllegalArgumentException;

    boolean containsKey(TKey key) throws IllegalArgumentException;
}