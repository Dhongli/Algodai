package com.dai.algo.datastruct.queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueue2Test {

    @Test
    public void generic() {
        ArrayQueue2 queue = new ArrayQueue2();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
    }

    @Test
    public void offerLimit() {
        ArrayQueue2 queue = new ArrayQueue2();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

    }

    @Test
    public void poll1() {
        ArrayQueue2 queue = new ArrayQueue2();
        queue.offer(1);
        assertEquals(1, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void offer() {
        ArrayQueue2 queue = new ArrayQueue2();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

    }

    @Test
    public void poll() {
        ArrayQueue2 queue = new ArrayQueue2();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertNull(queue.poll());

        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
    }
}