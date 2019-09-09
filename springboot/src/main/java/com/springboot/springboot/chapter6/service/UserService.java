package com.springboot.springboot.chapter6.service;

import com.springboot.springboot.chapter6.pojo.User;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 21:08
 * @Version 1.0
 */
public interface UserService {
    public User getUser(Long id);
    public int insertUser(User user);
}
