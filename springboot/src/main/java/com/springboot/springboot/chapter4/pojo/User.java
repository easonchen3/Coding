package com.springboot.springboot.chapter4.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:47
 * @Version 1.0
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String note;
}

