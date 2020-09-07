package headfirst._18_prototype.deepcopy;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;   // 姓名
    private int age;       // 年龄
    private StringBuffer sex;  // 性别

    public Student(String name, int age, StringBuffer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StringBuffer getSex() {
        return sex;
    }

    public void setSex(StringBuffer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }

}
