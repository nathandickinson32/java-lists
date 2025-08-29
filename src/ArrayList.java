public class ArrayList implements List {

    private int[] array = new int[100];

    private int size;

    @Override
    public void add(int i) {
        expandIfFull();
        array[size] = i;
        size++;
    }

    @Override
    public void add(int value, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index);

        expandIfFull();
        for (int i = size; i > index; i--)
            array[i] = array[i - 1];
        array[index] = value;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        size--;
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        return array[index];
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        assertInRange(index);
        array[index] = value;
    }

    private void assertInRange(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(index);
    }

    private void expandIfFull() {
        if (size == array.length) {
            int[] newArray = new int[array.length + 100];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}