package com.bdqn.zhang.service.impl;

import com.bdqn.zhang.dao.StudentDao;
import com.bdqn.zhang.dao.impl.StudentDaoImpl;
import com.bdqn.zhang.pojo.Student;
import com.bdqn.zhang.service.StudentService;
import com.bdqn.zhang.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();


    @Override
    public Page getStudentsByPage(Integer currentPage,Integer pageSize) {
        int count = studentDao.getCount();
        List<Student> students = studentDao.getStudents(currentPage, pageSize);
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setTotal(count);
        page.setTotalPage();
        page.setList(students);
        page.setCurrentPage(currentPage);
        return page;
    }

    @Override
    public List<Student> getStudents(Integer currentPage,Integer pageSize) {
        return studentDao.getStudents(currentPage,pageSize);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public int delStudent(int id) {
        return 0;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }
}
