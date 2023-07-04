package com.dai.algo.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        int[] a = {8,4,6,9,3,1};
        for (int i : a) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        InsertionSort.sort(a);
        for (int i : a) {
            System.out.print(i);
            System.out.print("\t");
        }
    }
}