package algorithms;

import datastructures.List;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    private static final Random rand = new Random();

    @Override
    public void sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<T> list, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = rand.nextInt(highIndex - lowIndex + 1) + lowIndex;
        T pivotValue = list.get(pivotIndex);
        list.swap(list, pivotIndex, highIndex);

        int partitionIndex = partition(list, lowIndex, highIndex, pivotValue);
        quickSort(list, lowIndex, partitionIndex - 1);
        quickSort(list, partitionIndex + 1, highIndex);
    }

    private int partition(List<T> list, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (list.get(leftPointer).compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (list.get(rightPointer).compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            list.swap(list, leftPointer, rightPointer);
        }

        list.swap(list, leftPointer, highIndex);
        return leftPointer;
    }
}