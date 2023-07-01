package com.dai.algo.datastruct.linklist;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 单向链表
 * @date 2023/7/1 11:40
 */
public class SingleLinkedList {
    protected Note head;

    /**
     * @description: 新增元素
     * @param: value 元素值
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 11:49
     */
    public void addFirst(int value) {
        // 链表为空
        // if (head == null) {
        //     head = new Note(value, null);
        // } else {
        //  既可以处理空也可以处理非空
        head = new Note(value, head);
        // }
    }

    /**
     * @description: 在尾部添加 Note
     * @param: value 添加元素的值
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 13:15
     */
    public void addLast(int value) {
        Note current = findLast();
        current.next = new Note(value, null);
    }

    /**
     * @description: 向末尾添加多个节点
     * @param: first 第一个元素
     * @param: rest 后面的多个元素
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 13:32
     */
    public void addLast(int first, int... rest) {
        Note fir = new Note(first, null);
        Note curr = fir;
        for (int value : rest) {
            curr.next = new Note(value, null);
            curr = curr.next;
        }
        if (findLast() != null)
            findLast().next = fir;

    }

    /**
     * @description: 根据索引找 note
     * @param: index
     * @return: int note 的值
     * @author daihongli
     * @date: 2023/7/1 13:42
     */
    public int get(int index) {
        Note note = fineNote(index);
        if (note != null) {
            return note.value;
        }
        throw illegalIndex(index);
    }

    /**
     * @description: 在索引处插入
     * @param: index
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 14:24
     */
    public void insert(int index, int value) {
        if (index == 0) {
            this.head = new Note(value, this.head);
            return;
        }
        Note parent = fineNote(index - 1);
        if (parent == null) {
            throw illegalIndex(index);
        }
        parent.next = new Note(value, parent.next);
    }

    /**
     * @description: 根据索引删除 note
     * @param: index
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 14:36
     */
    public void remove(int index) {
        if (index == 0 && this.head != null) {
            this.head = this.head.next;
            return;
        } else  if (index == 0){
            throw illegalIndex(index);
        }
        Note parent = fineNote(index - 1);
        if (parent != null && parent.next != null) {
            parent.next = parent.next.next;
        } else {
            throw illegalIndex(index);
        }

    }

    private Note fineNote(int index) {
        int i = 0;
        for (Note curr = this.head; curr != null ; i++, curr = curr.next) {
            if (index == i) {
                return curr;
            }
        }
        return null;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * @description: 寻找链表最后一个 Note
     * @param:
     * @return: Note
     * @author daihongli
     * @date: 2023/7/1 13:19
     */
    private Note findLast() {
        if (this.head == null)
            return null;
        Note current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * @description: 遍历链表 - while 实现
     * @param:
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 11:50
     */
    public void loopWhile(Consumer<Integer> consumer) {
        Note curr = this.head;
        while (curr != null) {
            consumer.accept(curr.value);
            // System.out.println(curr.value);
            curr = curr.next;
        }

    }

    /**
     * @description: 遍历链表 - for 实现
     * @param: consumer
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 12:08
     */
    public void loopFor(Consumer<Integer> consumer) {
        for (Note curr = this.head; curr != null; curr = curr.next) {
            consumer.accept(curr.value);
        }
    }

    /**
     * 内部类，对外隐藏实现细节
     */
    protected class Note {
        int value;
        Note next;

        public Note(int value, Note next) {
            this.value = value;
            this.next = next;
        }
    }

}
