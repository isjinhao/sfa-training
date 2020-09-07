package jdkclass.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import org.junit.Test;

public class TestSerializable implements Serializable {

    /**
     * Serializability of a class is enabled by the class implementing the java.io.Serializable interface. Classes that
     * do not implement this interface will not have any of their state serialized or deserialized. All subtypes of a
     * serializable class are themselves serializable. The serialization interface has no methods or fields and serves
     * only to identify the semantics of being serializable.
     *
     * To allow subtypes of non-serializable classes to be serialized, the subtype may assume responsibility for saving
     * and restoring the state of the supertype's public, protected, and (if accessible) package fields. The subtype
     * may assume this responsibility only if the class it extends has an accessible no-arg constructor to initialize
     * the class's state. It is an error to declare a class Serializable if this is not the case. The error will be
     * detected at runtime.
     *
     * During deserialization, the fields of non-serializable classes will be initialized using the public or protected
     * no-arg constructor of the class. A no-arg constructor must be accessible to the subclass that is serializable.
     * The fields of serializable subclasses will be restored from the stream.
     *
     * When traversing a graph, an object may be encountered that does not support the Serializable interface. In this case
     * the NotSerializableException will be thrown and will identify the class of the non-serializable object.
     *
     * Classes that require special handling during the serialization and deserialization process must implement special
     * methods with these exact signatures:
     *    private void writeObject(java.io.ObjectOutputStream out)
     *        throws IOException
     *    private void readObject(java.io.ObjectInputStream in)
     *        throws IOException, ClassNotFoundException;
     *    private void readObjectNoData()
     *        throws ObjectStreamException;
     *
     * The writeObject method is responsible for writing the state of the object for its particular class so that the
     * corresponding readObject method can restore it. The default mechanism for saving the Object's fields can be invoked
     * by calling out.defaultWriteObject. The method does not need to concern itself with the state belonging to its
     * superclasses or subclasses. State is saved by writing the individual fields to the ObjectOutputStream using the
     * writeObject method or by using the methods for primitive data types supported by DataOutput.
     *
     * The readObject method is responsible for reading from the stream and restoring the classes fields. It may call
     * in.defaultReadObject to invoke the default mechanism for restoring the object's non-static and non-transient fields.
     * The defaultReadObject method uses information in the stream to assign the fields of the object saved in the stream
     * with the correspondingly named fields in the current object. This handles the case when the class has evolved to add
     * new fields. The method does not need to concern itself with the state belonging to its superclasses or subclasses.
     * State is saved by writing the individual fields to the ObjectOutputStream using the writeObject method or by using
     * the methods for primitive data types supported by DataOutput.
     *
     * The readObjectNoData method is responsible for initializing the state of the object for its particular class in
     * the event that the serialization stream does not list the given class as a superclass of the object being deserialized.
     * This may occur in cases where the receiving party uses a different version of the deserialized instance's class than
     * the sending party, and the receiver's version extends classes that are not extended by the sender's version. This may
     * also occur if the serialization stream has been tampered; hence, readObjectNoData is useful for initializing
     * deserialized objects properly despite a "hostile" or incomplete source stream.
     *
     * Serializable classes that need to designate an alternative object to be used when writing an object to the
     * stream should implement this special method with the exact signature:
     *    ANY-ACCESS-MODIFIER Object writeReplace() throws ObjectStreamException;
     *
     * This writeReplace method is invoked by serialization if the method exists and it would be accessible from
     * a method defined within the class of the object being serialized. Thus, the method can have private, protected
     * and package-private access. Subclass access to this method follows java accessibility rules.
     *
     * Classes that need to designate a replacement when an instance of it is read from the stream should implement
     * this special method with the exact signature.
     *    ANY-ACCESS-MODIFIER Object readResolve() throws ObjectStreamException;
     *
     * This readResolve method follows the same invocation rules and accessibility rules as writeReplace.
     * The serialization runtime associates with each serializable class a version number, called a serialVersionUID,
     * which is used during deserialization to verify that the sender and receiver of a serialized object have loaded
     * classes for that object that are compatible with respect to serialization. If the receiver has loaded a class
     * for the object that has a different serialVersionUID than that of the corresponding sender's class, then
     * deserialization will result in an InvalidClassException. A serializable class can declare its own serialVersionUID
     * explicitly by declaring a field named "serialVersionUID" that must be static, final, and of type long:
     *    ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
     *
     * If a serializable class does not explicitly declare a serialVersionUID, then the serialization runtime
     * will calculate a default serialVersionUID value for that class based on various aspects of the class, as
     * described in the Java(TM) Object Serialization Specification. However, it is strongly recommended that all
     * serializable classes explicitly declare serialVersionUID values, since the default serialVersionUID
     * computation is highly sensitive to class details that may vary depending on compiler implementations,
     * and can thus result in unexpected InvalidClassExceptions during deserialization. Therefore, to guarantee
     * a consistent serialVersionUID value across different java compiler implementations, a serializable class
     * must declare an explicit serialVersionUID value. It is also strongly advised that explicit serialVersionUID
     * declarations use the private modifier where possible, since such declarations apply only to the immediately
     * declaring class--serialVersionUID fields are not useful as inherited members. Array classes cannot declare an
     * explicit serialVersionUID, so they always have the default computed value, but the requirement for matching
     * serialVersionUID values is waived for array classes.
     * @throws Exception
     */

    /**
     * 如果 Person 不实现 Serializable，仅仅让 Student 实现序列化，会报 InvalidClassException
     */
    @Test
    public void test1() throws Exception {

        Student student = new Student("haha", "CAUC");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(student);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Student student1 = (Student) objectInputStream.readObject();
        System.out.println(student1);

    }

    @Test
    public void test2() throws Exception {

        Pet pet = new Pet("dog", 1, "tone");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(pet);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Pet pet1 = (Pet) objectInputStream.readObject();
        System.out.println(pet1);

    }

    @Test
    public void test3() throws Exception {
        /**
         * 先让 Student 不继承 Person，将对象序列化到文件中
         */

        Student student = new Student();
        FileOutputStream fileOutputStream = new FileOutputStream("/test1");

        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(student);
        out.close();
        fileOutputStream.close();

//        FileInputStream fileInputStream = new FileInputStream("/test1");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Student student1 = (Student) objectInputStream.readObject();
//        System.out.println(student1);
//        fileInputStream.close();

    }

    @Test
    public void test4() throws Exception {

        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(serializableSingleton);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        SerializableSingleton serializableSingleton1 = (SerializableSingleton) objectInputStream.readObject();
        System.out.println(serializableSingleton1);
        System.out.println(serializableSingleton == serializableSingleton1);

    }

    @Test
    public void test5(){
        System.out.println(new Date().getTime());
    }


    class Person implements Serializable {

        public Person() {
        }

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                '}';
        }
    }

    class Student extends Person implements Serializable {

        private String college;

        public Student() {
            super();
        }

        public Student(String name, String college) {
            super(name);
            this.college = college;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        @Override
        public String toString() {
            return "Student{" +
                "college='" + college + '\'' +
                '}';
        }
    }

    class Pet implements Serializable {

        private String name;
        private int age;
        private String food;

        public Pet() {
        }

        public Pet(String name, int age, String food) {
            this.name = name;
            this.age = age;
            this.food = food;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void writeObject(ObjectOutputStream out)
            throws IOException {

            /**
             * 默认的序列化结果和此方法的结果一致
             */
//            out.defaultWriteObject();

            out.writeObject(name);
            out.writeInt(age);
        }

        private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {

            /**
             * 默认的反序列化结果和此方法一致
             */
//            in.defaultReadObject();

            name = (String) in.readObject();
            age = in.readInt();
        }


        @Override
        public String toString() {
            return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", food='" + food + '\'' +
                '}';
        }
    }

}


/**
 * 这个类不能被声明为内部类，因为内部类不允许存在在编译时不能确定的静态声明
 * 详见：https://blog.csdn.net/cdy1221/article/details/96309791
 */
class SerializableSingleton implements Serializable {

    private SerializableSingleton() {
    }

    /**
     * 放在内部类中，这个地方不会报错
     */
    private static final int i = 50;

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
    }

    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        System.out.println("readObject");
    }

    /**
     * writeReplace方法会在writeObject方法之前执行。
     * ObjectOutputStream会把writeReplace方法返回的对象序列化写出去。
     *
     * @return Object
     */
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace");
        return INSTANCE;
    }

    /**
     * readResolve方法会在readObject方法之后执行，可以再次修改readObject方法返回的对象数据。
     *
     * @return Object
     */
    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve");
        return INSTANCE;
    }
}