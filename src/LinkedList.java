public class LinkedList implements List {

    private int length;
    private Node head;

    @Override
    public void add(int value) {
        add(value, length);
    }

    @Override
    public void add(int value, int index) {
        assertInRangeAddIndex(index);

        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
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
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        length--;
    }

    @Override
    public int get(int index) {
        assertInRange(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        assertInRange(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    private void assertInRange(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
    }

    private void assertInRangeAddIndex(int index) {
        if (index < 0 || index > length)
            throw new IndexOutOfBoundsException("Index out of range: " + index);
    }
}
