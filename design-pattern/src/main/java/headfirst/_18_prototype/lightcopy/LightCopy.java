package headfirst._18_prototype.lightcopy;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/17
 */
public class LightCopy  {

    public static void main(String[] args) throws CloneNotSupportedException {
        School s1 = new School("实验小学", 100);
        Student stu1 = new Student("zhangsan", 20, new StringBuffer("男"));
        s1.setStu(stu1);
        School s2 = s1.clone();  // 调用重写的clone方法，clone出一个新的school---s2

        System.out.println("s1：" + s1 + " s1的hashcode：" + s1.hashCode() + "  s1中stu1的hashcode：" + s1.getStu().hashCode());
        System.out.println("s2：" + s2 + " s2的hashcode：" + s2.hashCode() + " s2中stu1的hashcode：" + s2.getStu().hashCode());

        System.out.println("s2：" + s1 + " s2的hashcode：" + s1.hashCode() + " s2中stu1的hashcode：" + s1.getStu().getSex().hashCode());
        System.out.println("s2：" + s2 + " s2的hashcode：" + s2.hashCode() + " s2中stu1的hashcode：" + s2.getStu().getSex().hashCode());
    }

}
