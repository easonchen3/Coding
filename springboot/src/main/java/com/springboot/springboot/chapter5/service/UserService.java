package com.springboot.springboot.chapter5.service;

import com.springboot.springboot.chapter5.dao.UserDao;
import com.springboot.springboot.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 22:47
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Long id){
        return userDao.getUser(id);
    }
}
