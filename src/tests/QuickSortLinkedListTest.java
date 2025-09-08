package tests;

import algorithms.QuickSort;
import datastructures.LinkedList;

public class QuickSortLinkedListTest extends CommonSortTest {

    public QuickSortLinkedListTest() {
        list = new LinkedList<Integer>();
        sorter = new QuickSort<Integer>();
    }
}