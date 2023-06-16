package com.sbp.learnspringframework2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacManGame")
public class PacManGame implements GamingConsole{

    @Override
    public void up() {
        System.out.println("PackMan: Jump up");
    }

    @Override
    public void down() {
        System.out.println("PackMan: Jump Down");
    }

    @Override
    public void left() {
        System.out.println("PackMan: Jump left");
    }

    @Override
    public void right() {
        System.out.println("PackMan: Jump right");
    }
}
