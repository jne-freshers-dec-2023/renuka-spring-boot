package com.spring.learningspringframework.DependencyTypeEx;

import com.oracle.svm.core.annotate.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component

class  Vehicle{

    @Autowired
    public void setC(car c) {
        System.out.println("setter:c");
        this.c = c;
    }

    public car getC() {
        System.out.println("getter:c");
        return c;
    }
    car c;
    public bike getB() {
        return b;
    }
    @Autowired
    public void setB(bike b) {
        this.b = b;
    }//    @Autowired
    bike b;



    public  String toString(){
        return  "CAR:"+c +"  AND BIKE:  "+b;
    }

    public Vehicle(car c, bike b){

        System.out.println("hey inside vehicle constructor");
        this.b=b;
        this.c=c;
    }
}
@Component
class car{

}
@Component
class bike{

}




@Configuration
@ComponentScan("com.spring.learningspringframework.DependencyTypeEx")
public class DependenceLauncherApp {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(DependenceLauncherApp.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(Vehicle.class));
        System.out.println(context.getBeanDefinitionCount());
//        System.out.println(context.getBean("vehiclename"));


    }


}
