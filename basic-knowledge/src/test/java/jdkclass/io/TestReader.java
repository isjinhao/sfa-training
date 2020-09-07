package jdkclass.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/10
 */
public class TestReader {


    String path = "src\\test\\java\\jdkclass\\io\\";

    /**
     * @return void
     * @description: 构造方法
     * @params:
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test1() throws IOException {
        // 使用File对象创建流对象
        File file = new File(path + "a.txt");
        FileReader fr1 = new FileReader(file);

        // 使用文件名称创建流对象
        FileReader fr2 = new FileReader(path + "b.txt");
    }


    /**
     * @return void
     * @description: 读取字符
     * @params:
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test2() throws IOException {
        // 使用文件名称创建流对象
        FileReader fr = new FileReader(path + "read.txt");
        // 定义变量，保存数据
        int b;
        // 循环读取
        while ((b = fr.read()) != -1) {
            System.out.println((char) b);
        }
        // 关闭资源
        fr.close();
    }


    /**
     * @return void
     * @description: 使用字符数组读取
     * @params:
     * @author: 01395265
     * @date: 2020/8/10
     */
    @Test
    public void test3() throws IOException {
        // 使用文件名称创建流对象
        FileReader fr = new FileReader(path + "read.txt");
        // 定义变量，保存有效字符个数
        int len;
        // 定义字符数组，作为装字符数据的容器
        char[] cbuf = new char[2];
        // 循环读取
        while ((len = fr.read(cbuf)) != -1) {
            System.out.println(new String(cbuf, 0, len));
        }
        // 关闭资源
        fr.close();
    }


    @Test
    public void test4() throws IOException {
        String FileName = path + "test.txt";

        // 创建流对象，默认UTF8编码
        InputStreamReader isr =
            new InputStreamReader(new FileInputStream(FileName));
        // 创建流对象,指定GBK编码
        InputStreamReader isr2 =
            new InputStreamReader(new FileInputStream(FileName) , "GBK");
        // 定义变量,保存字符
        int read;
        // 使用默认编码字符流读取
        while ((read = isr.read()) != -1) {
            System.out.print((char)read); // ��Һ�
        }
        isr.close();
        System.out.println();

        // 使用指定编码字符流读取,乱码
        while ((read = isr2.read()) != -1) {
            System.out.print((char)read);	// 大家好
        }
        isr2.close();
    }



}
