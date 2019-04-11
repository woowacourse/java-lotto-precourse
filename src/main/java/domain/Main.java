/*
 * Main Class
 *
 * @version 2
 *
 * @date 2019-04-09
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain;

import domain.impl.UserInterfaceImpl;
import domain.impl.ValidInterfaceImpl;
import domain.interfaces.UserInterface;
import domain.interfaces.ValidInterface;

/**
 * 로또 게임을 시작하는 메인
 */
public class Main {
    public static void main(String[] args) {
        ValidInterface vi = new ValidInterfaceImpl();
        UserInterface ui = new UserInterfaceImpl(vi);
        Game game = new Game(ui);

        game.run();
    }
}
