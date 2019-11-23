package com.lbj.controller;

import com.lbj.entity.User;
import com.lbj.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author: lbj
 * @create: 2019-11-23 13:55
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/addUser")
    public String addUser() {
        User user = new User();
        Random random = new Random();
        int i = random.nextInt(1000000);
        user.setAddress("China" + i);
        user.setAge(34);
        user.setName("LaoWang" + i);
        try {
            userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
