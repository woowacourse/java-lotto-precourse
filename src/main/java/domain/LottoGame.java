package domain;

import java.util.List;
import java.util.ArrayList;

/**
 * LottoGame 전체를 위한 Class
 * TODO: PlayGame, EndLottoGame
 */
public class LottoGame {
    public void startLottoGame() {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        LottoIO.printPurchase();
        int price = LottoIO.receivePrice();
        int lottoCount = Calculation.calcLottoCount(price);
        LottoIO.printLottoCount(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Lotto.generateRandomNumber());
            lottoList.add(lotto);
            LottoIO.printlottoNumber(lotto.getLotto());
        }
    }

}
