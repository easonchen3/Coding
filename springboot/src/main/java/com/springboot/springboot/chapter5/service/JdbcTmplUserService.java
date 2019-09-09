package com.springboot.springboot.chapter5.service;

import com.springboot.springboot.chapter5.pojo.User;

import java.util.List;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 21:28
 * @Version 1.0
 */
public interface JdbcTmplUserService {

    public User getUserUser(Long id);

    public List<User> findUsers(String userName,String note);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(Long id);
}
