package com.sbp.learnspringframework2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Qualifier("MarioGame")
@Primary
public class MarioGame implements GamingConsole {

    public void up()
    {
        System.out.println("Mariogame: Jump up");
    }

    public void down()
    {
        System.out.println("Mariogame: Go down");
    }

    public void left()
    {
        System.out.println("Mariogame: Go left");
    }

    public void right()
    {
        System.out.println("Mariogame: Go right");
    }

}
