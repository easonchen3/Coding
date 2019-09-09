package com.spring.第一节课;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-16 13:07
 * @Version 1.0
 */

@Configuration
public class MainConfig {

    @Bean
    public InstanceA instanceA(InstanceB instanceB){
        return new InstanceA(instanceB);
    }

    @Bean
    public InstanceB instanceB(InstanceA instanceA){
        return new InstanceB(instanceA);
    }



}
