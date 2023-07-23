package com.dai.algo.algorithm.game;

import java.util.LinkedList;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 150. 逆波兰表达式求值 后缀表达式 https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * @date 2023/7/23 18:00
 */
public class LeetCode150 {

    /**
     * @description: 计算后缀表达式
     * @param: tokens
     * @return: int
     * @author daihongli
     * @date: 2023/7/23 18:41
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = a + b;
                stack.push(result);
            } else if (tokens[i].equals("-")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = a - b;
                stack.push(result);
            } else if (tokens[i].equals("*")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = a * b;
                stack.push(result);
            } else if (tokens[i].equals("/")) {
                Integer b = stack.pop();
                Integer a = stack.pop();
                Integer result = a / b;
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    /**
     * @description: 中缀表达式转后缀表达式
     * 思路
     * 1. 遇到数字, 拼串
     * 2. 遇到 + - * /
     * - 优先级高于栈顶运算符 入栈
     * - 否则将栈中高级或平级运算符出栈拼串, 本运算符入栈
     * 3. 遍历完成, 栈中剩余运算符出栈拼串
     * - 先出栈,意味着优先运算
     * 4. 带 ()
     * - 左括号直接入栈
     * - 右括号要将栈中直至左括号为止的运算符出栈拼串
     * |   |
     * |   |
     * |   |
     * _____
     * a+b
     * a+b-c
     * a+b*c
     * a*b+c
     * (a+b)*c
     * @param: exp
     * @return: java.lang.String
     * @author daihongli
     * @date: 2023/7/23 18:42
     */
    public static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        continue;
                    }
                    if (priority(c) > priority(stack.peek())) {
                        stack.push(c);
                    } else {
                        sb.append(stack.pop());
                        while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("不合法字符:" + c);
        };
    }

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("a+b*c+(d*e+f)*g"));
    }

}
