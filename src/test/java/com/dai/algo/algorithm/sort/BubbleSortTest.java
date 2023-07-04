package com.dai.algo.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubbleSortDigui() {
        int[] ints = {6, 3, 7, 1, 2, 1};
        BubbleSort.bubbleSortDigui(ints);
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print("\t");
        }
    }
}