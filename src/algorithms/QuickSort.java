package algorithms;

import datastructures.List;

import static algorithms.Core.swap;

public class QuickSort implements Sort {

    @Override
    public void sort(List list) {
        quickSort(list, 0, list.size() - 1);
    }

    public static void quickSort(List list, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) {
            return;
        }

        int pivot = list.get(highIndex);
        int partitionIndex = partition(list, lowIndex, highIndex, pivot);

        quickSort(list, lowIndex, partitionIndex - 1);
        quickSort(list, partitionIndex + 1, highIndex);
    }

    private static int partition(List list, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (list.get(leftPointer) <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (list.get(rightPointer) >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(list, leftPointer, rightPointer);
        }
        swap(list, leftPointer, highIndex);
        return leftPointer;
    }
}