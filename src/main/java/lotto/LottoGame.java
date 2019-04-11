package lotto;

import lotto.view.InputConsoleView;

public class LottoGame {
    private InputConsoleView inputConsoleView;

    public LottoGame() {
        inputConsoleView = new InputConsoleView();
    }

    public void run(){
        long purchaseAmount = inputConsoleView.inputPurchaseAmount();

    }
}
