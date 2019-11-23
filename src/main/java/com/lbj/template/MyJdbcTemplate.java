package com.lbj.template;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: lbj
 * @create: 2019-11-23 12:46
 */
@Component
public class MyJdbcTemplate {
    @Resource
    private ConnectionManager connectionManager;

    // 要throws exception
    public void execute(String sql) throws SQLException {

        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.execute();

    }
}
