package com.dai.algo.datastruct.queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 16:10
 */
public interface Queue<E> {

    /**
     * @description: 向队尾插入
     * @param: value
     * @return: boolean 成功返回 true, 失败返回 false
     * @author daihongli
     * @date: 2023/7/9 16:12
     */
    boolean offer(E value);

    /**
     * @description: 从队头获取值并从队列删除
     * @param:
     * @return: E 队列非空返回对头值，空返回null
     * @author daihongli
     * @date: 2023/7/9 16:12
     */
    E poll();

    /**
     * @description: 从队头获取值
     * @param:
     * @return: E 队列非空返回对头值，空返回null
     * @author daihongli
     * @date: 2023/7/9 16:13
     */
    E peek();

    /**
     * @description: 检查队列是否为空
     * @param:
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/9 16:14
     */
    boolean isEmpty();

    /**
     * @description: 检查队列是否已满
     * @param:
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/9 17:47
     */
    boolean isFull();
}
