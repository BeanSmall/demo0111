package com.bdqn.zhang.dao.impl;

import com.bdqn.zhang.dao.StudentDao;
import com.bdqn.zhang.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public List<Student> getStudents(Integer currentPage,Integer pageSize) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student limit ?,?";
        Connection conn = getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,(currentPage - 1) * pageSize);
            pstmt.setObject(2,pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                int id = rs.getInt("s_id");
                String name = rs.getString("s_name");
                Date birthday = rs.getDate("s_birth");
                String sex = rs.getString("s_sex");
                s.setId(id);
                s.setName(name);
                s.setBirthday(birthday);
                s.setSex(sex);
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        List<Student> list = new ArrayList<>();
        String sql = "select count(*) from student";
        Connection conn = getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public int saveStudent(Student student) {
        return 0;
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
