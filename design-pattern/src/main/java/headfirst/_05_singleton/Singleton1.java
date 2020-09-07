package headfirst._05_singleton;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/6
 */
public class Singleton1 {

    public static void main(String[] args) {

        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.sayOk();

    }

}
enum SingletonEnum {
    INSTANCE;
    public void sayOk() {
        System.out.println("ok");
    }
}