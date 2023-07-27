package com.dai.algo.datastruct.queue;

import com.dai.algo.datastruct.queue.model.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueue3Test {
    PriorityQueue3<Entry> getQueue() {
        PriorityQueue3<Entry> queue = new PriorityQueue3<>(10);
        queue.arr = new Entry[]{
                new Entry(100),
                new Entry(19),
                new Entry(36),
                new Entry(17),
                new Entry(3),
                new Entry(15),
                new Entry(1),
                new Entry(2),
                new Entry(16),
                null
        };
        queue.size = 9;
        return queue;
    }

    @Test
    public void test() {
        PriorityQueue3<Entry> queue = getQueue();
        queue.poll();
        Assertions.assertArrayEquals(new Entry[]{
                new Entry(36),
                new Entry(19),
                new Entry(16),
                new Entry(17),
                new Entry(3),
                new Entry(15),
                new Entry(1),
                new Entry(2),
                null, null
        }, queue.arr);

        queue.poll();
        Assertions.assertArrayEquals(new Entry[]{
                new Entry(19),
                new Entry(17),
                new Entry(16),
                new Entry(2),
                new Entry(3),
                new Entry(15),
                new Entry(1),
                null, null, null
        }, queue.arr);
    }
}