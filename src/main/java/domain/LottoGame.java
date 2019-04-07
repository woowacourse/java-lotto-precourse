package domain;


/**
 * LottoGame 전체를 위한 Class
 *
 */
public class LottoGame {
    //TODO: StartLottoGame, EndLottoGame
    public void startLottoGame() {
        Lotto testLotto = new Lotto(Lotto.generateRandomNumber());
        System.out.println(testLotto.getLotto());
    }
}
