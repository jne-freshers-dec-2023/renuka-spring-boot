package com.spring.springframeworksimpler;


import com.spring.springframeworksimpler.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.springframeworksimpler")
//class GamingConfiguration {
//
//    @Bean
//    public GamingConsole game(){
//        var game = new Bounce();
//        return game;
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
//
//
//}

public class GamingConsoleSpring {
//    @Bean
//    public GamingConsole game(){
//        var game = new Bounce();
//        return game;
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(GamingConsoleSpring.class);
        context.getBean(GamingConsole.class);
        context.getBean(GameRunner.class).run();
    }


}
