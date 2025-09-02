package datastructures;

public interface List {

    void add(int value);

    void add(int value, int index);

    int size();

    void remove(int index);

    int get(int index) throws IndexOutOfBoundsException;

    void set(int index, int value) throws IndexOutOfBoundsException;
}