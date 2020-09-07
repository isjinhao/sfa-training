package jdkclass.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/10
 */
public class TestFileInputStream {

    String path = "src\\test\\java\\jdkclass\\io\\";


    /**
     * @return void
     * @description: TODO
     * @params: args
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test1() throws IOException {
        // 使用File对象创建流对象
        File file = new File(path + "a.txt");
        FileInputStream fis1 = new FileInputStream(file);

        // 使用文件名称创建流对象
        FileInputStream fis2 = new FileInputStream(path + "b.txt");
    }

    /**
     * @return void
     * @description: 读取字节
     * @params:
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test2() throws IOException {
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream(path + "read.txt");
        // 定义变量，保存数据
        int b;
        // 循环读取
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        // 关闭资源
        fis.close();
    }

    /**
     * @return void
     * @description: 使用字节数组读取
     * @params:
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test3() throws IOException {
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream(path + "read.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while ((len = fis.read(b)) != -1) {
            // 每次读取后,把数组变成字符串打印
            System.out.println(new String(b));
        }
        // 关闭资源
        fis.close();
    }

    /**
     * @description: 获取有效的字节
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    public void test4() throws IOException {
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        // 循环读取
        while ((len = fis.read(b)) != -1) {
            // 每次读取后,把数组的有效字节部分，变成字符串打印
            System.out.println(new String(b, 0, len));//  len 每次读取的有效字节个数
        }
        // 关闭资源
        fis.close();
    }

}
