package domain;

import org.junit.Test;

public class LottoMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또구매_후_남은_잔액이_있을_경우_예외처리() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);

        lottoMachine.purchaseLottos(5001);
    }
}