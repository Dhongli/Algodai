package com.dai.algo.datastruct.linklist;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: TODO
 * @date 2023/7/1 12:14
 */
public class SingleLinkedListIter extends SingleLinkedList implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<Integer> {
        Note curr = head;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Integer next() {
            int value = curr.value;
            curr = curr.next;
            return value;
        }
    }
}
