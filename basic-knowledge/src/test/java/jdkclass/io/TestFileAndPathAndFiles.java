package jdkclass.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/29
 */
public class TestFileAndPathAndFiles {

    /**
     * File的创建
     */
    @Test
    public void test1() {

        /**
         * 从本地磁盘获得文件
         */
        File file = new File("src\\test\\java\\jdkclass\\io\\ReadObjectNoDataFile");
        System.out.println(file.exists());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());

    }


    /**
     * 文件 或 目录的创建
      * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        File file1 = new File("src\\test\\java\\jdkclass\\io\\test1");
        file1.createNewFile();

        File file2 = new File("src\\test\\testDir");
        file2.mkdir();

        System.out.println(file1.isDirectory());
        System.out.println(file2.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file2.isFile());

    }

    /**
     * 遍历目录的一层
      */
    @Test
    public void test3() {

        File fileDir = new File("D:\\workspace\\flight_operations_control\\document\\01-工作库\\01-项目管理\\00-项目规范和模版");
        // 列出file下所有file对象
        File[] files = fileDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName();
                if (name.endsWith(".docx") || name.endsWith(".xlsx")) {
                    return true;
                }
                return false;
            }
        });
        for (File file : files) {
            System.out.println(file);
        }

    }

    /**
     * Path
     */
    @Test
    public void test4() {

        /**
         * Path是JDK7中表达路径的一个新方式，在Path中，它把文件的路径看做几个部件组成的，比如 /usr/develop/tomcat 可以被看出两个部件组成：/usr和/develop/tomcat，
         * 当然也可以看做三个部件 /usr、/develop 和 /tomcat 组成的。以根部件开始的是绝对路径，在类Unix系统中是 \ ，在Windows系统中是 C:\ 等。
         */
        /**
         * 绝对路径
         */
        Path path = Paths.get("D:\\workspace\\flight_operations_control\\document\\01-工作库\\01-项目管理\\00-项目规范和模版");
        System.out.println(path);

        /**
         * 该路径的最后一个部件
         */
        System.out.println(path.getFileName());
        /**
         * 和当前路径相等价的绝对路径
         */
        System.out.println(path.toAbsolutePath());
        /**
         * 返回父路径（没有时返回null）
         */
        System.out.println(path.getParent());
        /**
         * 返回该路径的根部件（没有时返回null）
         */
        System.out.println(path.getRoot());
        /**
         * 由Path创建一个File对象
         */
        System.out.println(path.toFile());

    }

    /**
     * 读写小型文本文件
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {

        Path path = Paths.get("src\\test\\java\\jdkclass\\io\\test1");

        /**
         * 读小型文本文件
         */
        byte[] bytes = Files.readAllBytes(path);
        String string = new String(bytes, "UTF-8");
        System.out.println(string);

        List<String> lines = Files.readAllLines(path);
        Iterator<String> iterator = lines.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        /**
         * 写小型文本文件
         */
        Files.write(path, "\n深陷琪中，钰罢不能".getBytes(),
            StandardOpenOption.APPEND);

    }

    /**
     * 文件拷贝
     */
    @Test
    public void test6() {

        Path sourcePath = Paths.get("D:\\workspace\\flight_operations_control\\document\\01-工作库\\01-项目管理\\00-项目规范和模版\\《运控系统项目管理规则及绩效考核办法》.docx");
        Path destinationPath = Paths.get("D:\\workspace\\flight_operations_control\\document\\01-工作库\\01-项目管理\\00-项目规范和模版\\《运控系统项目管理规则及绩效考核办法》-copy.docx");
        try {
            Files.copy(sourcePath, destinationPath);
        } catch(FileAlreadyExistsException e) {
            // 目录已经存在
        } catch (IOException e) {
            // 其他发生的异常
            e.printStackTrace();
        }

    }


}