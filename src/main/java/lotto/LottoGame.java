package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMoney;
import lotto.utils.RandomNumberGenerate;
import lotto.view.InputConsoleView;
import lotto.view.OutputConsoleView;

import java.util.List;

public class LottoGame {
    private InputConsoleView inputConsoleView;
    private LottoMachine lottoMachine;

    public LottoGame() {
        inputConsoleView = new InputConsoleView();
        lottoMachine = new LottoMachine(new RandomNumberGenerate());
    }

    public void run(){
        LottoMoney purchaseAmount = new LottoMoney(inputConsoleView.inputPurchaseAmount());
        List<Lotto> purchasedLottos =  lottoMachine.buyLottos(purchaseAmount);
        OutputConsoleView.printLottos(purchasedLottos);

    }
}
