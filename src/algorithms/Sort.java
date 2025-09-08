package algorithms;

import datastructures.List;

public interface Sort<T extends Comparable<T>> {
    void sort(List<T> list);
}