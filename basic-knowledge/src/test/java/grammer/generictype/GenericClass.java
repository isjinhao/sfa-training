package grammer.generictype;

public class GenericClass<T> {

    /**
     * key这个成员变量的类型为T，T的类型由客户端指定
     */
    private T key;

    /**
     * 泛型构造方法形参key的类型也为T，T的类型由客户端指定
     * @param key
     */
    public GenericClass(T key) {
        this.key = key;
    }

    /**
     * getKey的返回值类型为T，T的类型由外部指定（注意，这里不是泛型方法）
     * @return
     */
    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        /**
         * 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
         * 传入的实参类型需与泛型的类型参数类型相同，即为Integer
         */
        GenericClass<Integer> genericClassInteger = new GenericClass<>(123456);

        /**
         * 传入的实参类型需与泛型的类型参数类型相同，即为String
         */
        GenericClass<String> genericClassString = new GenericClass<>("key_vlaue");
        System.out.println("key is " + genericClassInteger.getKey().getClass());
        System.out.println("key is " + genericClassString.getKey().getClass());
    }
}