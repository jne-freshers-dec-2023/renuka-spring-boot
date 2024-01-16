package com.spring.springframeworksimpler;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole {
    public void  up(){
        System.out.println("Move Up!!");
    }
    public  void  down(){
        System.out.println("Move Down!!");
    }
    public  void  left(){
        System.out.println("Move Left");
    }

    public  void right(){
        System.out.println("Move Right!1");
    }
}
