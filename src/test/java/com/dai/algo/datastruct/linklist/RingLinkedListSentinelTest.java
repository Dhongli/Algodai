package com.dai.algo.datastruct.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RingLinkedListSentinelTest {

    RingLinkedListSentinel ringLinkedListSentinel;

    @BeforeEach
    void setUp() {
        ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);
        ringLinkedListSentinel.addFirst(5);
    }

    @Test
    void addFirst() {
        ringLinkedListSentinel.addFirst(6);
        print();
    }

    private void print() {
        Iterator<Integer> iterator = ringLinkedListSentinel.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("\t");
        }
        System.out.println();
    }

    @Test
    void addLast() {
        ringLinkedListSentinel.addLast(8);
        print();
    }

    @Test
    void removeFirst() {
        ringLinkedListSentinel.removeFirst();
        print();
        ringLinkedListSentinel.removeFirst();
        print();
        ringLinkedListSentinel.removeFirst();
        print();
        ringLinkedListSentinel.removeFirst();
        print();
        ringLinkedListSentinel.removeFirst();
        print();
        assertThrows(IllegalArgumentException.class, () -> ringLinkedListSentinel.removeFirst());
    }

    @Test
    void removeLast() {
        ringLinkedListSentinel.removeLast();
        print();
        ringLinkedListSentinel.removeLast();
        print();
        ringLinkedListSentinel.removeLast();
        print();
        ringLinkedListSentinel.removeLast();
        print();
        ringLinkedListSentinel.removeLast();
        print();
        assertThrows(IllegalArgumentException.class, () -> ringLinkedListSentinel.removeLast());
    }

    @Test
    void removeByValue() {
        ringLinkedListSentinel.removeByValue(1);
        print();
        ringLinkedListSentinel.removeByValue(4);
        print();

        ringLinkedListSentinel.removeByValue(8);
        print();
    }

    @Test
    void iterator() {
        print();
    }
}