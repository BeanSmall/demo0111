package com.bdqn.zhang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	// 静态代码块
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("驱动已加载！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取连接
	public static Connection getConnecton(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/s2?useUnicode=true&characterEncoding=utf8", "root", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	// 关闭连接的方法
	public void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 封装 增 删 改
	public int executeUpdate(String sql, Object[] objs) {
		Connection conn = getConnecton();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 绑定参数
			if(objs != null) {
				for (int i = 0; i < objs.length; i++) {
					pstmt.setObject(i+1, objs[i]);
				}
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return 0;
	}
}
