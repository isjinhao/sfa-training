package headfirst._05_singleton;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/6
 */
public class Singleton2 {

    public static void main(String[] args) {

        SingletonStaticInnerClass instance1 = SingletonStaticInnerClass.getInstance();
        SingletonStaticInnerClass instance2 = SingletonStaticInnerClass.getInstance();
        System.out.println(instance1 == instance2);

    }

}

class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {
    }

    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance(){
        return SingletonHolder.INSTANCE;
    }

}