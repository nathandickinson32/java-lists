public interface List {
    void add(int i);
    void add(int i, int index);
    int size();
    void remove(int index);
    int get(int index) throws IndexOutOfBoundsException;
}