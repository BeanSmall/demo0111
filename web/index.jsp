<%@ page import="com.bdqn.zhang.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bdqn.zhang.util.Page" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/11
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <link rel="stylesheet" href="./static/css/bootstrap.css">
    <style>
        h4 {
            color: red;
        }
        #tab {
            width: 600px;
        }

        td {
            text-align: center;
        }

        p {
            text-align: center;
        }
    </style>
</head>
<body>

<table id="tab" align="center" class="table table-hover table-bordered">
    <tr>
        <td colspan="5">
            <!--text-center  文本居中 -->
            <h1 class="text-center">关键词信息列表</h1>
        </td>
    </tr>
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>性别</td>
        <td>日期</td>
        <td>操作</td>
    </tr>
    <%
        Page pp = (Page)request.getSession().getAttribute("page");
        List<Student> students = pp.getList();
        if(students != null && students.size() > 0){
              for (Student s:students) {
    %>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getBirthday()%></td>
            <td><%=s.getSex()%></td>
            <td>操作</td>
        </tr>
    <%
              }
        }
    %>


</table>
<p>
    <a href="index_control.jsp?pageSize=10&currentPage=1">首页</a>
    <%
        if(pp.getCurrentPage() == 1){
        } else {
    %>
    <a href="index_control.jsp?pageSize=10&currentPage=<%=pp.getCurrentPage()-1%>">上一页</a>
    <%
        }
    %>

    <%
        if(pp.getCurrentPage() == pp.getTotalPage()){
        } else {
    %>
    <a href="index_control.jsp?pageSize=10&currentPage=<%=pp.getCurrentPage()+1%>">下一页</a>
    <%
        }
    %>
    <a href="index_control.jsp?pageSize=10&currentPage=<%=pp.getTotalPage()%>">末页</a>
</p>
</body>
</html>
