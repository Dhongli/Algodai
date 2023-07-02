package com.dai.algo.search;

import com.dai.algo.algorithm.search.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearch() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearch(a, 0, a.length - 1, 7));
        assertEquals(1, BinarySearch.binarySearch(a, 0, a.length - 1, 13));
        assertEquals(2, BinarySearch.binarySearch(a, 0, a.length - 1, 21));
        assertEquals(3, BinarySearch.binarySearch(a, 0, a.length - 1, 30));
        assertEquals(4, BinarySearch.binarySearch(a, 0, a.length - 1, 38));
        assertEquals(5, BinarySearch.binarySearch(a, 0, a.length - 1, 44));
        assertEquals(6, BinarySearch.binarySearch(a, 0, a.length - 1, 52));
        assertEquals(7, BinarySearch.binarySearch(a, 0, a.length - 1, 53));

        assertEquals(-1, BinarySearch.binarySearch(a, 0, a.length - 1, 0));
        assertEquals(-1, BinarySearch.binarySearch(a, 0, a.length - 1, 15));
        assertEquals(-1, BinarySearch.binarySearch(a, 0, a.length - 1, 60));

    }

    @Test
    void binarySearch2() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearch2(a, 7));
        assertEquals(1, BinarySearch.binarySearch2(a, 13));
        assertEquals(2, BinarySearch.binarySearch2(a, 21));
        assertEquals(3, BinarySearch.binarySearch2(a, 30));
        assertEquals(4, BinarySearch.binarySearch2(a, 38));
        assertEquals(5, BinarySearch.binarySearch2(a, 44));
        assertEquals(6, BinarySearch.binarySearch2(a, 52));
        assertEquals(7, BinarySearch.binarySearch2(a, 53));

        assertEquals(-1, BinarySearch.binarySearch2(a, 0));
        assertEquals(-1, BinarySearch.binarySearch2(a, 15));
        assertEquals(-1, BinarySearch.binarySearch2(a, 60));
    }

    @Test
    void binarySearchLeftMost() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, BinarySearch.binarySearchLeftMost(a, 1));
        assertEquals(1, BinarySearch.binarySearchLeftMost(a, 2));
        assertEquals(2, BinarySearch.binarySearchLeftMost(a, 4));
        assertEquals(5, BinarySearch.binarySearchLeftMost(a, 5));
        assertEquals(6, BinarySearch.binarySearchLeftMost(a, 6));
        assertEquals(7, BinarySearch.binarySearchLeftMost(a, 7));

        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 0));
        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 3));
        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 8));
    }

    @Test
    void binarySearchTi() {
    }
}