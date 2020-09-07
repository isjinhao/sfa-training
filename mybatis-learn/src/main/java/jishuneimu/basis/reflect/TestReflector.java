package jishuneimu.basis.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.invoker.Invoker;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/3
 */
public class TestReflector {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Student student = new Student("10086", "中国移动", "男", new Date(System.currentTimeMillis()), "大二班");

        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        Reflector studentReflector = reflectorFactory.findForClass(Student.class);

        Invoker sno = studentReflector.getGetInvoker("sno");
        Object invoke = sno.invoke(student, null);

        System.out.println(invoke);


    }
    public static class Student {

        private String sno;
        private String sname;
        private String ssex;
        private Date sbirthday;
        private String clazz;

        public Student() {
        }

        public Student(String sno, String sname, String ssex, Date sbirthday, String clazz) {
            this.sno = sno;
            this.sname = sname;
            this.ssex = ssex;
            this.sbirthday = sbirthday;
            this.clazz = clazz;
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getSsex() {
            return ssex;
        }

        public void setSsex(String ssex) {
            this.ssex = ssex;
        }

        public Date getSbirthday() {
            return sbirthday;
        }

        public void setSbirthday(Date sbirthday) {
            this.sbirthday = sbirthday;
        }

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        @Override
        public String toString() {
            return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                ", clazz='" + clazz + '\'' +
                '}';
        }
    }


}
