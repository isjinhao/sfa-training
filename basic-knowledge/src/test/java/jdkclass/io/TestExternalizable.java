package jdkclass.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class TestExternalizable {


    @Test
    public void test1() throws Exception {
        Person person = new Person("aaa", 12, new BigDecimal("12.2"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(person);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Person person1 = (Person) objectInputStream.readObject();
        System.out.println(person1);
    }


}

class Person implements Externalizable {

    private String name;
    private int age;
    private BigDecimal height;

    public Person() {
    }

    public Person(String name, int age, BigDecimal height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal is called");
        out.writeUTF(name);
        out.write(age);
        out.writeObject(height);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal is called");
        name = in.readUTF();
        age = in.read();
        height = (BigDecimal) in.readObject();
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", height=" + height +
            '}';
    }
}