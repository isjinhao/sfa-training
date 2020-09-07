package jishuneimu.basis.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import org.apache.ibatis.reflection.TypeParameterResolver;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/3
 */
public class TestTypeParameterResolver {

    static SubClassA93<Long> sa = new SubClassA93<>();

    public static void main(String[] args) throws Exception {

        Field f = ClassA93.class.getDeclaredField("map");
        System.out.println(f.getGenericType());
        Type sa = TestTypeParameterResolver.class.getDeclaredField("sa").getGenericType();
        Type sab = ClassB93.class.getDeclaredField("sa").getGenericType();

        System.out.println(TypeParameterResolver.resolveFieldType(f, sa));
        System.out.println("------------------------------------------------");
        System.out.println(TypeParameterResolver.resolveFieldType(f, sab));
        System.out.println("------------------------------------------------");

        System.out.println("\n***********************************\n");

        Method getMethod = ClassA93.class.getDeclaredMethod("getMap");
        System.out.println(getMethod.getGenericReturnType());
        System.out.println(TypeParameterResolver.resolveReturnType(getMethod, sa));
        System.out.println("------------------------------------------------");
        System.out.println(TypeParameterResolver.resolveReturnType(getMethod, sab));
        System.out.println("------------------------------------------------");

        System.out.println("\n***********************************\n");

        Method setMethod = ClassA93.class.getDeclaredMethod("setMap", Map.class);
        System.out.println(Arrays.deepToString(setMethod.getGenericParameterTypes()));
        System.out.println(Arrays.deepToString(TypeParameterResolver.resolveParamTypes(setMethod, sa)));
        System.out.println("------------------------------------------------");
        System.out.println(Arrays.deepToString(TypeParameterResolver.resolveParamTypes(setMethod, sab)));
        System.out.println("------------------------------------------------");
    }
}

class ClassB93 {
    SubClassA93<String> sa = new SubClassA93<>();
}

class ClassA93<K, V> {
    public Map<K, V> map;
    public Map<K, V> getMap() {
        return map;
    }
    public void setMap(Map<K, V> map) {
        this.map = map;
    }
}

class SubClassA93<T> extends ClassA93<T, T> {

}