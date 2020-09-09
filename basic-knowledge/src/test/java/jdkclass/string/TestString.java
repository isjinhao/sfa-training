package jdkclass.string;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class TestString {

    /**
     * @description: 测试构造器
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test1() {
        String str1 = "123";
        String str2 = new String("123");
        char[] value = {'a', 'b', 'c', 'd'};
        String str3 = new String(value);
        String str4 = new String(value, 1, 2);
        byte[] strb = new byte[]{65, 66};
        String str5 = new String(strb);
        System.out.println(str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
    }

    /**
     * @description: length()
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test2() {
        String str = "asdfzxc";
        int strlength = str.length();
        System.out.println(strlength);
    }

    /**
     * @description: 求字符串某一位置字符
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test3() {
        String str = "asdfzxc";
        char ch = str.charAt(4);
        System.out.println(ch);
    }

    /**
     * @description: 提取子串
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test4() {
        String str = "asdfzxc";
        String str2 = str.substring(2);
        String str3 = str.substring(2, 5);
    }

    /**
     * @description: 字符串比较
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test5() {
        String str1 = "abc";
        String str2 = "ABC";
        int a = str1.compareTo(str2);
        System.out.println(a);                   // a > 0
        int b = str1.compareToIgnoreCase(str2);
        System.out.println(b);                   // b = 0
        boolean c = str1.equals(str2);
        System.out.println(c);                   // c = false
        boolean d = str1.equalsIgnoreCase(str2);
        System.out.println(d);                   // d = true
    }

    /**
     * @description: 字符串连接，单线程用StringBuilder，多线程永StringBuffer
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test6() {
        String str = "aa".concat("bb").concat("cc");
        str = "aa" + "bb" + "cc";
        System.out.println(str);
    }

    /**
     * @description: 字符串中单个字符查找
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test7() {
        String str = "I am a good student";
        int a = str.indexOf('a');
        System.out.println(a);          // a = 2
        int b = str.indexOf("good");
        System.out.println(b);          // b = 7
        int c = str.indexOf("w", 2);
        System.out.println(c);          // c = -1
        int d = str.lastIndexOf("a");
        System.out.println(d);          // d = 5
        int e = str.lastIndexOf("a", 3);
        System.out.println(e);          // e = 2
    }

    /**
     * @description: 字符的大小写转换
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test8() {
        String str = "asDF";
        String str1 = str.toLowerCase();    // str1 = "asdf"
        String str2 = str.toUpperCase();    // str2 = "ASDF"
        System.out.println(str1);
        System.out.println(str2);

    }

    /**
     * @description: 字符的替换
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test9() {
        String str = "asdzxcasd";
        String str1 = str.replace('a', 'g');
        // CharSequence target, CharSequence replacement
        String str2 = str.replace("asd", "fgh");
        String str3 = str.replaceFirst("asd", "fgh");
        // String regex, String replacement
        String str4 = str.replaceAll("asd", "fgh");
        System.out.println(str1);       // str1 = "gsdzxcgsd"
        System.out.println(str2);       // str2 = "fghzxcfgh"
        System.out.println(str3);       // str3 = "fghzxcasd"
        System.out.println(str4);       // str4 = "fghzxcfgh"
    }

    /**
     * @description: trim
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test10() {
        String str = " a sd ";
        String str1 = str.trim();
        int a = str.length();
        int b = str1.length();
        System.out.println(a);  // a = 6
        System.out.println(b);  // b = 4

    }

    /**
     * @description: regionMatches，区域匹配。(ingoreCase, 被比较字符串（this对象）的起始位置，用于比较的字符串，用于比较的字符串的起始位置，比较的字符串长度)
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test11() {
        String str1 = "www.taobao.com";
        String str2 = "taobao";
        String str3 = "TAOBAO";

        System.out.print("返回值 :");
        System.out.println(str1.regionMatches(4, str2, 0, 6));

        System.out.print("返回值 :");
        System.out.println(str1.regionMatches(4, str3, 0, 6));

        System.out.print("返回值 :");
        System.out.println(str1.regionMatches(true, 4, str3, 0, 6));
    }

    /**
     * @description: 分割
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test12() {
        String str = "asd!qwe|zxc#";
        String[] str1 = str.split("[!|#]");
        System.out.println(Arrays.toString(str1));   // str1[0] = "asd";str1[1] = "qwe";str1[2] = "zxc";
    }

    /**
     * @description: 编码转换
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test13() throws UnsupportedEncodingException {
        // 假设接收到的数据时GBK编码的
        byte[] gbks = "abcdefg".getBytes("GBK");
        String gbk = new String(gbks, "GBK");
        System.out.println(gbk);
    }

    @Test
    public void test14(){
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("hello", "world", "i", "am", "fine"));

        System.out.println(String.join(" ", strings));

    }

}