package com.dai.algo.algorithm.erchashu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibnaTest {
    // 1,1,2,3,5,8,13,21,34,55,89
    // 0,1,2,3,4,5, 6, 7, 8, 9,10
    @Test
    void getFibDigui() {
        assertEquals(89, Fibna.getFibDigui(10));
    }

    @Test
    void getFibDiguiV2() {
        assertEquals(89, Fibna.getFibDigui(10));
    }
}