package user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        ConnectionMaker connectionMaker = getConnection();
        return new UserDao(connectionMaker);
    }

    public UserDao accountDao() {
        ConnectionMaker connectionMaker = getConnection();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public UserDao messageDao() {
        ConnectionMaker connectionMaker = getConnection();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    @Bean
    public ConnectionMaker getConnection() {
        return new DConnectionMaker();
    }
}
