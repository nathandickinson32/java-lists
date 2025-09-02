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
        List leftHalf = new LinkedList();
        List rightHalf = new LinkedList();

        for (int i = 0; i < centerIndex; i++) {
            leftHalf.add(list.get(i));
        }

        for (int i = centerIndex; i < length; i++) {
            rightHalf.add(list.get(i));
        }

        sort(leftHalf);
        sort(rightHalf);

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

        while (leftIndex < leftSize) {
            list.set(mergeIndex, leftHalf.get(leftIndex));
            leftIndex++;
            mergeIndex++;
        }

        while (rightIndex < rightSize) {
            list.set(mergeIndex, rightHalf.get(rightIndex));
            rightIndex++;
            mergeIndex++;
        }
    }
}
