package datastructures;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    private static final int GROWTH_FACTOR = 100;
    private Object[] array = new Object[GROWTH_FACTOR];
    private int length;

    @Override
    public void add(T value) {
        expandIfFull();
        array[length] = value;
        length++;
    }

    @Override
    public void add(T value, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length)
            throw new IndexOutOfBoundsException(index);

        expandIfFull();
        for (int i = length; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
        length++;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        length--;
        for (int i = index; i < length; i++)
            array[i] = array[i + 1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        return (T) array[index];
    }

    @Override
    public void swap(List<T> list, int index1, int index2) {
        T tempValue = list.get(index1);
        list.set(list.get(index2), index1);
        list.set(tempValue, index2);
    }

    @Override
    public void set(T value, int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        array[index] = value;
    }

    @Override
    public List<T> sublist(List<T> list, int start, int end) throws IndexOutOfBoundsException {
        assertInRangeOfRange(list, start, end);

        ArrayList<T> subList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            subList.add(list.get(i));
        }
        return subList;
    }

    private static <T> void assertInRangeOfRange(List<T> list, int start, int end) {
        if (start < 0 || end > list.size() || start > end) {
            throw new IndexOutOfBoundsException("Index out of range: " + start + " to " + end);
        }
    }

    private void assertInRange(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
    }

    private void expandIfFull() {
        if (length == array.length) {
            array = Arrays.copyOf(array, array.length + GROWTH_FACTOR);
        }
    }
}