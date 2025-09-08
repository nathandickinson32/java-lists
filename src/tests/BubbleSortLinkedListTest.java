package tests;

import algorithms.BubbleSort;
import datastructures.LinkedList;

public class BubbleSortLinkedListTest extends CommonSortTest {

    public BubbleSortLinkedListTest() {
        list = new LinkedList<Integer>();
        sorter = new BubbleSort<Integer>();
    }
}