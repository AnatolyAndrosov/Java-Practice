package com.example.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringExampleApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SpringExampleApplication.class, args);
        ApplicationContext context = SpringApplication.run(SpringExampleApplication.class, args);
        String[] beansNames = context.getBeanDefinitionNames();
        System.out.println("Количество бинов " + beansNames.length);
//        for (String name : beansNames) {
//            System.out.println(name);
//        }

        BeanOne beanOne = context.getBean(BeanOne.class);
        BeanTwo beanTwo = context.getBean(BeanTwo.class);

        beanOne.sayBeanOne();
        beanTwo.sayBeanTwo();

    }
}
