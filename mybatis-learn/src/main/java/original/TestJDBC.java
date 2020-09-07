package original;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/27
 */
public class TestJDBC {

    public static void main(String[] args) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet query = null;
        try {

            String sql = "select * from STUDENT";

            /**
             * 1、注册驱动：在使用JDBC连接连接数据库的时候，Java程序并不知道自己是否连接上了相应的
             *             数据库，所以在第一步需要注册驱动，如果连接正常则可以进行接下来的操作。也
             *             就是说注册驱动这一步是通过我们导入的jar包测试能否正常连接数据库。
             */

//            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            /**
             * 2、获得连接：数据库服务器中可能存在多个数据库，我们需要连接上我们即将使用的数据库。
             */
//            con = DriverManager.getConnection("jdbc:oracle:thin:@10.88.26.91:1521:focnew", "focnew", "focnew#123");
            con = DriverManager.getConnection("jdbc:mysql://188.131.246.195:3306/mybatis_learn", "root", "601220zjh...");

            /**
             * 3、创建Statement：如果想和数据库进行交互，一定需要使用这个类。JDK对他的解释是：
             *                 The object used for executing a static SQL statementand returning the results it produces.
             */
            statement = con.prepareStatement(sql);
            System.out.println(con.getClass());

            /**
             * 4、执行查询，获得结果集：想数据库中注入SQL语句，是我们能够进行操作
             */
            query = statement.executeQuery();

            /**
             * 5、处理结果集：query是数据库中的元组集合，可以通过循环获得每个元组
             */
            while(query.next()){
                String sno = query.getString("SNO");
                String sname = query.getString("SNAME");
                String ssex = query.getString("SSEX");
                Date sbirthday = query.getDate("SBIRTHDAY");
                String clazz = query.getString("CLASS");
                System.out.println(sno + "  " + sname + "  " + ssex + " " + sbirthday + " " + clazz);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            /**
             * 6、释放资源：操作结束后进行操作
             */
            if(query != null) {
                query.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }

}
