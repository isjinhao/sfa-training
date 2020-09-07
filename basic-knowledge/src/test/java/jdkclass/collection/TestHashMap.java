package jdkclass.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.junit.Test;


public class TestHashMap {

    static Map<String, String> hashMap = new HashMap();

    static {
        hashMap.put("1", "abc");
        hashMap.put("2", "abc");
        hashMap.put("3", "abc");
        hashMap.put("4", "abc");
        hashMap.put("5", "abc");
    }

    /**
     * @return void
     * @description: TODO
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test1() {
        Set<String> strings = hashMap.keySet();
        for (String next : strings) {
            System.out.print(next + " : ");
            System.out.println(hashMap.get(next));
        }
    }

    /**
     * @return void
     * @description: getOrDefault
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test2() {
        System.out.println(hashMap.getOrDefault("1", "hhh"));
        System.out.println(hashMap.getOrDefault("a", "hhh"));
    }

    /**
     * @return void
     * @description: put覆盖时key已经有映射的数据时返回old value，没有映射的数据时返回null
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test3() {
        System.out.println(hashMap.put("1", "hhh"));
        System.out.println(hashMap.put("6", "hhh"));
    }

    /**
     * @return void
     * @description: containsKey() 和 containsValue()
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test4() {
        System.out.println(hashMap.containsKey("1"));
        System.out.println(hashMap.containsKey("11"));
        System.out.println(hashMap.containsValue("abc"));
        System.out.println(hashMap.containsValue("hhh"));
    }

    /**
     * @return void
     * @description: putIfAbsent
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test5() {
        /**
         * 如果存在key，返回当前值， 如果不存在key，返回null
         */
        System.out.println(hashMap.putIfAbsent("1", "hhh"));
        System.out.println(hashMap.putIfAbsent("11", "hhh"));
    }


    /**
     * @return void
     * @description: replace
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test6() {
        /**
         * 如果存在key，返回旧的值；如果不存在key，返回null
         */
        System.out.println(hashMap.replace("1", "hhh"));
        /**
         * return true if the value was replaced
         */
        System.out.println(hashMap.replace("1", "abc", "hhh"));
    }

    /**
     * @return void
     * @description: 重写equals时必须重写hashcode
     * @params:
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test7() {
        Map<Person, String> map = new HashMap();
        Person person2 = new Person("a", 1);
        Person person1 = new Person("a", 1);
        /**
         * HashMap的put操作会先通过hashCode定位桶的位置。在桶内遍历的时候会调用equals看是否相等
         */

        /**
         * 注释掉equals和hashCode、注释掉hashCode、注释掉equals、保留equals和hashCode
         */
        map.put(person1, "1");
        map.put(person2, "2");
        System.out.println(map.size()); // 2、2、2、1

    }


    /***
     * @description: IDEA的equals模板问题
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/24
     */
    @Test
    public void test8() {
        /**
         * 在实际的需求中，这person和man时同一个人，但是却被判定为不一致，因为equals方法里 getClass() != o.getClass() 为真。
         * 加上 checkRealChild(o.getClass(), getClass() 之后才是真正的判断
         */
        Map<Person, String> map = new HashMap();
        Person person = new Person("a", 1);
        Man man = new Man("a", 1);
        map.put(person, "1");
        map.put(man, "2");
        System.out.println(map.size());
    }

    class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
//            System.out.println(o.getClass() + "  " + getClass());
//            if (o == null || (getClass() != o.getClass())) {
            if (o == null || (getClass() != o.getClass() && checkRealChild(o.getClass(), getClass()))) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    class Man extends Person {

        public Man(String name, int age) {
            super(name, age);
        }
    }


    public static void main(String[] args) {

        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
        System.out.println(superclass.getSuperclass());
    }

    /***
     * @description: TODO
     * @params: child
     * @params: parent
     * @return boolean
     * @author: 01395265
     * @date: 2020/7/24
     */
    static boolean checkRealChild(Class child, Class parent){
        String parentStr = parent.toString();
        while(child != null){
            if(child.toString().equals(parentStr)){
                return true;
            }
            child = child.getSuperclass();
        }
        return false;
    }

}