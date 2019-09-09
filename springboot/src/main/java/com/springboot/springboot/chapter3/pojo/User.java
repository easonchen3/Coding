package com.springboot.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:27
 * @Version 1.0
 */
@Data
@Component("user")
public class User {
    @Value("1")
    private Long id;
    @Value("user_name_1")
    private String userName;
    @Value("note_1")
    private String note;
}
