package algorithms;

import datastructures.List;

import static algorithms.Core.swap;

public class BubbleSort implements Sort {

    @Override
    public void sort(List list) {
        int length = list.size() - 1;
        for (int i = 0; i < length; i++) {

            for (int currentIndex = 0; currentIndex < length - i; currentIndex++) {
                int nextIndex = currentIndex + 1;
                if (list.get(currentIndex) > list.get(nextIndex)) {
                    swap(list, currentIndex, nextIndex);
                }
            }
        }
    }
}