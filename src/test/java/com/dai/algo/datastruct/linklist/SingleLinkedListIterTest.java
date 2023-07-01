package com.dai.algo.datastruct.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListIterTest {
    SingleLinkedListIter linkedList = new SingleLinkedListIter();
    @BeforeEach
    void setUp() {
            linkedList.addFirst(1);
            linkedList.addFirst(2);
            linkedList.addFirst(3);
            linkedList.addFirst(4);
            linkedList.addFirst(5);
            linkedList.addFirst(6);
    }

    @Test
    void iterator() {
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}