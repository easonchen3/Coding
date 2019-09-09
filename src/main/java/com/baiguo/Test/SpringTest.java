package com.baiguo.Test;

import com.baiguo.enity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-01 23:03
 * @Version 1.0
 */
public class SpringTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testBook(){
        Book book1 = (Book)ioc.getBean("book");
        Book book2 = (Book)ioc.getBean("book");
        System.out.println(book1 == book2);
    }
}
