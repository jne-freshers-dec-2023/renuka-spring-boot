package com.spring.learningspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Student(String name,int age){


    public Student(String name, int age, int mark){

        this(name,age);
        mark=67;



    }



}

record  Marks(int m1,int m2,int m3){};
@Configuration
public class HelloWorldConfiguration {
    //launching the spring context
    @Bean
    public String name(){
        return  "Renuka";
    }

    @Bean
    public int age(){
        return 21;
    }

    @Bean
    @Qualifier("st")
    public Student stud(){
        return new Student("Vaishnavi",23);
    }
    @Bean
    @Primary
    public Student stud1(){
        return new Student(name(),age());
    }

    @Bean
    public Student stud3(String name,int age){
        return  new Student(name,age);
    }
    @Bean

    public Student stud4(String name, int age,int m){
       // System.out.println("mark"+90);
        return new Student("shambu",32,90);
    }

    @Bean
    public Student stud5(Student st){
        return new Student("Vai",32);
    }


    @Bean

    public Marks marks(){
        return new Marks(90,80,70);

    }

}
