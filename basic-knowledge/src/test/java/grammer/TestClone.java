package grammer;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/7
 */
public class TestClone {

    public static void main(String[] args) {

        Student student = new Student("张三", 12);

        try {
            Object clone = student.clone();

            student.setAge(123);

            System.out.println(clone);

            System.out.println(student);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    static class Student implements Cloneable {
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        }
    }

}
