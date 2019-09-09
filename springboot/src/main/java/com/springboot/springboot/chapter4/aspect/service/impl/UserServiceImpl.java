package com.springboot.springboot.chapter4.aspect.service.impl;

import com.springboot.springboot.chapter4.aspect.service.UserService;
import com.springboot.springboot.chapter4.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:48
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if(user == null){
            throw new RuntimeException("检查用户参数为空");
        }
        System.out.println("id ="+user.getId());
        System.out.println("username ="+user.getUserName());
        System.out.println("note = "+user.getNote());
    }
}
