package com.spring.learningspringframework;

import com.spring.learningspringframework.game.Bounce;
import com.spring.learningspringframework.game.GameRunner;
import com.spring.learningspringframework.game.GamingConsole;
import com.spring.learningspringframework.game.PacMan;

public class AppGamingJava {
    public static void main(String[] args) {

       //var game= new PacMan();
        var game=new Bounce();
        var gameRunner= new GameRunner( game);
        gameRunner.run();
    }
}
