package com.dai.algo.datastruct.queue;

/**
 * @author daihongli
 * @description: 双端队列
 * @param: null
 * @return:
 * @date: 2023/7/24 22:41
 */
public interface Deque<E> {

    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean isEmpty();
    boolean isFull();
}
