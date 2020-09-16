package jishuneimu.basis.resolver;

import java.net.URL;
import java.net.URLClassLoader;

public class TestJarURL {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader = TestJarURL.class.getClassLoader();

        URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
        URL[] urLs = urlClassLoader.getURLs();
        URL selectedUrl = null;
        for (URL url : urLs) {
            System.out.println(url.getPath());
            if (url.getPath().contains("mybatis-3.4.6.jar")) {
                String file = url.getFile();
                System.out.println(file);
                URL url1 = new URL(selectedUrl, file);
                System.out.println(url1);
            }
            selectedUrl = url;
        }
    }
}
