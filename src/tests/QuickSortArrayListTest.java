package tests;

import algorithms.QuickSort;
import datastructures.ArrayList;

public class QuickSortArrayListTest extends CommonSortTest {

    public QuickSortArrayListTest() {
        list = new ArrayList();
        sorter = new QuickSort();
    }
}