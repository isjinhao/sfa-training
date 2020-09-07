package grammer.generictype;

/**
 * 类中的静态方法使用泛型：静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
 * 为什么要有这样的限定呢？其实是因为Java中的泛型是在编译期实现的，也就是说如果我们有一个泛型类，如Stream<T>，它里面有一个静态方法of(T ... t)，
 * 我们不能使用Stream<String>.of(...)，因为压根就没有Stream<String>这个类型，只能使用Stream.of()，这样一来我们就无法给参数T实例化一个类型。
 * 也就是说类中的静态属性和静态方法中的T没有办法被实例化的。
 */
public class StaticGenericClass<T> {
    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     *    "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }
}