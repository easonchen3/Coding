package com.spring.第一节课;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-16 13:01
 * @Version 1.0
 */
public class InstanceA {
    private InstanceB instanceB;

    public InstanceA(InstanceB instanceB){
        this.instanceB = instanceB;
    }

    public InstanceB getInstanceB() {
        return instanceB;
    }

    public void setInstanceB(InstanceB instanceB){
        this.instanceB = instanceB;
    }
}

