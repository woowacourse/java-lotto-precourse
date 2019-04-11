package Util;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import org.junit.Test;

public class LottoTest {

    @Test
    public void getCountOfMatchTest() {
        Lotto originLotto = LottoMaker.getLotto("1, 2, 3, 4, 5, 6");
        Lotto targetLotto = LottoMaker.getLotto("1, 24, 43, 7, 8, 3");
        System.out.println(originLotto.getCountOfMatch(targetLotto));
    }

    @Test
    public void winningLottoMatchTest() {
        Lotto originLotto = LottoMaker.getLotto("1, 2, 35, 7, 10, 34");
        Lotto targetLotto = LottoMaker.getLotto("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = LottoService.getWinningLotto(targetLotto, 45);
        Rank rank = winningLotto.match(originLotto);
        System.out.println(rank.getWinningMoney());
        System.out.println(rank.getCountOfMatch());
    }
}
