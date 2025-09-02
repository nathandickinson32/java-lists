package tests;

import algorithms.QuickSort;
import datastructures.LinkedList;

public class QuickSortLinkedListTest extends CommonSortTest {

    public QuickSortLinkedListTest() {
        list = new LinkedList();
        sorter = new QuickSort();
    }
}