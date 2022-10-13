<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/9/2
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entity.Student "%>
<%@ page import="java.util.* "%>
<!DOCTYPE html>
<html>
  <head>
    <title>从webdemo数据库中读出student表</title>
  </head>
  <body>
    <div align="center">
      <h1 style="color: red;" align="center"> 所有成员信息列表</h1>
      <table width="900">
        <tr>
          <td> <h3 style="color: blue;">姓名</h3></td>
          <td><h3 style="color: blue;">学号</h3></td>
          <td><h3 style="color: blue;">性别</h3></td>
          <td><h3 style="color: blue;">年龄</h3></td>
        </tr>

        <% ArrayList<Student> demolist = (ArrayList<Student>)request.getAttribute("demolist");%>
        <%System.out.println("-------"+demolist);%>
        <% for (int i=0;i<demolist.size(); i++) {%>
        <%   Student item = demolist.get(i);   %>
          <tr>
            <td><%=item.getName()%></td>
            <td><%=item.getStuid()%></td>
            <td><%=item.getSex()%></td>
            <td><%=item.getAge()%></td>
          </tr>
        <%}%>
      </table>

    </div>
  </body>
</html>
