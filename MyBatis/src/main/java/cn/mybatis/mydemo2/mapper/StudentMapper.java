package cn.mybatis.mydemo2.mapper;


import cn.mybatis.mydemo2.domain.Student;

public interface StudentMapper {
    // 根据id查询学生信息
    Student selectStudentById(Integer id);
}
