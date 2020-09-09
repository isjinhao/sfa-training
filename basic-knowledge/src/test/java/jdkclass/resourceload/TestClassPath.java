package jdkclass.resourceload;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestClassPath {

    public static void main(String[] args) throws IOException {

        // 以"/"为参数加载的是classpath路径下的文件
        System.out.println(TestClassLoader.class.getResource("/").getPath());
        // 以""为参数加载的是当前class文件所在目录下的文件
        System.out.println(TestClassLoader.class.getResource("").getPath());

        // 可以加载到 TestStringBuilder.class 文件
        System.out.println(TestClassLoader.class.getResource("/jdkclass/TestStringBuilder.class").getPath());
        // NPE
//        System.out.println(TestClassLoader.class.getResource("jdkclass/TestStringBuilder.class").getPath());


        // 以""为参数加载的是classpath路径下的文件
        System.out.println(TestClassPath.class.getClassLoader().getResource(""));
        // 啥都不是，直接为null
        System.out.println(TestClassPath.class.getClassLoader().getResource("/"));

        // 类路径是一个
        Enumeration<URL> resources = TestClassPath.class.getClassLoader().getResources("jdkclass/TestStringBuilder.class");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }

        // 类路径是一个相对的概念，比如我们再两个项目的classpathtest文件夹里都有db.properties文件，就会加载到多个文件
        Enumeration<URL> resources2 = TestClassPath.class.getClassLoader().getResources("classpathtest/db.properties");
        while (resources2.hasMoreElements()) {
            URL url = resources2.nextElement();
            System.out.println(url);
        }

    }
}
