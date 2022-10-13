<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/2
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%--导入java.sql包--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>从webdemo数据库中读出student表</title>
  </head>
  <body>
<%-- ----------------------------第一种-------------------------------- --%>
        <%
          try {
            Class.forName("com.mysql.jdbc.Driver"); //驱动程序名
            String url = "jdbc:mysql://localhost:3306/webdemo"; //数据库名
            String username = "root"; //数据库用户名
            String password = "123456"; //数据库用户密码
            Connection conn = DriverManager.getConnection(url, username, password); //连接状态
            System.out.println("数据库连接成功！");

        %>

    <center>

    <table border="2">
      <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
      </tr>
        <%
          Statement stm = null;
          ResultSet rs = null;
          String sql = "SELECT * FROM student;";
          stm = conn.createStatement();
          rs = stm.executeQuery(sql);
          out.print("查询学生表如下：");
          out.print("<br/>");
          while (rs.next()) {
        %>
        <tr>
            <td><%=rs.getInt("stuid")%></td>
            <td><%=rs.getString("name")%></td>
            <td><%=rs.getString("sex")%></td>
            <td><%=rs.getString("age")%></td>
        </tr>
    </table>


    </center>
        <%
          }
          rs.close();
          stm.close();
          conn.close();
          }catch (Exception e) {
            System.out.println("-------------OH NO-------------");
            System.out.println("数据库连接失败");
            e.printStackTrace();
          }
        %>

  </body>
</html>
