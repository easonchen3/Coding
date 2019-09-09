package com.springboot.springboot.chapter5.enumration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 21:23
 * @Version 1.0
 */
@Getter
public enum SexEnum {
    MALE(1,"nan"),
    FEMALE(2,"nv");

    private int id;
    private String name;

    SexEnum(int id,String name){
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(int id){
        for(SexEnum sexEnum:SexEnum.values()){
            if(sexEnum.id == id){
                return sexEnum;
            }
        }
        return null;
    }

}
