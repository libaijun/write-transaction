package com.lbj.test;

import com.lbj.entity.User;
import com.lbj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author: lbj
 * @create: 2019-11-23 13:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartApplication.class})
public class TestTransaction {

    @Test
    public void testSpringBootJunit() {
        System.out.println("=====hello spring boot junit=======");
    }

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setAddress("越秀区");
        user.setAge(34);
        user.setName("黄飞翔");
        try {
            userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
