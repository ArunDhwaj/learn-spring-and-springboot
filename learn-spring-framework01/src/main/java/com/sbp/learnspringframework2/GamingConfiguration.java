package com.sbp.learnspringframework2;

import com.sbp.learnspringframework2.game.GameRunner;
import com.sbp.learnspringframework2.game.GamingConsole;
import com.sbp.learnspringframework2.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game()
    {
        var game = new PacManGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game)
    {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}
