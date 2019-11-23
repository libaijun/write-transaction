package com.lbj.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: lbj
 * @create: 2019-11-23 12:47
 */
@Component
public class ConnectionManager {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    @Resource
    private DataSource dataSource;

    public Connection getConnection() {
        Connection connection = this.connectionThreadLocal.get();
        if (null == connection) {
            try {
                Connection connection1 = dataSource.getConnection();
                connectionThreadLocal.set(connection1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.connectionThreadLocal.get();
    }
}
