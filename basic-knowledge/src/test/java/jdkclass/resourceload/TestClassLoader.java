package jdkclass.resourceload;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author 01395265
 */
public class TestClassLoader {

    public static void main(String[] args) throws IOException {

        // 没有指定系统类加载器
        System.out.println(System.getProperty("java.system.class.loader"));

        // 加载应用类的是应用类加载器
        System.out.println(TestClassLoader.class.getClassLoader());

        // 应用类加载器的实例
        System.out.println(ClassLoader.getSystemClassLoader());

        // 拓展类加载器的实例
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        // BootStrap类加载器为null
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());


        // 启动类加载器加载文件的位置
        System.out.println(System.getProperty("sun.boot.class.path"));
        // 拓展类加载器加载文件的位置
        System.out.println(System.getProperty("java.ext.dirs"));
        // 应用类加载器加载文件的位置
        System.out.println(System.getProperty("java.class.path"));

    }

}
