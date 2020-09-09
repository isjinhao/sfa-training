package jdkclass.uri;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/9
 */
public class TestURL {

    /**
     * windows下文件的URL表示
     * @throws MalformedURLException
     */
    @Test
    public void test1() throws MalformedURLException {

        String urlPath = "file:///E:\\notes\\README.md";

        URL url = new URL(urlPath);

        System.out.println(url.getProtocol());

        // ?后面的那些东西，HTTP协议中很常见
        System.out.println(url.getQuery());

        // 资源的路径
        System.out.println(url.getPath());

        // url.getPath() + url.getQuery()
        System.out.println(url.getFile());

        // toString() 内部的实现就是 toExternalForm()
        // 文件外部表示和指定的path有一定的差距
        System.out.println(url.toExternalForm());

    }

}
