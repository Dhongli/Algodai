package com.dai.algo.datastruct.queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 优先队列--无序数组实现
 * @date 2023/7/26 20:14
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] arr;
    int size;

    public PriorityQueue1(int capacity) {
        arr = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        arr[size++] = value;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        int max = selectMax();
        E element = (E) arr[max];
        remove(max);
        return element;
    }

    private void remove(int max) {
        for (int i = max + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--size] = null;
    }

    private int selectMax() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[maxIndex].priority() < arr[i].priority()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) arr[selectMax()];
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
