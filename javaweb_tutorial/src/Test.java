import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/webdemo";

        // 用户名 密码
        String username = "root";
        String pwd = "123456";

        Connection connection = DriverManager.getConnection(url, username, pwd);
        Statement statement = connection.createStatement();

        // sql语句，使用数据库的student表
        String sql = "SELECT * FROM student";

        ResultSet resultSet = statement.executeQuery(sql);

        // 需要与自己数据库里的表结构相对应
        while (resultSet.next()) {
            System.out.println("学号= " + resultSet.getObject("stuid"));
            System.out.println("姓名= " + resultSet.getObject("name"));
            System.out.println("性别= " + resultSet.getObject("sex"));
            System.out.println("年龄= " + resultSet.getObject("age"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
