package algorithms;

import datastructures.List;

import static algorithms.Core.swap;

public class BubbleSort implements Sort {

    @Override
    public void sort(List list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {

            for (int current = 0; current < size - 1 - i; current++) {

                int next = current + 1;
                if (list.get(current) > list.get(next)) {
                    swap(list, current, next);

                }
            }
        }
    }
}