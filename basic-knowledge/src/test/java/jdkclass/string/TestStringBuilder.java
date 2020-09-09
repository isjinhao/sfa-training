package jdkclass.string;

import org.junit.Test;

public class TestStringBuilder {

    /**
     * StringBuilder 清空
     */
    @Test
    public void test() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("1234");
        System.out.println(stringBuilder);

        stringBuilder.setLength(0);
        System.out.println(stringBuilder);

        stringBuilder.append("abcd");
        System.out.println(stringBuilder);

    }

}
