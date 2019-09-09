package com.springboot.springboot.chapter5.controller;

import com.springboot.springboot.chapter5.pojo.User;
import com.springboot.springboot.chapter5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 22:47
 * @Version 1.0
 */
@Controller
@RequestMapping("test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    @ResponseBody
    public User getUser(Long id){
        return userService.getUser(id);
    }
}
