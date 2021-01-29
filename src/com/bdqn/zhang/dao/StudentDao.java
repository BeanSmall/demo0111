package com.bdqn.zhang.dao;

import com.bdqn.zhang.pojo.Student;

import java.util.List;

public interface StudentDao {
    // 分页查询所有学生
    List<Student> getStudents(Integer currentPage,Integer pageSize);

    // 查询所有记录数
    int getCount();

    // 查询
    Student getStudentById(int id);

    //  增加
    int saveStudent(Student student);

    // 删除
    int delStudent(int id);

    ///修改
    int updateStudent(Student student);
}
