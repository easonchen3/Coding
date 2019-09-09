package com.springboot.springboot.chapter3.service;

import com.springboot.springboot.chapter3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:38
 * @Version 1.0
 */
@Service
public class UserService {

    public void printUser(User user){
        System.out.println("编号："+user.getId());
        System.out.println("用户名称："+user.getUserName());
        System.out.println("备注："+user.getNote());
    }
}
