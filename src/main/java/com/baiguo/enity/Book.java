package com.baiguo.enity;

import lombok.Data;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-01 23:01
 * @Version 1.0
 */
@Data
public class Book {
    private Integer id;
    private String title;

    public Book(){
        System.out.println("book 对象被创建了");
    }
}
