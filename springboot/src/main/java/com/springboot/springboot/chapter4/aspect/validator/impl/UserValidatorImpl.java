package com.springboot.springboot.chapter4.aspect.validator.impl;

import com.springboot.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.springboot.chapter4.pojo.User;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 17:22
 * @Version 1.0
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validator(User user) {
        System.out.println("引入了新的接口");
        return user!=null;
    }
}
