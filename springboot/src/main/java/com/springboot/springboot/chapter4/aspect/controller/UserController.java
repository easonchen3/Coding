package com.springboot.springboot.chapter4.aspect.controller;

import com.springboot.springboot.chapter4.aspect.service.UserService;
import com.springboot.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.springboot.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id,String userName,String note){
        User user= new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(Long id,String userName,String note){
        User user = new User();
        user.setNote(note);
        user.setId(id);
        user.setUserName(userName);
        UserValidator userValidator = (UserValidator) userService;
        if(userValidator.validator(user)){
            userService.printUser(user);
        }
        return user;
    }
}
