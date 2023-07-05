package com.dai.algo.algorithm.game;

import java.util.LinkedList;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description:
 *      汉诺塔大梵天创建世界时做了三根金刚石柱，在一根柱子从下往上按大小顺序摞着 64 片黄金圆盘，大梵天命令婆罗门把圆盘重新摆放在另一根柱子上，并且规定
 *          ● 一次只能移动一个圆盘
 *          ● 小圆盘上不能放大圆盘
 * @date 2023/7/5 20:36
 */
public class HanoiTower {
    private static LinkedList<Integer> a = new LinkedList<>();
    private static LinkedList<Integer> b = new LinkedList<>();
    private static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.add(i);
        }
    }

    public static void han(int n, LinkedList<Integer> old, LinkedList<Integer> mid, LinkedList<Integer> last) {
        if (n == 0) {
            return;
        }
        han(n - 1, old, last, mid); // n 的子集由old 挪到中间， 借last倒腾一下
        last.add(old.removeLast());    // n-1挪到中间过程后，最后一位挪到最终位置
        han(n - 1, mid, old, last); // n-1现在在中间，要借old, 移动到最终位置
    }

    public static void main(String[] args) {
        init(64);
        han(64, a, b, c);
        System.out.println(c);
    }
}
