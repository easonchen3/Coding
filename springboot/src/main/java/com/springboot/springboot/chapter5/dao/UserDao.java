package com.springboot.springboot.chapter5.dao;

import com.springboot.springboot.chapter5.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 22:47
 * @Version 1.0
 */
public interface UserDao {

    @Select("select id,user_name as userName,sex,note from t_user where id = #{id}")
    User getUser(@Param("id")Long id);
}
