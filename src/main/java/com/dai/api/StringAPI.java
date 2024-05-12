package com.dai.api;

/**
 * 字符串常用API
 * https://www.runoob.com/java/java-string.html
 * https://www.runoob.com/manual/jdk11api/java.base/java/lang/String.html
 */
public class StringAPI {
    public static void main(String[] args) {
        // System.out.println(concat("aaa", "bbb"));
        // System.out.println(format());
        // compareTo("aaa","bbb");
        // compareIgnore();
        // contentEquals();
        // getChars();
        // indexOf();
        // substring();
        contains();
    }

    /**
     * @param str1
     * @param str2
     * @return java.lang.String
     * @Description: 将str1拼接到str2后，返回新字符串 str1.concat(str2)
     * @date 2024-05-12 15:54
     */
    public static String concat(String str1, String str2) {
        // 可以对字符串常量使用 concat() 方法
        System.out.println("我叫：".concat("hahaha"));
        return str1.concat(str2);
    }

    /**
     * @return java.lang.String
     * @Description: String类的静态方法，用来创建可复用的格式化字符串
     * @date 2024-05-12 15:56
     */
    public static String format() {
        float floatVar = 1.234f;
        int intVar = 2;
        String stringVar = "你好";
        String fs;
        // String 类使用静态方法 format() 返回一个String 对象而不是 PrintStream 对象。
        // String 类的静态方法 format() 能用来创建可复用的格式化字符串，而不仅仅是用于一次打印输出。
        fs = String.format("""
                        浮点型变量的值为 %f,
                        整型变量的值为  %d,
                        字符串变量的值为 %s
                        """,
                floatVar, intVar, stringVar);
        // System.out.println(fs);
        return fs;
    }

    /**
     * @param index 指定返回字符位置
     * @return char
     * @Description: 返回指定索引处的 char 值。
     * @date 2024-05-12 16:08
     */
    public static char charAt(int index) {
        char c = "12345asdfg".charAt(index);
        System.out.println(c);
        return c;
    }

    /**
     * @param str1
     * @param str2
     * @return int
     * @Description: 比较对应字符的大小(ASCII码顺序)
     * 如果参数字符串等于此字符串，则返回值 0；
     * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
     * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
     * 如果第一个字符和参数的第一个字符不等，结束比较，返回第一个字符的ASCII码差值。
     * 如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推,直至不等为止，返回该字符的ASCII码差值。
     * 如果两个字符串不一样长，可对应字符又完全一样，则返回两个字符串的长度差值。
     * @date 2024-05-12 16:14
     */
    public static int compareTo(String str1, String str2) {
        System.out.println("##############compareTo##################");
        String str11 = "Strings";
        String str22 = "Strings";
        String str3 = "Strings123";
        int result = str11.compareTo(str22);
        System.out.println(result);
        result = str22.compareTo(str3);
        System.out.println(result);
        result = str3.compareTo(str11);
        System.out.println(result);

        return str1.compareTo(str2);
    }

    /**
     * @Description: 如果参数字符串等于此字符串，则返回值 0；
     * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
     * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
     * @date 2024-05-12 16:18
     */
    public static void compareIgnore() {
        System.out.println("##############compareIgnore##################");
        String str1 = "STRINGS";
        String str2 = "Strings";
        String str3 = "Strings123";

        int result = str1.compareToIgnoreCase(str2);
        System.out.println(result);

        result = str2.compareToIgnoreCase(str3);
        System.out.println(result);

        result = str3.compareToIgnoreCase(str1);
        System.out.println(result);

        System.out.println("aaa".compareToIgnoreCase("zb"));
    }


    /**
     * @Description: 如字符串与指定 StringBuffer 表示相同的字符序列，则返回 true；否则返回 false。
     * @date 2024-05-12 16:37
     */
    public static void contentEquals() {
        System.out.println("##############contentEquals##################");
        String str1 = "String1";
        String str2 = "String2";
        StringBuffer str3 = new StringBuffer("String1");
        // StringBuilder str3 = new StringBuilder( "String1");

        boolean result = str1.contentEquals(str3);
        System.out.println(result);

        result = str2.contentEquals(str3);
        System.out.println(result);
    }

    /**
     * @Description: 将指定字符数组中的所有字符复制到一个新的字符数组中，并返回一个新的字符串
     * @date 2024-05-12 16:47
     */
    public static void copyValueOf() {
        char[] Str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'r', 'u', 'n', 'o', 'o', 'b'};
        String Str2 = "";

        Str2 = Str2.copyValueOf(Str1);
        System.out.println("返回结果：" + Str2);

        Str2 = Str2.copyValueOf(Str1, 2, 6);
        System.out.println("返回结果：" + Str2);
        // 返回结果：hello runoob
        // 返回结果：llo ru
    }

    /**
     * @Description: 测试此字符串是否以指定的后缀结束。
     * @date 2024-05-12 17:01
     */
    public static void endsWith() {
        String Str = new String("菜鸟教程：www.runoob.com");
        boolean retVal;

        retVal = Str.endsWith("runoob");
        // 返回值 = false
        System.out.println("返回值 = " + retVal);

        retVal = Str.endsWith("com");
        // 返回值 = true
        System.out.println("返回值 = " + retVal);
    }

    /**
     * @Description: getChars() 方法将字符从字符串复制到目标字符数组。
     * srcBegin -- 字符串中要复制的第一个字符的索引。
     * srcEnd -- 字符串中要复制的最后一个字符之后的索引。
     * dst -- 目标数组。
     * dstBegin -- 目标数组中的起始偏移量。
     * @date 2024-05-12 17:00
     */
    public static void getChars() {
        String Str1 = "www.runoob.com";
        char[] Str2 = new char[6];

        Str1.getChars(4, 10, Str2, 0);
        System.out.print("拷贝的字符串为：");
        System.out.println(Str2);
    }

    /**
     * @Description: 返回指定子字符串在此字符串中第一次出现处的索引。
     * public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
     * 如果此字符串中没有这样的字符，则返回 -1。
     * int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，
     * 如果此字符串中没有这样的字符，则返回 -1。
     * fromIndex -- 开始搜索的索引位置，第一个字符是 0 ，第二个是 1 ，以此类推。
     * @date 2024-05-12 17:05
     */
    public static void indexOf() {
        String string = "aaa456ac";
        // 查找指定字符是在字符串中的下标。在则返回所在字符串下标；不在则返回-1.
        System.out.println(string.indexOf("b")); // indexOf(String str); 返回结果：-1，"b"不存在

        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(string.indexOf("a", 3));// indexOf(String str, int fromIndex); 返回结果：6

        //（与之前的差别：上面的参数是 String 类型，下面的参数是 int 类型）参考数据：a-97,b-98,c-99

        // 从头开始查找是否存在指定的字符
        System.out.println(string.indexOf(99));// indexOf(int ch)；返回结果：7
        System.out.println(string.indexOf('c'));// indexOf(int ch)；返回结果：7

        // 从fromIndex查找ch，这个是字符型变量，不是字符串。字符a对应的数字就是97。
        System.out.println(string.indexOf(97, 3));// indexOf(int ch, int fromIndex); 返回结果：6
        System.out.println(string.indexOf('a', 3));// indexOf(int ch, int fromIndex); 返回结果：6
    }

    /**
     * @Description: 返回指定子字符串在此字符串中最右边出现处的索引。
     * public int lastIndexOf(int ch): 返回指定字符在此字符串中最后一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * public int lastIndexOf(int ch, int fromIndex): 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索，如果此字符串中没有这样的字符，则返回 -1。
     * public int lastIndexOf(String str): 返回指定子字符串在此字符串中最右边出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * public int lastIndexOf(String str, int fromIndex): 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索，如果此字符串中没有这样的字符，则返回 -1。
     * ch -- 字符。
     * fromIndex -- 开始搜索的索引位置。
     * str -- 要搜索的子字符串。
     * 返回值 指定子字符串在字符串中最后一次出现处的索引值。
     * @date 2024-05-12 17:28
     */
    public static void lastIndexOf() {
        String Str = "菜鸟教程:www.runoob.com";
        String SubStr1 = "runoob";
        String SubStr2 = "com";

        System.out.print("查找字符 o 最后出现的位置 :");
        // 查找字符 o 最后出现的位置 :17
        System.out.println(Str.lastIndexOf('o'));
        System.out.print("从第14个位置查找字符 o 最后出现的位置 :");
        // 从第14个位置查找字符 o 最后出现的位置 :13
        System.out.println(Str.lastIndexOf('o', 14));
        System.out.print("子字符串 SubStr1 最后出现的位置:");
        // 子字符串 SubStr1 最后出现的位置:9
        System.out.println(Str.lastIndexOf(SubStr1));
        System.out.print("从第十五个位置开始搜索子字符串 SubStr1最后出现的位置 :");
        // 从第十五个位置开始搜索子字符串 SubStr1最后出现的位置 :9
        System.out.println(Str.lastIndexOf(SubStr1, 15));
        System.out.print("子字符串 SubStr2 最后出现的位置 :");
        // 子字符串 SubStr2 最后出现的位置 :16
        System.out.println(Str.lastIndexOf(SubStr2));
    }


    public static void split() {
        String str = new String("Welcome-to-Runoob");

        System.out.println("- 分隔符返回值 :");
        for (String retval : str.split("-")) {
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :");
        // Welcome
        // to-Runoob
        for (String retval : str.split("-", 2)) {
            System.out.println(retval);
        }

        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :");
        for (String retval : str2.split("\\.", 3)) {
            System.out.println(retval);
        }

        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :");
        // acount=?
        //  uu =?
        //  n=?
        for (String retval : str3.split("and|or")) {
            System.out.println(retval);
        }
    }


    /**
     * @Description: subSequence() 方法返回一个新的字符序列，它是此序列的一个子序列。
     * beginIndex -- 起始索引（包括）。
     * endIndex -- 结束索引（不包括）。
     * @date 2024-05-12 18:32
     */
    public static void subSequence() {
        String Str = new String("www.runoob.com");

        System.out.print("返回值 :");
        // 返回值 :runoob
        System.out.println(Str.subSequence(4, 10));
    }


    /**
     * @Description: 方法返回字符串的子字符串。
     * public String substring(int beginIndex)
     * 或
     * public String substring(int beginIndex, int endIndex)
     * beginIndex -- 起始索引（包括）, 索引从 0 开始。
     * endIndex -- 结束索引（不包括）。
     * @date 2024-05-12 18:35
     */
    public static void substring() {
        String Str = new String("This is text");

        System.out.print("返回值 :");
        // 返回值 :is text
        System.out.println(Str.substring(5));

        System.out.print("返回值 :");
        // 返回值 :is te
        System.out.println(Str.substring(5, 10));
    }

    /**
     * @Description: 将字符串转换为字符数组。
     * @date 2024-05-12 18:41
     */
    public static void toCharArray() {
        String Str = new String("www.runoob.com");

        System.out.print("返回值 :");
        System.out.println(Str.toCharArray());
    }

    /**
     * @Description: 返回给定data type类型x参数的字符串表示形式。
     * valueOf() 方法有以下几种不同形式：
     * valueOf(boolean b): 返回 boolean 参数的字符串表示形式。.
     * valueOf(char c): 返回 char 参数的字符串表示形式。
     * valueOf(char[] data): 返回 char 数组参数的字符串表示形式。
     * valueOf(char[] data, int offset, int count): 返回 char 数组参数的特定子数组的字符串表示形式。
     * valueOf(double d): 返回 double 参数的字符串表示形式。
     * valueOf(float f): 返回 float 参数的字符串表示形式。
     * valueOf(int i): 返回 int 参数的字符串表示形式。
     * valueOf(long l): 返回 long 参数的字符串表示形式。
     * valueOf(Object obj): 返回 Object 参数的字符串表示形式。
     * @date 2024-05-12 18:43
     */
    public static void valueOf() {
        double d = 1100.00;
        boolean b = true;
        long l = 1234567890;
        char[] arr = {'r', 'u', 'n', 'o', 'o', 'b'};

        System.out.println("返回值 : " + String.valueOf(d));
        System.out.println("返回值 : " + String.valueOf(b));
        System.out.println("返回值 : " + String.valueOf(l));
        System.out.println("返回值 : " + String.valueOf(arr));
    }


    /**
     * @Description: 用于判断字符串中是否包含指定的字符或字符串。
     * 参数
     * chars -- 要判断的字符或字符串。
     * @date 2024-05-12 18:46
     */
    public static void contains() {
        String myStr = "Runoob";
        System.out.println(myStr.contains("Run")); // true
        System.out.println(myStr.contains("o")); // true
        System.out.println(myStr.contains("s")); // false
        System.out.println(myStr.contentEquals("Run")); // false
        System.out.println(myStr.contentEquals("Runoob")); // true
    }
}
