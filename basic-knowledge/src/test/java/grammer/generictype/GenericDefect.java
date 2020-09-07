package grammer.generictype;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/6
 */
public class GenericDefect {

    /**
     * 1、运行时类型查询只适用于原始类型
     *
     * if(a instanceof Pair<String>);	 	// error
     * Pair<String> p = (Pair<String>) a;	// error
     * ArrayList<String>.class == ArrayList<Integer> // true
     */


    /**
     * 2、不能创建一个确切的泛型类型的数组
     * 也就是说下面的这个例子是不可以的：List<String>[] ls = new ArrayList<String>[10];
     * 而使用通配符创建泛型数组是可以的，如下面这个例子：List<?>[] ls = new ArrayList<?>[10];
     * 这样也是可以的：List<String>[] ls = new ArrayList[10];
     */
    @Test
    public void test2() {
//        List<String>[] lsa = new List<String>[10]; // Not really allowed.
        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        Integer s = (Integer)lsa[1].get(0); // Run-time error: ClassCastException.
        System.out.println(s);
    }

}
