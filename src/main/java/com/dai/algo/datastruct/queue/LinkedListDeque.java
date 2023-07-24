package com.dai.algo.datastruct.queue;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 基于双向环形链表实现
 * @date 2023/7/24 22:44
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    private Node sentinel;
    int capacity;
    int size;

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public boolean offerFirst(E value) {
        if (isFull()) return false;
        Node next = sentinel.next;
        Node<E> firstNode = new Node<>(sentinel, value, next);
        sentinel.next = firstNode;
        next.prev = firstNode;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E value) {
        if (isFull()) return false;
        Node per = sentinel.prev;
        Node<E> lastNode = new Node<>(per, value, sentinel);
        sentinel.prev = lastNode;
        per.next = lastNode;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        Node first = sentinel.next;
        E value = (E) first.value;
        Node next = sentinel.next.next;
        sentinel.next = next;
        next.prev = sentinel;
        size--;
        first.next = null;
        first.prev = null;
        return value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        Node last = sentinel.prev;
        E value = (E) last.value;
        Node prev = last.prev;
        prev.next = sentinel;
        sentinel.prev = prev;
        size--;
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        Node first = sentinel.next;
        return (E) first.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        Node last = sentinel.prev;
        return  (E) last.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = sentinel.next;
            @Override
            public boolean hasNext() {
                return node != sentinel;
            }

            @Override
            public E next() {
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}

class Node<E> {
    Node<E> prev;
    E value;
    Node<E> next;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
