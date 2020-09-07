package grammer.generictype;

/**
 * 说明：
 *   1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
 *   2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
 *   3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
 *   4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
 *	 5）如果泛型类也声明了一个T，泛型方法的T会覆盖泛型类的T
 *	 public <T> T genericMethod(Class<T> tClass)
 *     throws InstantiationException, IllegalAccessException{
 *     T instance = tClass.newInstance();
 *     return instance;
 *   }
 */
public class GenericMethod {

    /**
     * 这个类是个泛型类
     * @param <T>
     */
    public class Generic<T> {

        private T key;

        public Generic(T key) {
            this.key = key;
        }

        /**
         * 我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
         * 这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
         * 所以在这个方法中才可以继续使用 T 这个泛型。
         * @return
         */
        public T getKey() {
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         public E setKey(E key){
         this.key = keu
         }
         */
    }

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     * 如：public <T,K> K showKeyName(Generic<T> container){
     * ...
     * }
     */
    public <T> T showKeyName(Generic<T> container) {
        System.out.println("container key :" + container.getKey());
        // 当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container) {
     ...
     }
     */
}