package com.springboot.springboot.chapter3.pojo.definition;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:50
 * @Version 1.0
 */
public interface Person {
    /**
     * 使用动物服务
     */
    public void service();

    /**
     * 设置动物
     * @param animal
     */
    public void setAnimal(Animal animal);

}
