package com.sbp.learnspringframework2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGame")
public class SuperContraGame  implements GamingConsole{
    public void up()
    {
        System.out.println("SuperContraGame: Up");
    }

    public void down()
    {
        System.out.println("SuperContraGame: Sit down");
    }

    public void left()
    {
        System.out.println("SuperContraGame: Go back");
    }

    public void right()
    {
        System.out.println("SuperContraGame: Shoot a bullet");
    }

}
