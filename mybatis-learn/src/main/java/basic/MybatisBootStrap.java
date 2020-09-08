package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Student;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/27
 */
public class MybatisBootStrap {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);

            /**
             * SqlSessionFactoryBuilder: 这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，
             * 就不再需要它了。 因此其实例的最佳作用域是方法作用域（也就是局部方法变量）。
             */
            /**
             * SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。
             * 使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，多次重建 SqlSessionFactory 被
             * 视为一种代码“坏习惯”。因此 SqlSessionFactory 的最佳作用域是应用作用域。
             */

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            /**
             * 每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，
             * 所以它的最佳的作用域是请求或方法作用域。
             */
            SqlSession sqlSession = sqlSessionFactory.openSession();

//            List<Student> objects = sqlSession.selectList("selectAll");
//            System.out.println(objects);

            try {
                /**
                 * XXXMapper被称为映射器，他们是一些绑定映射语句的接口。虽然从技术层面上来讲，任何映射器实例的最大作用域与
                 * 请求它们的 SqlSession 相同。但方法作用域才是映射器实例的最合适的作用域。就是说，映射器实例应该在调用
                 * 它们的方法中被获取，使用完毕之后即可丢弃。 映射器实例并不需要被显式地关闭。尽管在整个请求作用域保留映射器实例
                 * 不会有什么问题，但是你很快会发现，在这个作用域上管理太多像 SqlSession 的资源会让你忙不过来。 因此，最好将映射器放在方法作用域内。
                 */
                StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
                List<Student> students = studentMapper.selectAll();
                System.out.println(students);
            } finally {
                sqlSession.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
