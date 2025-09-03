package algorithms;

import datastructures.ArrayList;
import datastructures.LinkedList;
import datastructures.List;

public class MergeSort implements Sort {

    @Override
    public void sort(List list) {
        int length = list.size();

        if (length < 2) {
            return;
        }

        int centerIndex = list.size() / 2;

        // works with both Linked and Array
        List leftHalf = new LinkedList();
        List rightHalf = new LinkedList();

//        List leftHalf = new ArrayList();
//        List rightHalf = new ArrayList();

        for (int i = 0; i < centerIndex; i++) {
            leftHalf.add(list.get(i));
        }

        for (int i = centerIndex; i < length; i++) {
            rightHalf.add(list.get(i));
        }

        sort(leftHalf);
        sort(rightHalf);
        merge(list,leftHalf, rightHalf);
    }

    public static void merge(List list, List leftHalf, List rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHalf.get(leftIndex) <= rightHalf.get(rightIndex)) {
                list.set(mergeIndex, leftHalf.get(leftIndex));
                leftIndex++;
            } else {
                list.set(mergeIndex, rightHalf.get(rightIndex));
                rightIndex++;
            }
            mergeIndex++;
        }
        addRemainingValues(list, mergeIndex, leftIndex, leftSize, leftHalf);
        addRemainingValues(list, mergeIndex, rightIndex, rightSize, rightHalf);
    }

    private static void addRemainingValues(List list, int mergeIndex, int index, int size, List halfList) {
        while (index < size) {
            list.set(mergeIndex, halfList.get(index));
            index++;
            mergeIndex++;
        }
    }
}