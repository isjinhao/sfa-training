package grammer;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/31
 */
public class TestEnum {

    /**
     * @description: 枚举中的属性有两种表示
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test1() {

        System.out.println(Gender.nan);

        Pet.dog.say();
        Pet.mouse.say();

    }

    /***
     * @description: 每个枚举类都是Enum的子类，Enum中提供了很多的方法
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test2(){
        /**
         * Enum 类中有两个属性 name 和 ordinal。name 就是枚举值的字符串表示
         * ordinal 是 枚举值声明时的顺序
         */
        System.out.println(Gender.nan.name());
        System.out.println(Gender.nan.ordinal());
        System.out.println(Arrays.deepToString(Gender.values()));

        /**
         * 静态的构建枚举值的方法
         */
        Gender nan = Enum.valueOf(Gender.class, "nan");

        /**
         * 对于 Gender 这样的枚举，getClass 和 getDeclaringClass 没有区别
         * 对于 Pet 这样的枚举，dog 实际上是 Pet 的一个子类的属性，所以 dog 的真实类是一个匿名内部类
         * 详见：https://www.cnblogs.com/allmignt/p/12353744.html
         */
        System.out.println(nan.getDeclaringClass());
        System.out.println(nan.getClass());

        System.out.println(Pet.dog.getDeclaringClass());
        System.out.println(Pet.dog.getClass());
        System.out.println(Pet.mouse.getClass());
        System.out.println(Pet.cat.getClass());
        System.out.println(Pet.dog);

    }

    /**
     * @description: EnumSet
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test3() {
        /**
         * EnumSet 是专为枚举设置的一个 Set
         */
        EnumSet<Pet> pets = EnumSet.allOf(Pet.class);
        System.out.println(pets);

        /**
         * 不接受 null
         */
//        pets.add(null);

        /**
         * 可以测试集合是否有 null
         */
        System.out.println(pets.contains(null));

    }

    /**
     * @description: EnumMap
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test4() {
        /**
         * EnumMap 是专为枚举设置的一个 Map，它的键是 枚举类型
         */
        EnumMap<Pet, String> petObjectEnumMap = new EnumMap<>(Pet.class);

        petObjectEnumMap.put(Pet.cat, "1");
        petObjectEnumMap.put(Pet.dog, "2");
        petObjectEnumMap.put(Pet.mouse, "3");

        System.out.println(petObjectEnumMap);

        /**
         * 不接受 null 作为key
         */
//        petObjectEnumMap.put(null, "4");

        /**
         * 可以测试集合是否有 null
         */
        System.out.println(petObjectEnumMap.containsKey(null));

    }

    /***
     * @description: 枚举也可以添加属性，一个枚举实际上是一个对象
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test5(){
        System.out.println(Course.chinese.getTotalScore());
        System.out.println(Course.physics.getTotalScore());
    }

    enum Gender {
        nan, nv
    }

    enum Pet {
        mouse, dog{
            @Override
            public void say() {
                System.out.println("I am dog");
            }
        },
        cat{
            @Override
            public void say() {
                System.out.println("I am cat");
            }
        };
        public void say(){
            System.out.println("I am pet");
        }
    }

    enum Course {

        math(150),chinese(150),physics(100);


        private int totalScore;

        Course(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getTotalScore() {
            return totalScore;
        }

    }
}