package com.spring.第一节课;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-16 13:01
 * @Version 1.0
 */
public class InstanceB {

    private InstanceA instanceA;

    public InstanceB(InstanceA instanceA){
        this.instanceA = instanceA;
    }

    public InstanceA getInstanceA() {
        return instanceA;
    }

    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }
}
