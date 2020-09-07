package pojo;

import java.util.Date;

public class Student {

    private String sno;
    private String sname;
    private String ssex;
    private Date sbirthday;
    private String clazz;

    public Student(String sno, String sname, String ssex) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
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
}
