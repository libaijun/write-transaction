package com.lbj.service;

import com.lbj.annotation.MyTransactional;
import com.lbj.entity.User;
import com.lbj.template.MyJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author: lbj
 * @create: 2019-11-23 12:41
 */
@Service
public class UserService {

    @Resource
    private MyJdbcTemplate myJdbcTemplate;

    @MyTransactional    // 要throws异常才能回滚，如果被try catch那就相当于没有异常，所以不会回滚
    public void addUser(User user) throws SQLException {
        String sql = "insert into t_user(age, name, address) " +
                "values(" + user.getAge() + ",'" + user.getName() + "','" + user.getAddress() + "')";

        System.out.println(sql);
        myJdbcTemplate.execute(sql);

        String sql2 = "update t_user set age = 25 where id = 4)";   // 这里sql2多了个）
        myJdbcTemplate.execute(sql2);
        System.out.println("==========Add user completed============");
    }

}
