package com.springboot.springboot.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 11:04
 * @Version 1.0
 */
@Getter
@ToString
@AllArgsConstructor
class User{
    String username;
    int age;
}
public class AtomicRefernceDemo {
    public static void main(String[] args){
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User z3 = new User("z3",22);
        User li4 = new User("li4",25);
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"
            +atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"
                +atomicReference.get().toString());
    }
}
