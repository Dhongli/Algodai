package com.dai.algo.datastruct.queue;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 17:55
 */
public class ArrayQueue<E> implements Queue<E>, Iterable<E> {

    private E[] array;
    private int head;
    private int tail;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
