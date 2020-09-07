package pojo;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/29
 */

public class FailedCourse {

    private Long id;
    private String sno;
    private String cno;

    public FailedCourse(String sno, String cno) {
        this.sno = sno;
        this.cno = cno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
}
