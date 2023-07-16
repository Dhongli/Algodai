package com.dai.algo.algorithm.game;

import java.util.LinkedList;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 20. 有效的括号 https://leetcode.cn/problems/valid-parentheses/
 * @date 2023/7/16 22:37
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(')');
            } else if (c == '[') {
                stack.addFirst(']');
            } else if (c == '{') {
                stack.addFirst('}');
            } else if (!stack.isEmpty() && c == stack.peek()) {
                stack.pollFirst();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
