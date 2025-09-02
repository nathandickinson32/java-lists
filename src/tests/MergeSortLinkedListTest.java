package tests;

import algorithms.MergeSort;
import datastructures.LinkedList;

public class MergeSortLinkedListTest extends CommonSortTest{

    public MergeSortLinkedListTest() {
        list = new LinkedList();
        sorter = new MergeSort();
    }
}
