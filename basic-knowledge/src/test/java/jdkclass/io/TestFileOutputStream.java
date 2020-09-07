package jdkclass.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class TestFileOutputStream {

    String path = "src\\test\\java\\jdkclass\\io\\";


    /**
     * @description: 构造方法
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test1() throws IOException {
        // 使用File对象创建流对象
        File file = new File(path + "tmp5287590988500790599txt");
        FileOutputStream fos1 = new FileOutputStream(file);
        // 使用文件名称创建流对象
        FileOutputStream fos2 = new FileOutputStream(path + "tmp5287590988500790599txt");
    }


    /**
     * @description: 写出字节
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test2() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream(path + "fos.txt");
        // 写出数据
        fos.write(97); // 写出第1个字节
        fos.write(98); // 写出第2个字节
        fos.write(99); // 写出第3个字节
        // 关闭资源
        fos.close();
    }

    /**
     * @description: 写出字节数组
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    public void test3() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream(path + "fos.txt");
        // 字符串转换为字节数组
        byte[] b = "社会主义核心价值观".getBytes();
        // 写出字节数组数据
        fos.write(b);
        // 关闭资源
        fos.close();
    }

    /**
     * @description: 写出指定长度字节数组
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test4() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream(path + "fos.txt");
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b,2,2);
        // 关闭资源
        fos.close();
    }


    /**
     * @description: 数据追加续写
     * @params: args
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test5() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream(path + "fos.txt", true);
        // 字符串转换为字节数组
        byte[] b = "abcde".getBytes();
        // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
        fos.write(b);
        // 关闭资源
        fos.close();
    }


    /**
     * @description: 写出换行
     * @params: args
     * @return void
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test6() throws IOException {
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream(path + "fos.txt");
        // 定义字节数组
        byte[] words = {97,98,99,100,101};
        // 遍历数组
        for (int i = 0; i < words.length; i++) {
            // 写出一个字节
            fos.write(words[i]);
            // 写出一个换行, 换行符号转成数组写出
            fos.write("\r\n".getBytes());
        }
        // 关闭资源
        fos.close();
    }


}