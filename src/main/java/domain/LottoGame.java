package domain;

import javax.jws.soap.SOAPBinding;

public class LottoGame {

    private PurchaseInput purchase;
    private WinningLottoInput winningLottoInput;
    private WinningLotto winningLotto;
    private UserLotto userLotto;

    public LottoGame() {
        purchase = new PurchaseInput();
        winningLottoInput = new WinningLottoInput();
        play();
    }

    private void play() {
        int amountLotto;

        amountLotto = purchase.purchaseLotto();

        userLotto = new UserLotto(amountLotto);

        winningLotto = winningLottoInput.decideWinningLotto();
    }


}
