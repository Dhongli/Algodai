package com.dai.api;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName CharacterAPI
 * @Description: Character 类用于对单个字符进行操作。
 * Character 类在对象中包装一个基本类型 char 的值
 * @Date 2024-05-12 18:52
 */
public class CharacterAPI {
    public static void main(String[] args) {
        // 装箱
        Character ch = 'a';
        // isLetterAndisDigit();
        isWhitespaceAndisUpperCase();
    }

    /**
     * @Description: 判断指定字符是否为字母。
     * @date 2024-05-12 19:00
     */
    public static void isLetterAndisDigit() {
        System.out.println(Character.isLetter('c')); // true
        System.out.println(Character.isLetter('5')); // false

        System.out.println(Character.isDigit('c')); // false
        System.out.println(Character.isDigit('5')); // true
    }

    /**
     * @Description: isWhitespace() 是否是一个空白字符
     * isUpperCase() 是否是大写字母
     * isLowerCase() 是否是小写字母
     * toUpperCase() 指定字母的大写形式
     * toLowerCase() 指定字母的小写形式
     * @date 2024-05-12 19:03
     */
    public static void isWhitespaceAndisUpperCase() {
        System.out.println(Character.isWhitespace('c')); // false
        System.out.println(Character.isWhitespace(' ')); // true

        System.out.println(Character.isUpperCase('c')); // false
        System.out.println(Character.isUpperCase('C')); // true

        System.out.println(Character.isLowerCase('c')); // true
        System.out.println(Character.isLowerCase('C')); // false

        System.out.println(Character.toUpperCase('c')); // C
        System.out.println(Character.toUpperCase('C')); // C
    }
}