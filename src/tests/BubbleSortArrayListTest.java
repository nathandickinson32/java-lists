package tests;

import algorithms.BubbleSort;
import datastructures.ArrayList;

public class BubbleSortArrayListTest extends CommonSortTest {

    public BubbleSortArrayListTest() {
        list = new ArrayList();
        sorter = new BubbleSort();
    }
}