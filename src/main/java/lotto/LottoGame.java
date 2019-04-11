package lotto;

import lotto.domain.LottoMoney;
import lotto.view.InputConsoleView;

public class LottoGame {
    private InputConsoleView inputConsoleView;

    public LottoGame() {
        inputConsoleView = new InputConsoleView();
    }

    public void run(){
        LottoMoney purchaseAmount = new LottoMoney(inputConsoleView.inputPurchaseAmount());
        
    }
}
