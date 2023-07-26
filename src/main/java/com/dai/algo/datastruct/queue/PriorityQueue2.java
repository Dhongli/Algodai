package com.dai.algo.datastruct.queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 优先队列 -- 有序数组实现
 * @date 2023/7/26 21:55
 */
public class PriorityQueue2<E extends Priority> implements Queue<E>{
    Priority[] arr;
    int size;

    public PriorityQueue2(int capacity) {
        arr = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        insert(value);
        size++;
        return true;
    }

    private void insert(E value) {
        int i = size - 1;
        for (; i >= 0; i--) {
            if (value.priority() < arr[i].priority()) {
                arr[i + 1] = arr[i];
            } else if (value.priority() > arr[i].priority()) {
                arr[i + 1] = value;
                break;
            }
        }
        if (i == -1) {
            arr[0] = value;
        }
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = (E) arr[--size];
        arr[size] = null;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;

        return (E) arr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }
}
