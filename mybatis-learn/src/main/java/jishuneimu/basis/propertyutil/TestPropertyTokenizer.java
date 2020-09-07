package jishuneimu.basis.propertyutil;

import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/7
 */
public class TestPropertyTokenizer {

    public static void main(String[] args) {

        PropertyTokenizer propertyTokenizer = new PropertyTokenizer("orders[0].item[0].name");
        show(propertyTokenizer);
        show(propertyTokenizer.next());
        show(propertyTokenizer.next().next());

    }

    private static void show(PropertyTokenizer propertyTokenizer) {
        System.out.println(propertyTokenizer.getIndex());
        System.out.println(propertyTokenizer.getIndexedName());
        System.out.println(propertyTokenizer.getName());
        System.out.println(propertyTokenizer.getChildren());
        System.out.println("---------------------------");

    }

}
