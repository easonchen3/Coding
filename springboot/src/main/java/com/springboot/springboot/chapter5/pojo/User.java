package com.springboot.springboot.chapter5.pojo;

import com.springboot.springboot.chapter5.enumration.SexEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 21:22
 * @Version 1.0
 */
@Getter
@Setter
@Alias(value = "user") //Mybatis指定别名
public class User {
    private Long id = null;
    private String userName = null;
    //性别是枚举类型，需要使用typeHandler来进行转换
    private SexEnum sex = null;
    private String note = null;
    public User(){

    }
}
