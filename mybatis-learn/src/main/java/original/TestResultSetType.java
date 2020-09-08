package original;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/27
 */
public class TestResultSetType {

    public static void main(String[] args) throws Exception {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet query = null;

        try {

            String sql = "select STUDENT.SNO, STUDENT.SNAME, STUDENT.SSEX, STUDENT.SBIRTHDAY, STUDENT.CLASS from STUDENT";

//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


            con = DriverManager.getConnection("jdbc:mysql://188.131.246.195:3306/mybatis_learn", "root", "601220zjh...");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@10.88.26.91:1521:focnew", "focnew", "focnew#123");

            /**
             * 测试数据库是否支持 ResultSetType 类型
             */
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

//            Statement statement1 = con.createStatement();
//            ResultSet resultSet = statement1.executeQuery(sql);


            statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            /**
             * 这个地方必须配置为1，否则不会当第一次执行query.next()的时候，数据库驱动会一次性取出多条数据
             */
            statement.setFetchSize(1);

            query = statement.executeQuery();
            System.out.println(statement.getResultSetType());

            /**
             * queryType有可能会发生降级，比如使用 select * from 的时候。具体需要查看数据文档，比如 oracle10.2 的文档如下
             * https://docs.oracle.com/cd/B19306_01/java.102/b14355/resltset.htm#i1023588
             */
            System.out.println(query.getType());
            System.out.println("modify fetch size: " + statement.getFetchSize());

            int i = 0;
            while(query.next()){
                if(i == 0){
                    Thread.sleep(20000);
                    i++;
                }
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