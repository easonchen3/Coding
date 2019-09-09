package com.springboot.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@MapperScan("com.springboot.springboot.chapter6.dao")
@SpringBootApplication(scanBasePackages = {"com.springboot.springboot.chapter6"})
public class SpringbootApplication {

	/*@Bean(name = "myAspect")
	public MyAspect initMyAspect(){
		return new MyAspect();
	}*/

	@Autowired
	PlatformTransactionManager platformTransactionManager = null;

	@PostConstruct
	public void view(){
		System.out.println(platformTransactionManager.getClass().getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
