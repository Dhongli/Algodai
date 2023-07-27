package com.dai.algo.datastruct.queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 最大堆实现优先队列
 * @date 2023/7/27 21:06
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {

    Priority[] arr;
    int size;

    public PriorityQueue3(int capacity) {
        arr = new Priority[capacity];
    }

    /**
     * @description: 每插入一个就要从child开始往parent判断优先级，parent优先级小就向下降
     * @param: value
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/27 23:02
     */
    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        int child = size;
        int parent = (child - 1) / 2;
        while (child > 0 && arr[parent].priority() < value.priority()) {
            arr[child] = arr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        arr[child] = value;
        size++;
        return true;
    }

    /**
     * @description: 先将堆顶与最底下的child替换，然后弹出替换后的child，然后将置顶的最小优先级节点向下降
     * @param:
     * @return: E
     * @author daihongli
     * @date: 2023/7/27 23:03
     */
    @Override
    public E poll() {
        if (isEmpty()) return null;
        swap(0, size - 1);
        Priority val = arr[size - 1];
        arr[--size] = null;
        down();
        return (E) val;
    }

    private void down() {
        int parent = 0;
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && arr[left].priority() > arr[parent].priority()) {
                max = left;
            }
            if (right < size && arr[right].priority() > arr[max].priority()) {
                max = right;
            }
            if (parent != max) {
                swap(max, parent);
                parent = max;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Priority temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) arr[0];
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
