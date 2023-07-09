package com.dai.algo.datastruct.queue;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 环形带哨兵的队列
 * @date 2023/7/9 16:14
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E>{

    private Node<E> head = new Node<>(null, null);

   private Node<E> tail = head;

   private int size;

   private int capacity;

    public LinkedListQueue() {
        tail.next = head;
        capacity = 10;
    }

    public LinkedListQueue(int capacity) {
        tail.next = head;
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added =  new Node<>(value, head);
        tail.next = added;
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (head == tail) {
            return null;
        }
        Node<E> polled = head.next;
        if (polled == tail) {
            tail = head;
        }
        head.next = polled.next;
        size--;
        return polled.value;
    }

    @Override
    public E peek() {
        if (head == tail) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> curr = head.next;
            @Override
            public boolean hasNext() {
                if (curr != head) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                E value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private class Node<E> {
        E value;
        Node<E> next;


        public Node() {
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
