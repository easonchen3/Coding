package com.springboot.springboot.chapter6.controller;

import com.springboot.springboot.chapter6.pojo.User;
import com.springboot.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 21:11
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public Map<String,Object> insertUser(String userName,String note){
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        int update = userService.insertUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update==1);
        result.put("user",user);
        return result;
    }

}
