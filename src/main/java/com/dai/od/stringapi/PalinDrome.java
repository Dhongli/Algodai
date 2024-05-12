package com.dai.od.stringapi;

import java.util.Scanner;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName PalinDrome
 * @Description: 125. 验证回文串
 * https://leetcode.cn/problems/valid-palindrome/description/
 * @Date 2024-05-12 21:27
 */
public class PalinDrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        boolean huiwen = isPalindrome(inputStr);
        System.out.println(huiwen);
    }

    private static boolean isPalindrome(String inputStr) {
        if (inputStr.length() == 1) return true;
        String lowInput = inputStr.toLowerCase();
        char[] inputChar = lowInput.toCharArray();
        int i = 0, j = lowInput.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(inputChar[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(inputChar[j])) {
                j--;
                continue;
            }
            if (inputChar[i] != inputChar[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
