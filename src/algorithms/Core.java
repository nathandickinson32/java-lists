package algorithms;

import datastructures.List;

public class Core {

    public static void swap(List list, int index1, int index2) {
        int tempValue = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tempValue);
    }
}