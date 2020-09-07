package classpath;

/**
 * @author 01395265
 */
public class TestClasspath {



    public static void main(String[] args) {


        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(TestClasspath.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));


        System.out.println(TestClasspath.class.getResource("/").getPath());
    }

}
