package algorithms;

import datastructures.List;

public class BubbleSort implements Sort {

    @Override
    public void sort(List list) {
        if (list.size() <= 1)
            return;

        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;

            for (int current = 0; current < size - 1 - i; current++) {
                int next = list.get(current + 1);

                if (list.get(current) > next) {
                    int valueToMove = list.get(current);
                    list.set(current, next);
                    list.set(current + 1, valueToMove);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}