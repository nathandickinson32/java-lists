package algorithms;

import datastructures.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(List<T> list) {
        int length = list.size() - 1;
        for (int i = 0; i < length; i++) {
            for (int currentIndex = 0; currentIndex < length - i; currentIndex++) {
                int nextIndex = currentIndex + 1;
                if (list.get(currentIndex).compareTo(list.get(nextIndex)) > 0) {
                    list.swap(list, currentIndex, nextIndex);
                }
            }
        }
    }
}