package com.spring.learningspringframework.game;

public class Bounce implements GamingConsole{
     public  void  up(){
        System.out.println("Jump!!");
    }
    public  void  down(){
        System.out.println("down");
    }
    public void  left(){
        System.out.println("Back");
    }

    public  void right(){
        System.out.println("Forward");
    }
}
