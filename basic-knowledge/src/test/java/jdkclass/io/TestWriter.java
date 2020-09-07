package jdkclass.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/12
 */
public class TestWriter {

    private String path = "src\\test\\java\\jdkclass\\io\\";

    @Test
    public void test1() throws Exception {
        // 使用File对象创建流对象
        File file = new File(path + "writer.txt");
        FileWriter fw1 = new FileWriter(file);

        // 使用文件名称创建流对象
        FileWriter fw2 = new FileWriter(path + "writer.txt");
    }

    @Test
    public void test2() throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(path + "writer.txt");
        // 写出数据
        fw.write(97); // 写出第1个字符
        fw.write('b'); // 写出第2个字符
        fw.write('C'); // 写出第3个字符
        fw.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。
        fw.close();
    }


    @Test
    public void test3() throws IOException {

        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(path + "writer.txt", true);
        // 字符串转换为字节数组
        char[] chars = "社会主义核心价值观".toCharArray();

        // 写出字符数组
        fw.write(chars); // 社会主义核心价值观

        // 关闭资源
        fw.close();

    }

    @Test
    public void test4() throws IOException {

        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(path + "writer.txt", true);
        String msg = "社会主义核心价值观";

        // 写出字符数组
        fw.write(msg); // 社会主义核心价值观

        // 关闭资源
        fw.close();

    }

    @Test
    public void test5() throws IOException {

        // 使用文件名称创建流对象，可以续写数据
        FileWriter fw = new FileWriter(path + "writer.txt", true);
        // 写出字符串
        fw.write("社会");
        // 写出换行
        fw.write("\r\n");
        // 写出字符串
        fw.write("主义核心价值观");
        // 关闭资源
        fw.close();

    }



    @Test
    public void test6() throws IOException {

        // 定义文件路径
        String FileName = path + "writer.txt";
        // 创建流对象，默认UTF8编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
        // 写出数据
        osw.write("你好"); // 保存为6个字节
        osw.close();

        // 定义文件路径
        String FileName2 = path + "writer2.txt";
        // 创建流对象，指定GBK编码
        OutputStreamWriter osw2 =
            new OutputStreamWriter(new FileOutputStream(FileName2), "GBK");
        // 写出数据
        osw2.write("你好");    // 保存为4个字节
        osw2.close();

    }





}
