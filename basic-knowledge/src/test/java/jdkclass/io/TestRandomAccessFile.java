package jdkclass.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/6
 */
public class TestRandomAccessFile {

    /**
     * @return void
     * @description: 读文件；
     * seek();  可以设置超出，超出后就读不到数据了
     * @params:
     * @author: 01395265
     * @date: 2020/8/7
     */
    @Test
    public void test1() throws IOException {
        String filePath = "src/test/java/jdkclass/io/test.txt";
        RandomAccessFile raf = null;
        File file;
        try {
            file = new File(filePath);
            raf = new RandomAccessFile(file, "r");
            // 移动文件记录指针的位置
            raf.seek(5);

            byte[] b = new byte[1024];
            int hasRead;
            // 循环读取文件
            while ((hasRead = raf.read(b)) > 0) {
                // 输出文件读取的内容
                System.out.print(new String(b, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            raf.close();
        }
    }

    /**
     * @return void
     * @description: 写文件，
     * @params:
     * @author: 01395265
     * @date: 2020/8/7
     */
    @Test
    public void test2() throws IOException {
        String filePath = "src/test/java/jdkclass/io/test.txt";
        RandomAccessFile raf = null;
        File file;
        try {
            file = new File(filePath);
            // 以读写的方式打开一个RandomAccessFile对象
            raf = new RandomAccessFile(file, "rw");
            // 将记录指针移动到该文件的最后
            raf.seek(raf.length());
            // 向文件末尾追加内容
            raf.write("这是追加内容。。".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            raf.close();
        }
    }


    /**
     * 插入文件指定位置的指定内容
     */
    @Test
    public void test3() throws IOException {

        String filePath = "src/test/java/jdkclass/io/test.txt";
        long pos = 5;
        String insertContent = "插入指定位置指定内容";

        RandomAccessFile raf;
        File tmp = File.createTempFile("tmp", ".txt", new File("src/test/java/jdkclass/io"));

        try {
            /**
             * 以读写的方式打开一个RandomAccessFile对象
             */
            raf = new RandomAccessFile(new File(filePath), "rw");
            /**
             * 创建一个临时文件来保存插入点后的数据
             */
            FileOutputStream fileOutputStream = new FileOutputStream(tmp);
            FileInputStream fileInputStream = new FileInputStream(tmp);
            //把文件记录指针定位到pos位置
            raf.seek(pos);
            //------下面代码将插入点后的内容读入临时文件中保存-----
            byte[] bbuf = new byte[64];
            //用于保存实际读取的字节数据
            int hasRead = 0;
            //使用循环读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) != -1) {
                //将读取的内容写入临时文件
                fileOutputStream.write(bbuf, 0, hasRead);
            }
            //-----下面代码用于插入内容 -----
            //把文件记录指针重新定位到pos位置
            raf.seek(pos);
            //追加需要插入的内容
            raf.write(insertContent.getBytes());
            //追加临时文件中的内容
            while ((hasRead = fileInputStream.read(bbuf)) != -1) {
                //将读取的内容写入临时文件
                raf.write(bbuf, 0, hasRead);
            }
        } catch (Exception e) {
            throw e;
        }

        /**
         * 在Java虚拟机正常退出时，删除这个文件
         */
        tmp.deleteOnExit();

    }

}