package com.dai.algo.datastruct.linklist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {
    SingleLinkedList linkedList = new SingleLinkedList();

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
    void addFirst() {

    }

    @Test
    void loopWhile() {
        // linkedList.loop((value) -> System.out.println(value));
        linkedList.loopWhile(System.out::println);
    }

    @Test
    void loopFor() {
        linkedList.loopFor(System.out::println);
    }

    @Test
    void addLast() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.loopWhile(System.out::println);
    }

    @Test
    void addLastMore() {
        linkedList.addLast(1, 2, 3, 4, 5);
        linkedList.loopFor(System.out::println);
    }

    @Test
    void get() {
        assertEquals(6, linkedList.get(0));
        assertEquals(5, linkedList.get(1));
        assertEquals(4, linkedList.get(2));
        assertEquals(3, linkedList.get(3));
        assertEquals(2, linkedList.get(4));
        assertEquals(1, linkedList.get(5));
        assertThrows(IllegalArgumentException.class, () -> linkedList.get(6));
    }

    @Test
    void insert() {
        assertThrows(IllegalArgumentException.class, () -> linkedList.insert(7, 8));

        linkedList.insert(4, 8);
        assertEquals(8, linkedList.get(4));

        linkedList.insert(0, 9);
        linkedList.loopFor(System.out::println);
        assertEquals(9, linkedList.get(0));
    }

    @Test
    void remove() {
        for (int i = 5; i >= 0; i --) {
            linkedList.remove(i);
            linkedList.loopFor(val -> {
                System.out.print(val);
                System.out.print("\t");
            });
            System.out.println();
        }

        assertThrows(IllegalArgumentException.class, () -> linkedList.remove(0));

    }
}

