package jdkclass.collection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/30
 */
public class TestTreeMap {


    static ClassRepresent[] classRepresents = new ClassRepresent[12];

    static {
        String utilPackage = "java.util";
        String langPackage = "java.lang";
        classRepresents[1] = new ClassRepresent(utilPackage, "Map", 1);
        classRepresents[2] = new ClassRepresent(utilPackage, "Collection", 1);
        classRepresents[3] = new ClassRepresent(utilPackage, "Map", 2);
        classRepresents[4] = new ClassRepresent(utilPackage, "Collection", 2);
        classRepresents[5] = new ClassRepresent(utilPackage, "Comparator", 1);
        classRepresents[6] = new ClassRepresent(langPackage, "String", 1);
        classRepresents[7] = new ClassRepresent(langPackage, "Integer", 1);
        classRepresents[8] = new ClassRepresent(langPackage, "Double", 1);
        classRepresents[9] = new ClassRepresent(langPackage, "String", 2);
        classRepresents[10] = new ClassRepresent(langPackage, "Integer", 2);
        classRepresents[11] = new ClassRepresent(langPackage, "Integer", 3);
    }


    /**
     * 这样做只有去重的功能，没有查找的功能了
     */
    @Test
    public void test2() {

        Integer integer = 1;

        Map<ClassRepresent, Integer> map = new TreeMap<>((o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (Objects.equals(o1.getFullPackage(), o2.getFullPackage()) && Objects.equals(o1.getName(), o2.getName())) {
                return 0;
            }
            return 1;
        });

        for (int i = 1; i < 12; i++) {
            map.put(classRepresents[i], integer++);
        }

        for (int i = 1; i < 12; i++) {
            System.out.println(map.get(classRepresents[i]));
        }

    }


    /**
     * 这样可以保留查找的功能
     */
    @Test
    public void test3() {

        Integer integer = 1;

        Map<ClassRepresent, Integer> map = new TreeMap<>(new Comparator<ClassRepresent>() {
            /**
             * 所有逻辑条件上的属性都得参与排序
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(ClassRepresent o1, ClassRepresent o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 11;
                }
                if (0 == o1.getName().compareTo(o2.getName())) {
                    return o1.getFullPackage().compareTo(o2.getFullPackage());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = 1; i < 12; i++) {
            map.put(classRepresents[i], integer++);
        }
        for (int i = 1; i < 12; i++) {
            System.out.println(map.get(classRepresents[i]));
        }

    }


    /**
     * 这样可以保留查找的功能
     */
    @Test
    public void test4() {

        Integer integer = 1;

        Map<ClassRepresent, Integer> map = new TreeMap<>(generateComparator(ClassRepresent.class, "name", "fullPackage", "version"));

        for (int i = 1; i < 12; i++) {
            map.put(classRepresents[i], integer++);
        }

        for (int i = 1; i < 12; i++) {
            System.out.println(map.get(classRepresents[i]));
        }

    }

    private <T> Comparator<T> generateComparator(Class<T> clazz, String... properties) {
        List<String> collect = Arrays.stream(properties).collect(Collectors.toList());

        int propertiesLen = properties.length;
        if (propertiesLen == 0) {
            propertiesLen = clazz.getDeclaredFields().length;
            collect = Arrays.stream(clazz.getDeclaredFields()).map(item -> item.getName()).collect(Collectors.toList());
        }

        int finalPropertiesLen = propertiesLen;
        List<String> finalCollect = collect;
        Comparator<T> tComparator = (o1, o2) -> {
            if(o1 == null && o2 == null)
                return 0;
            if(o1 == null)
                return -1;
            if(o2 == null)
                return 1;
            try {
                for (int i = 0; i < finalPropertiesLen; i++) {
                    Object filedData1 = getFiledData(clazz, finalCollect.get(i), o1);
                    Object filedData2 = getFiledData(clazz, finalCollect.get(i), o2);
                    Integer integer = compareToEqual(filedData1, filedData2);
                    if(integer != 0){
                        return integer;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        };
        return tComparator;
    }

    private Object getFiledData(Class clazz, String property, Object o) throws Exception {
        Field declaredField = clazz.getDeclaredField(property);
        declaredField.setAccessible(true);
        return declaredField.get(o);
    }

    private Integer compareToEqual(Object o1, Object o2) throws Exception {
        Method compareTo = Comparable.class.getMethod("compareTo", Object.class);
        Object invoke = compareTo.invoke(o1, o2);
        return (Integer) invoke;
    }

    static class ClassRepresent {

        private String fullPackage;
        private String name;
        private int version;

        public ClassRepresent(String fullPackage, String name, int version) {
            this.fullPackage = fullPackage;
            this.name = name;
            this.version = version;
        }

        public String getFullPackage() {
            return fullPackage;
        }

        public void setFullPackage(String fullPackage) {
            this.fullPackage = fullPackage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

}