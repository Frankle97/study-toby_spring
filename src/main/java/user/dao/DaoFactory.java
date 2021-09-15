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

    @Bean
    public ConnectionMaker getConnection() {
        return new DConnectionMaker();
    }
}
