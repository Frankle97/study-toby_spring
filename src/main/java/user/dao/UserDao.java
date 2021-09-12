package user.dao;

import user.domain.User;

import java.sql.*;

public abstract class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) values (?,?,?)"
        );
        ps.setString(1 ,user.getId());
        ps.setString(2 ,user.getName());
        ps.setString(3 ,user.getPassword());

        ps.executeUpdate();

        conn.close();
        ps.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "select * from users where id = ?"
        );
        ps.setString(1 ,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));


        conn.close();
        ps.close();
        rs.close();

        return user;
    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}

class NUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/study_toby_spring", "root", "1234"
        );

        return conn;
    }
}

class DUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/study_toby_spring", "root", "1234"
        );

        return conn;
    }

}