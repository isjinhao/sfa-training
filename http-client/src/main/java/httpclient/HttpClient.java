package httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import pojo.FailedCourse;
import pojo.Student;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/29
 */
public class HttpClient {

    public static void httpPostWithJson(String json, String url) throws IOException {

        CloseableHttpClient aDefault = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(60000)
            .setConnectTimeout(60000)
            .setConnectionRequestTimeout(60000)
            .build();

        try {
            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);

            // 设置发送的数据
            StringEntity s = new StringEntity(json);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setHeader("Content-Type", "application/json; charset=UTF-8");
            post.setEntity(s);
            // 获取返回值
            CloseableHttpResponse res = aDefault.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {                //关闭流并释放资源
                aDefault.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test1() throws Exception {

        FailedCourse failedCourse = new FailedCourse("123", "234");
        List<FailedCourse> failedCourses = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            failedCourses.add(failedCourse);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(failedCourses);
        System.out.println(json);
        HttpClient.httpPostWithJson(json, "http://localhost:8084/planning/student/insertbatchwithprimarykey");

    }

    @Test
    public void test2() throws Exception {

        Student student = new Student("123", "234", "男");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(student);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(students);
        System.out.println(json);
        HttpClient.httpPostWithJson(json, "http://localhost:8084/planning/student/insertbatchwithoutprimarykey");

    }

}
