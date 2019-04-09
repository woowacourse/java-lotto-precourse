/*
 * @(#)Main.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
import com.kwonmc.lotto.GameRunner;

/**
 * 로또 게임 Entry Point, Main 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 * @see GameRunner
 */
public class Main {
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.run();
    }
}
