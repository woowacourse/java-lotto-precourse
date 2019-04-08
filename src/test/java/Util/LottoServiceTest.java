package Util;

import domain.Lotto;
import org.junit.Test;

import java.util.List;

public class LottoServiceTest {

    @Test
    public void getOrderTest() {
        List<Lotto> lottos = LottoService.getOrder(3530);
        lottos.stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
