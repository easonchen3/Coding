package com.springboot.springboot.chapter6.dao;

import com.springboot.springboot.chapter6.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 21:02
 * @Version 1.0
 */
@Mapper
public interface UserDao {

    //@Select("select id,user_name as userName,note from t_user where id = #{id}")
    User getUser(Long id);

    //@Insert("insert into t_user(user_name,note) VALUES (#{userName},#{note})")
    //@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertUser(User user);
}
