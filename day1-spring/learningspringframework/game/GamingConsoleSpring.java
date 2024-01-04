package com.spring.learningspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GamingConsoleSpring {

    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(GamingConfiguration.class);
        context.getBean(GamingConsole.class);
        context.getBean(GameRunner.class).run();
    }


}
