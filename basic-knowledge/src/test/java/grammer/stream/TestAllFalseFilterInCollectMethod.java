package grammer.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/14
 */
public class TestAllFalseFilterInCollectMethod {

    public static void main(String[] args) {

        String str = Arrays.asList("123", "234", "345").stream().filter(item -> item.equals("abc")).collect(Collectors.joining(""));
        System.out.println(str);

    }

}
