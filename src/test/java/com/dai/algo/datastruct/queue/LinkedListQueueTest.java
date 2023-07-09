package com.dai.algo.datastruct.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {
    private LinkedListQueue<Integer> queue;
    @BeforeEach
    void setUp() {
        queue = new LinkedListQueue(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
    }

    @Test
    void offer() {
        assertFalse(queue.offer(6));

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("\t");
        }
        System.out.println();
    }

    @Test
    void poll() {
        Integer poll1 = queue.poll();
        Integer poll2 = queue.poll();
        Integer poll3 = queue.poll();
        Integer poll4 = queue.poll();
        Integer poll5 = queue.poll();
        Integer poll6 = queue.poll();
        System.out.println(poll1);
        System.out.println(poll2);
        System.out.println(poll3);
        System.out.println(poll4);
        System.out.println(poll5);
        System.out.println(poll6);
        assertEquals(1, poll1);
        assertEquals(2, poll2);
        assertEquals(3, poll3);
        assertEquals(4, poll4);
        assertEquals(5, poll5);
        assertEquals(null, poll6);
    }

    @Test
    void peek() {
        Integer poll1 = queue.peek();
        Integer poll2 = queue.peek();
        Integer poll3 = queue.peek();
        Integer poll4 = queue.peek();
        Integer poll5 = queue.peek();
        Integer poll6 = queue.peek();
        System.out.println(poll1);
        System.out.println(poll2);
        System.out.println(poll3);
        System.out.println(poll4);
        System.out.println(poll5);
        System.out.println(poll6);
        assertEquals(1, poll6);
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
        poll();
        assertTrue(queue.isEmpty());
    }
}