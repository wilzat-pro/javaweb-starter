package servlets;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ServletDemo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo.service");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Student> list = new ArrayList<>();
        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/webdemo";

        // 用户名 密码
        String username = "root";
        String pwd = "123456";

        // sql语句，使用数据库的student表
        String sql = "SELECT * FROM student";
        try {
            connection = DriverManager.getConnection(url, username, pwd);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer stuid = (Integer) resultSet.getObject("stuid");
                String name = (String) resultSet.getObject("name");
                String sex = (String) resultSet.getObject("sex");
                Integer age = (Integer) resultSet.getObject("age");
                Student stu = new Student(stuid, name, sex, age);
                list.add(stu);
            }

            resultSet.close();
            statement.close();
            connection.close();

            req.setAttribute("list", list);

        }catch (Exception e) {
            System.out.println("出现错误：" + e.getMessage());
        }
    }
}
