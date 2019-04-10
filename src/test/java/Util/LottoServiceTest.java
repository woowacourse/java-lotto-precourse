package Util;

import domain.Lotto;
import domain.WinningLotto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LottoServiceTest {

    @Test
    public void getOrderTest() {
        List<Lotto> lottos = LottoService.getOrder(3530);
        lottos.stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    @Test
    public void getWinningLottoTest() {
        WinningLotto winningLotto =
                LottoService.getWinningLotto("47, 24, 3, 5, 35, 1", 3);
        assertNull(winningLotto);
    }
}
