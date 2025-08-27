public class ArrayList implements List {

    private int[] array = new int[100];

    private int length;

    @Override
    public void add(int i) {
        expandIfFull();
        array[length] = i;
        length++;
    }

    @Override
    public void add(int i, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length)
            throw new IndexOutOfBoundsException(index);

        expandIfFull();
        for (int j = length; j > index; j--)
            array[j] = array[j - 1];
        array[index] = i;
        length++;
    }

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
    public int get(int index) throws IndexOutOfBoundsException {
        assertInRange(index);
        return array[index];
    }

    private void assertInRange(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(index);
    }

    private void expandIfFull() {
        if (length == array.length) {
            int[] newArray = new int[array.length + 100];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
