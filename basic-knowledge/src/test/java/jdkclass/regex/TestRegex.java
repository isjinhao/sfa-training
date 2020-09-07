package jdkclass.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/30
 */
public class TestRegex {

    /**
     * 字符类
     *
     * - `[abc]` ：a、b 或 c（简单类）
     * - `[^abc]` ：任何字符，除了 a、b 或 c（否定）
     * - `[a-zA-Z]` ：a 到 z 或 A 到 Z，两头的字母包括在内（范围）
     * - `[a-d[m-p]]` ：a 到 d 或 m 到 p：[a-dm-p]（并集）
     * - `[a-z&&[def]]` ：d、e 或 f（交集）
     * - `[a-z&&[^bc]]` ：a 到 z，除了 b 和 c：[ad-z]（减去）
     * - `[a-z&&[^m-p]]` ：a 到 z，而非 m 到 p：[a-lq-z]（减去）
     */
    @Test
    public void test1() {
        String testStr = "123";
        System.out.println(Pattern.matches("[123][123][123]", testStr));    // true
        System.out.println(Pattern.matches("[^123][123][123]", testStr));   // false
    }


    /**
     * 预定义字符类
     *
     * - `.` ：任何字符（与行结束符可能匹配也可能不匹配）
     * - `\d` ：数字：[0-9]
     * - `\D` ：非数字：[^0-9]
     * - `\s` ：空白字符：[ \t\n\x0B\f\r]
     * - `\S` ：非空白字符：[^\s]
     * - `\w` ：单词字符：[a-zA-Z_0-9]
     * - `\W` ：非单词字符：[^\w]
     */
    @Test
    public void test2() {
        String testStr = "123";
        System.out.println(Pattern.matches("\\d\\d\\d", testStr)); 	// true
        System.out.println(Pattern.matches("\\w\\w\\w", testStr));	// true
    }


    /**
     * 数量词
     *
     * - `X?`： X存在一次或一次也没有
     * - `X*` ：X存在零次或多次
     * - `X+` ：X存在一次或多次
     * - `X{n}` ：X存在恰好 n 次
     * - `X{n,}` ：X存在至少 n 次
     * - `X{n,m}` ：X存在至少 n 次，但是不超过 m 次
     */
    @Test
    public void test3() {
        String testStr = "123";
        boolean matches = Pattern.matches("[123]{3}", testStr); //true
        System.out.println(matches);
    }


    /**
     * 定位符
     *
     * ^：匹配开头的位置，作用于第一个后继字符
     * $：匹配结尾的位置，作用于第一个前驱字符
     *
     * \b：匹配一个单词边界，即限定在字符与空格的边界
     * \B：非单词边界匹配
     */
    @Test
    public void test6() {
        String str1 = "aaa1";
        String str2 = "baaa1";
        String str3 = "aa1b";

        System.out.println(Pattern.matches("^a+1$", str1));
        System.out.println(Pattern.matches("^a+1$", str2));
        System.out.println(Pattern.matches("^a+1$", str3));

        String str4 = "verb";
        String str5 = "ver";
        String str6 = "ver ";

        Pattern pat = Pattern.compile("ver\\b");
        Matcher mat4 = pat.matcher(str4);
        Matcher mat5 = pat.matcher(str5);
        Matcher mat6 = pat.matcher(str6);

        if (mat4.find()) {
            System.out.println(mat4.group());
        }
        if (mat5.find()) {
            System.out.println(mat5.group());
        }
        if (mat6.find()) {
            System.out.println(mat6.group());
        }

    }

    /**
     * 查找子串
     *
     * 查找子串需要使用到Pattern和Mather
     * `[flid=1415279, ffid=BK-2898-20180922-A, frtt=20180922210700, frlt=20180923000300][flid=1417032, ffid=OD-689-20180923-D, fatt=2401, stat=BOR, ista=BOR]`
     */
    @Test
    public void test4() {
        String FFID = "((ffid=){1})\\w{2}-\\w{3,6}-\\d{8}-\\w";
        String str = "[flid=1415279, ffid=BK-2898-20180922-A, frtt=20180922210700, frlt=20180923000300][flid=1417032, ffid=OD-689-20180923-D, fatt=2401, stat=BOR, ista=BOR]";
        Pattern pattern = Pattern.compile(FFID);
        Matcher matcher = pattern.matcher(str);
        // 循环找出全部的匹配子串
        while(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }


    /**
     * group方法
     */
    @Test
    public void test5() {
        String regEx = "count(\\d+)(df)";
        String s = "count000dfdfsdffaaaa1";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        System.out.println(Pattern.matches(regEx, s));
        if (mat.find()) {
            System.out.println(mat.group());
            System.out.println(mat.group(0));
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
    }




}