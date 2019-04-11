package lotto.view;

import lotto.domain.LottoMoney;
import org.junit.Assert;
import org.junit.Test;

public class OutputConsoleViewTest {
    @Test
    public void 수익률_테스트(){
        LottoMoney purchaseAount = new LottoMoney(8000);
        long totalWinPrice =5000;
        Assert.assertEquals(62.5,  OutputConsoleView.calculateRateOfProfit(purchaseAount,totalWinPrice),0);
    }
}
