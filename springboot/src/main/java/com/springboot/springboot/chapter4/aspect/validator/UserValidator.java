package com.springboot.springboot.chapter4.aspect.validator;

import com.springboot.springboot.chapter4.pojo.User;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 17:22
 * @Version 1.0
 */
public interface UserValidator {

    public boolean validator(User user);
}
