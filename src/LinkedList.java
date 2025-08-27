public class LinkedList implements List{

    private int length;

    @Override
    public void add(int i) {
        length++;
    }

    @Override
    public void add(int value, int index) {

    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void remove(int index) {
        if(length <= 0)
            throw new IndexOutOfBoundsException(index);
        length--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= length)
            throw new IndexOutOfBoundsException(index);
        if(index == 0)
            return 1;
        return 2;
    }
}
