public class LinkedList implements List {

    private int length;
    private Node head;

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
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
    public void add(int value, int index) {

    }

    private void assertInRange(int index) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
    }
}
