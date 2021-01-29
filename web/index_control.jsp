<%@ page import="com.bdqn.zhang.service.impl.StudentServiceImpl" %>
<%@ page import="com.bdqn.zhang.service.StudentService" %>
<%@ page import="com.bdqn.zhang.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.zhang.util.Page" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/29
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    String currentPage = request.getParameter("currentPage");
    int currentPage_int = 0;
    if(currentPage == null){
        currentPage_int = 1;
    } else {
        currentPage_int = Integer.parseInt(currentPage);
    }
    StudentService studentService = new StudentServiceImpl();
    Page p = studentService.getStudentsByPage(currentPage_int,10);
    request.getSession().setAttribute("page",p);
    request.getRequestDispatcher("index.jsp").forward(request,response);
%>
</body>
</html>
