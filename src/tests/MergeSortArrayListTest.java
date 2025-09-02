package tests;

import algorithms.MergeSort;
import datastructures.ArrayList;

public class MergeSortArrayListTest extends CommonSortTest {

    public MergeSortArrayListTest() {
        list = new ArrayList();
        sorter = new MergeSort();
    }
}