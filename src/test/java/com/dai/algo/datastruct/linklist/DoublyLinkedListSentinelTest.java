package com.dai.algo.datastruct.linklist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListSentinelTest {

    DoublyLinkedListSentinel linkedListSentinel;

    @BeforeEach
    void setUp() {
        linkedListSentinel = new DoublyLinkedListSentinel();
        linkedListSentinel.addFirst(5);
        linkedListSentinel.addFirst(4);
        linkedListSentinel.addFirst(3);
        linkedListSentinel.addFirst(2);
        linkedListSentinel.addFirst(1);
    }

    @Test
    void insert() {
        linkedListSentinel.insert(0, 0);
        assertEquals(0 , linkedListSentinel.get(0));

        linkedListSentinel.insert(4, 8);
        assertEquals(8 , linkedListSentinel.get(4));

        linkedListSentinel.insert(7, 9);

        assertThrows(IllegalArgumentException.class, () -> linkedListSentinel.insert(10, 10));

        iterator();
    }

    @Test
    void addFirst() {
        linkedListSentinel.addFirst(0);
        iterator();
        assertEquals(0 , linkedListSentinel.getFirst());
    }

    @Test
    void removeFirst() {
        linkedListSentinel.removeFirst();
        iterator();
        assertEquals(2 , linkedListSentinel.get(0));
        linkedListSentinel.removeFirst();
        iterator();
        linkedListSentinel.removeFirst();
        iterator();
        linkedListSentinel.removeFirst();
        iterator();
        linkedListSentinel.removeFirst();
        iterator();
        assertThrows(IllegalArgumentException.class, () -> linkedListSentinel.removeFirst());
    }

    @Test
    void addLast() {
        linkedListSentinel.addLast(6);
        iterator();
        assertEquals(6, linkedListSentinel.getLast());
    }

    @Test
    void removeLast() {
        linkedListSentinel.removeLast();
        iterator();
        assertEquals(4, linkedListSentinel.getLast());
    }

    @Test
    void remove() {
        linkedListSentinel.remove(0);
        iterator();
        linkedListSentinel.remove(3);
        iterator();
        assertThrows(IllegalArgumentException.class, () -> linkedListSentinel.remove(3));
    }

    @Test
    void iterator() {
        Iterator<Integer> iterator = linkedListSentinel.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("\t");
        }
        System.out.println();
    }
}