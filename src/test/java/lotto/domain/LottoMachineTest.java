package lotto.domain;

import lotto.utils.RandomNumberGenerate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LottoMachineTest {
    private LottoMachine lottoMachine;

    @Before
    public void setup() {
        lottoMachine = new LottoMachine(new RandomNumberGenerate());
    }

    @Test
    public void 로또생성_테스트() {
        LottoMoney lottoMoney = new LottoMoney(5000);
        List<Lotto> lottos = lottoMachine.buyLottos(lottoMoney);

        Assert.assertEquals(lottoMoney.getPurchaseCount(), lottos.size());
    }

    /**
     * LottoMachine.getLotto()를 실행하면 중복되지 않는 번호를 6개를 구할 때까지 루프를 도는데
     * 계속 잘못된 입력을 할 경우 무한루프를 돈다.
     * 이런 상황에서 에러처리를 해주고 그것을 테스트 해주는 메소드.
     */
    @Test(expected = RuntimeException.class)
    public void 번호생성_무한루프_에러_테스트() {
        LottoMachine myLottoMachine = new LottoMachine(() -> 1);
        myLottoMachine.getLotto();

    }
}
