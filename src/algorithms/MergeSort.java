package algorithms;

import datastructures.List;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(List<T> list) {
        int length = list.size();

        if (length < 2) {
            return;
        }

        int centerIndex = length / 2;

        List<T> leftHalf = list.sublist(list, 0, centerIndex);
        List<T> rightHalf = list.sublist(list, centerIndex, length);

        sort(leftHalf);
        sort(rightHalf);
        merge(list, leftHalf, rightHalf);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> leftHalf, List<T> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHalf.get(leftIndex).compareTo(rightHalf.get(rightIndex)) <= 0) {
                list.set(leftHalf.get(leftIndex), mergeIndex);
                leftIndex++;
            } else {
                list.set(rightHalf.get(rightIndex), mergeIndex);
                rightIndex++;
            }
            mergeIndex++;
        }

        addRemainingValues(list, mergeIndex, leftIndex, leftSize, leftHalf);
        addRemainingValues(list, mergeIndex, rightIndex, rightSize, rightHalf);
    }

    private static <T extends Comparable<T>> void addRemainingValues(
            List<T> list,
            int mergeIndex,
            int index,
            int size,
            List<T> halfList) {
        while (index < size) {
            list.set(halfList.get(index), mergeIndex);
            index++;
            mergeIndex++;
        }
    }
}