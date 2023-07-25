package com.dai.algo.datastruct.queue;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 数组实现双向队列
 * @date 2023/7/25 21:00
 */
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    int head;
    int tail;

    E[] element;

    public ArrayDeque(int capacity) {
        this.element = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        head = dec(head, element.length);
        element[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        element[tail] = e;
        tail = inc(tail, element.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        E value = element[head];
        element[head] = null;
        head = inc(head, element.length);
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail, element.length);
        E value = element[tail];
        element[tail] = null;
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return element[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return element[dec(tail, element.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (head > tail) {
            return head - tail == 1;
        } else if (head < tail) {
            return tail - head == element.length - 1;
        }
        return false;
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
                E value = element[p];
                p = inc(p, element.length);
                return value;
            }
        };
    }

    private int inc(int i, int length) {
        if (i + 1 > length - 1) {
            return 0;
        }
        return i + 1;
    }

    private int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }
}
