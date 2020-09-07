package jdkclass.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.junit.Test;


public class TestSerializableReadObjectNoData implements Serializable{

    private String path = "src/test/java/jdkclass/io/ReadObjectNoDataFile";

    /***
     * @description: 序列化时不让TestBean继承BaseBean
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test1() throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new TestBean("TestBean"));
        objectOutputStream.close();

    }


    /***
     * @description: 反序列化时让TestBean继承BaseBean
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/7/31
     */
    @Test
    public void test2() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        TestBean o = (TestBean)objectInputStream.readObject();
        System.out.println(o);

        objectInputStream.close();

    }


    class TestBean extends BaseBean implements Serializable {

        public String property1;

        public TestBean(String property1) {
            this.property1 = property1;
        }

        public TestBean() {
        }

        public String getProperty1() {
            return property1;
        }

        public void setProperty1(String property1) {
            this.property1 = property1;
        }

        @Override
        public String toString() {
            return "TestBean{" +
                "property1='" + property1 + '\'' +
                '}' + super.toString();
        }
    }


    class BaseBean implements Serializable {

        public String property2;

        public BaseBean(String property2) {
            this.property2 = property2;
        }

        public BaseBean() {
        }

        public String getProperty2() {
            return property2;
        }

        public void setProperty2(String property2) {
            this.property2 = property2;
        }

        private void readObjectNoData() throws ObjectStreamException {
            this.property2 = "readObject ....";
        }

        @Override
        public String toString() {
            return "BaseBean{" +
                "property2='" + property2 + '\'' +
                '}';
        }
    }

}