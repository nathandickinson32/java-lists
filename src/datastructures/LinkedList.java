package datastructures;

public class LinkedList<T> implements List<T> {

    private int length;
    private Node<T> head;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void add(T value) {
        add(value, length);
    }

    @Override
    public void add(T value, int index) {
        assertInRangeAddIndex(index);

        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = nodeAt(index - 1);
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }

    @Override
    public void remove(int index) {
        assertInRange(index);

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = nodeAt(index - 1);
            current.next = current.next.next;
        }
        length--;
    }

    @Override
    public T get(int index) {
        return nodeAt(index).value;
    }

    @Override
    public void swap(List<T> list, int index1, int index2) {
        T tempValue = list.get(index1);
        list.set(list.get(index2), index1);
        list.set(tempValue, index2);
    }

    @Override
    public int size() {
        return length;
    }

    private Node<T> nodeAt(int index) {
        assertInRange(index);
        Node<T> current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(T value, int index) throws IndexOutOfBoundsException {
        nodeAt(index).value = value;
    }

    @Override
    public List<T> sublist(List<T> list, int start, int end) throws IndexOutOfBoundsException {
        assertInRangeOfRange(list, start, end);

        LinkedList<T> subList = new LinkedList<>();
        for (int i = start; i < end; i++) {
            subList.add(list.get(i));
        }
        return subList;
    }

    private void assertInRange(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private void assertInRangeAddIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    private static <T> void assertInRangeOfRange(List<T> list, int start, int end) {
        if (start < 0 || end > list.size() || start > end) {
            throw new IndexOutOfBoundsException("Index out of range: " + start + " to " + end);
        }
    }
}