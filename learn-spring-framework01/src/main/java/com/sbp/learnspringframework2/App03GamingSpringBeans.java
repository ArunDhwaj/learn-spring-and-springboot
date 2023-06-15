package com.sbp.learnspringframework2;

import com.sbp.learnspringframework2.game.GameRunner;
import com.sbp.learnspringframework2.game.GamingConsole;
import com.sbp.learnspringframework2.game.PacManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args)
    {
        try(var context =
                new AnnotationConfigApplicationContext(GamingConfiguration.class))
        {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();
        }

        //var game = new MarioGame();
        //var  game = new SuperContraGame();
//        var game = new PacManGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();
    }
}
