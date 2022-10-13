package servlets;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ServletDemo extends HttpServlet {

    public ServletDemo() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("ServletDemo.service");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Student> list = new ArrayList<>();
        // 连接数据库
        String url = "jdbc:mysql://192.168.18.76:3306/webdemo?userSSL=true&userUnicode=true&characterEncoding=utf-8";

        // 用户名 密码
        String username = "admin";
        String pwd = "Root123456!";

        // sql语句，使用数据库的student表
        String sql = "SELECT * FROM student";

        try {
            connection = DriverManager.getConnection(url, username, pwd);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long stuid = (Long) resultSet.getObject("stuid");
                String name = (String) resultSet.getObject("name");
                String sex = (String) resultSet.getObject("sex");
                Integer age = (Integer) resultSet.getObject("age");
                Student stu = new Student(stuid, name, sex, age);
                list.add(stu);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }

        req.setAttribute("demolist", list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
