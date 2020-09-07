package pojo;

import java.util.Date;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/27
 */

public class Student {

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
