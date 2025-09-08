package datastructures;

public interface List<T> {

    void add(T value);

    void add(T value, int index);

    int size();

    void remove(int index);

    T get(int index) throws IndexOutOfBoundsException;

    void swap(List<T> list, int index1, int index2);

    void set(T value, int index) throws IndexOutOfBoundsException;

    List<T> sublist(List<T> list, int start, int end) throws IndexOutOfBoundsException;
}