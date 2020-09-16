package basic;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/27
 */
public interface StudentMapper {

    List<Student> selectAll(@Param("list") List<String> strs);
}
