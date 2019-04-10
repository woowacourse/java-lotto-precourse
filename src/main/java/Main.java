/*
 * @(#)Main.java        1.0 2019/04/11
 * Copyright(c)2019     SunHo Van.
 * All right reserved.
 *
 */

import domain.LottoGame;

/**
 * Lotto 실행을 위한 Main클래스 입니다.
 *
 * @author 반선호
 * @version 1.0 2019년 4월 11일
 */
public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        game.start();
    }
}
