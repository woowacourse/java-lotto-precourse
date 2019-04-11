package runner;

import gameService.LottoGame;

/**
 * 로또 게임을 실행하는 객체
 *
 * @version 1.0(2019.04.11)
 * @author jongyoon Kim
 */
public class GameRunner {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.run();
    }
}
