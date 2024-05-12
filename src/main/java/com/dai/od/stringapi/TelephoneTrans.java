package com.dai.od.stringapi;

import java.util.*;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName TelephoneTrans
 * @Description: OJ1104. 【软件认证】电话号码转换
 * 题目描述
 * 某语音翻译软件，需要实现如下中英文电话号码转换功能：
 * 若输入的是英文数字单词或Double组成的电话号码，则输出对应的中文数字单词；
 * 若输入为中文数字单词组成的电话号码，则输出对应的英文数字单词。
 * 若输入不合法，则输出字符串ERROR。
 * 中文数字、英文数字分别见下表：
 * 中文数字单词：Yi Er San Si Wu Liu Qi Ba Jiu Ling
 * 英文数字单词：One Two Three Four Five Six Seven Eight Nine Zero
 * 说明：
 * 输入保证每个单词都是合法的英文数字单词/中文数字单词/Double；
 * 合法的电话号码要么全中文，不会含 Double ；要么全英文，可能含 Double；
 * 若含 Double：
 * 合法格式：其后必须跟随英文数字单词，代表两个该数字。如输入DoubleSix，代表 SixSix；
 * 不合法的格式：其后跟随的不是英文数字单词，如 DoubleLiu 或 DoubleDouble 都是非法的。
 * 解答要求
 * 时间限制：1000ms, 内存限制：256MB
 * 输入
 * 一行仅由大小写字母组成的字符串，非空且长度不大于500
 * 输出
 * 一个字符串，表示转换后的电话号码；若输入不合法，输出ERROR。
 * 样例
 * 输入样例 1 复制
 * SixOneThreeOneDoubleZero
 * 输出样例 1
 * LiuYiSanYiLingLing
 * 提示样例 1
 * 输入样例 2 复制
 * YiLingSanSanJiu
 * 输出样例 2
 * OneZeroThreeThreeNine
 * 提示样例 2
 * 注意：SanSan不能转换为 DoubleThree
 * 输入样例 3 复制
 * DoubleLiu
 * 输出样例 3
 * ERROR
 * 提示样例 3
 * @Date 2024-05-12 19:10
 */
public class TelephoneTrans {

    private static final List<String> zhong = Arrays.asList("Ling", "Yi", "Er", "San", "Si", "Wu", "Liu", "Qi", "Ba", "Jiu");
    private static final List<String> ying = Arrays.asList("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Double");

    private static final Map<String, String> map = new HashMap<>();

    static {
        for (int i = 0; i < zhong.size(); i++) {
            map.put(zhong.get(i), ying.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String result = reserve(input);
        System.out.println(result);
    }

    private static String reserve(String input) {
        // 判断double pinyin组合 返回error
        if (input.endsWith("Double")) {
            return "ERROR";
        }
        int chLength = input.length();
        List<String> inputList = new ArrayList<>();
        List<String> telList = new ArrayList<>();
        // 获取到数字list
        int start = 0;
        for (int i = 0; i < chLength; i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                inputList.add(input.substring(start, i));
                start = i;
            }
            if (i == chLength - 1) {
                inputList.add(input.substring(start, chLength));
                inputList.removeFirst();
            }
        }
        System.out.println(inputList);

        if (!ying.containsAll(inputList) && !zhong.containsAll(inputList)) return "ERROR";

        // 拼音处理
        if (zhong.containsAll(inputList)) {
            return transPinToYing(inputList, telList);
        }

        // 英文处理
        return transYingToPin(inputList, telList);
    }

    private static String transYingToPin(List<String> inputList, List<String> telList) {
        for (int i = 0; i < inputList.size(); i++) {
            if ("Double".equals(inputList.get(i))) {
                inputList.set(i, inputList.get(i + 1));
            }
            telList.add(zhong.get(ying.indexOf(inputList.get(i))));
        }

        StringBuffer sb = new StringBuffer();
        for (String s : telList) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static String transPinToYing(List<String> inputList, List<String> telList) {

            for (int i = 0; i < inputList.size(); i++) {
                telList.add(ying.get(zhong.indexOf(inputList.get(i))));
            }
            StringBuffer sb1 = new StringBuffer();
            for (String s : telList) {
                sb1.append(s);
            }
            return sb1.toString();
    }
}
