package Util;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoServiceTest {

    @Test
    public void getOrderTest() {
        List<Lotto> lottos = LottoService.getOrder(3530);
        lottos.stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    @Test
    public void getLottoTest() {
        Lotto lotto = LottoService.getLotto("8, 3, 5, 35, 1, 1");
        assertNull(lotto);
    }

    @Test
    public void getMatchOfLottoTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(LottoService.getLotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(LottoService.getLotto("1, 2, 3, 4, 5, 45"));
        lottoList.add(LottoService.getLotto("1, 2, 3, 4, 5, 15"));
        lottoList.add(LottoService.getLotto("1, 2, 3, 4, 14, 15"));
        Lotto targetLotto = LottoMaker.getLotto("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = LottoService.getWinningLotto(targetLotto, 45);

        List<Rank> rankList = LottoService.getMatchOfLotto(winningLotto, lottoList);
        for (Rank rank : rankList) {
            System.out.println(rank.getCountOfMatch());
            System.out.println(rank.getWinningMoney());
            System.out.println("----------------------");
        }
    }
}
