/*
 * @(#)Main.java        0.1 2019/04/09
 *
 *
 */

import domain.LottoGame;

/**
 * Lotto 실행을 위한 Main클래스 입니다.
 *
 * @author 반선호
 * @version 0.1 2019년 4월 09일
 */
public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();

        game.start();
    }
}
