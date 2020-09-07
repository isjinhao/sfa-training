package grammer.bridgemethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class SonPair extends Pair<String> {

    /**
     * https://blog.csdn.net/mhmyqn/article/details/47342577
     * https://developer.aliyun.com/article/75442
     * https://www.cnblogs.com/jixp/articles/10264034.html
     */

    /**
     * @param first
     * @param second
     */
    public SonPair(String first, String second) {
        super(first, second);
    }

    @Override
    public void setFirst(String first) {
        super.setFirst(first + "123");
    }

    public static void main(String[] args) {

        Pair sonPair = new SonPair("123", "abc");
        /**
         * java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.String
         * 实际上这里调用的时桥方法，桥方法里会生进行类型转换，发现 Object 类型无法转为 String 类型。
         * java.lang.reflect.Method 类有一个 isBridge() 可以判断是否是桥方法
         */
        sonPair.setFirst(new Object());

    }

}
