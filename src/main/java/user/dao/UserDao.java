package user.dao;

import user.domain.User;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void add(User user) throws SQLException {
        Connection conn = dataSource.getConnection();

        PreparedStatement ps = conn.prepareStatement("insert into users(id, name, password) values (?,?,?)");
        ps.setString(1 ,user.getId());
        ps.setString(2 ,user.getName());
        ps.setString(3 ,user.getPassword());

        ps.executeUpdate();

        conn.close();
        ps.close();
    }

    public User get(String id) throws SQLException {
        Connection conn = dataSource.getConnection();

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

}