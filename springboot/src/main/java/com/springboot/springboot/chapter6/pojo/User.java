package com.springboot.springboot.chapter6.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 21:01
 * @Version 1.0
 */
@Alias("user")
@Data
public class User {
    private Long id;
    private String userName;
    private String note;
}
