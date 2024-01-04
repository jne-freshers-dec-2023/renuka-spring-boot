package com.spring.learningspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class HelloWorldSpring  {
    public static void main(String[] args) {
        //launching spring context
        var context =new  AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //Configuring spring context
        //retriving beans
        System.out.println( "name:-"+context.getBean("name"));
        System.out.println("stud:"+context.getBean("stud"));
        System.out.println("marks:-"+context.getBean("marks"));
        System.out.println("stud:-"+context.getBean("stud"));
        System.out.println("stud3:-"+context.getBean("stud3"));
        System.out.println("stud 5:-"+context.getBean("stud5"));

        System.out.println("stud4:"+context.getBean("stud4"));

        //calling a primary bean i.e stud1
        System.out.println(context.getBean(Student.class));
        //getBeanDefination()
        System.out.println(context.getBeanDefinition("stud3"));

        //getBeanDefinitionNames()
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        //getBeanDefinitionCount()
        System.out.println(context.getBeanDefinitionCount());

    }
}
