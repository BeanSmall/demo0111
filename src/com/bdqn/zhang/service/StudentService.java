package com.bdqn.zhang.service;

import com.bdqn.zhang.pojo.Student;
import com.bdqn.zhang.util.Page;

import java.util.List;

public interface StudentService {

    // 查询所有学生
    Page getStudentsByPage(Integer currentPage,Integer pageSize);

    // 查询所有学生
    List<Student> getStudents(Integer currentPage,Integer pageSize);

    // 查询
    Student getStudentById(int id);

    //  增加
    int saveStudent(Student student);

    // 删除
    int delStudent(int id);

    ///修改
    int updateStudent(Student student);
}
