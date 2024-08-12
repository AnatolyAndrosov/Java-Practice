package com.example.springexample;

import org.springframework.stereotype.Component;

@Component
public class BeanOne {

    private BeanTwo beanTwo;

    public BeanOne(BeanTwo beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void sayBeanOne() {
        System.out.println("Я - бин номер один, яху!");
    }
}
