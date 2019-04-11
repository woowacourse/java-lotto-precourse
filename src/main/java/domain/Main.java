/*
 * Main Class
 *
 * @version 1
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

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterfaceImpl(new ValidInterfaceImpl());
        Game game = new Game(userInterface);

        game.run();
    }
}
