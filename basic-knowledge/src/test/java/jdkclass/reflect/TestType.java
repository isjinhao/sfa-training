package jdkclass.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestType {

    public static <T, K extends Comparable<Number> & Cloneable> void test(TestType p0, List<TestType> p1, Map<String, TestType> p2,
        List<String>[] p3, Map<String, TestType>[] p4, List<? extends Comparable> p5,
        Map<? extends Number, ? super TestType> p6,T p7, K p8
    ) {
    }

    private static void show(Method testMethod) throws Exception {
        Type[] types = testMethod.getGenericParameterTypes();

        // 第一个参数，TestReflect
        Class type0 = (Class) types[0];
        System.out.println("type0: " + type0);
        System.out.println("-----------------------------------------------------\n");

        // 第二个参数，List<TestReflect>
        Type type1 = types[1];
        Type rawType1 = ((ParameterizedType) type1).getRawType();
        Type ownerType = ((ParameterizedType) type1).getOwnerType();
        System.out.println(ownerType);
        System.out.println("rawType  " + rawType1);
        Type[] parameterizedType1 = ((ParameterizedType) type1).getActualTypeArguments();
        Class parameterizedType1_0 = (Class) parameterizedType1[0];
        System.out.println("parameterizedType1_0: " + parameterizedType1_0);
        System.out.println("-----------------------------------------------------\n");

        // 第三个参数，Map<String,TestReflect>
        Type type2 = types[2];
        Type rawType = ((ParameterizedType) type2).getRawType();
        System.out.println("rawType    " + rawType);
        Type[] parameterizedType2 = ((ParameterizedType) type2).getActualTypeArguments();
        Class parameterizedType2_0 = (Class) parameterizedType2[0];
        System.out.println("parameterizedType2_0: " + parameterizedType2_0);
        Class parameterizedType2_1 = (Class) parameterizedType2[1];
        System.out.println("parameterizedType2_1: " + parameterizedType2_1);
        System.out.println("-----------------------------------------------------\n");

        // 第四个参数，List<String>[]
        Type type3 = types[3];
        System.out.println(type3.getClass());
        Type genericArrayType3 = ((GenericArrayType) type3).getGenericComponentType();
        ParameterizedType parameterizedType3 = (ParameterizedType) genericArrayType3;
        System.out.println(parameterizedType3.getRawType());
        Type[] parameterizedType3Arr = parameterizedType3.getActualTypeArguments();
        Class class3 = (Class) parameterizedType3Arr[0];
        System.out.println("class3: " + class3.getName());
        System.out.println("-----------------------------------------------------\n");

        // 第五个参数，Map<String,TestReflect>[]
        Type type4 = types[4];
        Type genericArrayType4 = ((GenericArrayType) type4).getGenericComponentType();
        ParameterizedType parameterizedType4 = (ParameterizedType) genericArrayType4;
        Type[] parameterizedType4Arr = parameterizedType4.getActualTypeArguments();
        Class class4_0 = (Class) parameterizedType4Arr[0];
        System.out.println("class4_0:" + class4_0);
        Class class4_1 = (Class) parameterizedType4Arr[1];
        System.out.println("class4_1:" + class4_1);
        System.out.println("-----------------------------------------------------\n");

        // 第六个参数，List<? extends TestReflect>
        Type type5 = types[5];
        Type[] parameterizedType5 = ((ParameterizedType) type5).getActualTypeArguments();
        Type[] parameterizedType5_0_upper = ((WildcardType) parameterizedType5[0]).getUpperBounds();
        Type[] parameterizedType5_0_lower = ((WildcardType) parameterizedType5[0]).getLowerBounds();
        for (Type type : parameterizedType5_0_upper) {
            System.out.println(type);
        }
        System.out.println("*******************");
        for (Type type : parameterizedType5_0_lower) {
            System.out.println(type);
        }
        System.out.println("-----------------------------------------------------\n");

        // 第七个参数，Map<? extends TestReflect,? super TestReflect>
        Type type6 = types[6];
        Type[] parameterizedType6 = ((ParameterizedType) type6).getActualTypeArguments();
        Type[] parameterizedType6_0_upper = ((WildcardType) parameterizedType6[0]).getUpperBounds();
        Type[] parameterizedType6_0_lower = ((WildcardType) parameterizedType6[0]).getLowerBounds();
        Type[] parameterizedType6_1_upper = ((WildcardType) parameterizedType6[1]).getUpperBounds();
        Type[] parameterizedType6_1_lower = ((WildcardType) parameterizedType6[1]).getLowerBounds();
        for (Type type : parameterizedType6_0_upper) {
            System.out.println(type);
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_0_lower) {
            System.out.println(type);
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_1_upper) {
            System.out.println(type);
        }
        System.out.println("*******************");
        for (Type type : parameterizedType6_1_lower) {
            System.out.println(type);
        }
        System.out.println("-----------------------------------------------------\n");


        TypeVariable type7 = (TypeVariable) types[7];
        System.out.println(type7);
        System.out.println(type7.getGenericDeclaration());

        TypeVariable type8 = (TypeVariable) types[8];
        System.out.println(type8);
        Type[] bounds = type8.getBounds();
        for(Type t: bounds) {
            System.out.println(t);
        }
    }


    public static void main(String[] args) throws Exception {
        TypeVariable<Class<A>>[] typeParameters = A.class.getTypeParameters();
        for(TypeVariable<Class<A>> typeVariable : typeParameters){
            System.out.println(typeVariable);
        }

        List<String> list = new ArrayList<>();
        List list1 = (AbstractList<String>)list;

        Method[] methods = TestType.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method testMethod = methods[i];
            if (testMethod.getName().equals("test")) {
                show(testMethod);
            }
        }
    }

}

class A<T> {

    public T[] ts;

    public A(T[] ts) {
        this.ts = ts;
    }
}