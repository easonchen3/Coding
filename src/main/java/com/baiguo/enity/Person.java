package com.baiguo.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-13 22:22
 * @Version 1.0
 */
@NoArgsConstructor
@Setter
@Getter
public class Person {

    private Integer id;
    private String personName;

    public Person(String personName){
        this.personName = personName;
    }
}
