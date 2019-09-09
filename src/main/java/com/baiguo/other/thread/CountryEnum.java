package com.baiguo.other.thread;

import lombok.Getter;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-24 17:08
 * @Version 1.0
 */
public enum CountryEnum {
    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"魏"),
    SIX(6,"韩");

    @Getter private Integer retCode;
    @Getter private String returnMessage;

    CountryEnum(Integer retCode,String returnMessage){
        this.retCode = retCode;
        this.returnMessage = returnMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for(CountryEnum element: myArray){
            if(index == element.retCode){
                return element;
            }
        }
        return null;
    }
}
