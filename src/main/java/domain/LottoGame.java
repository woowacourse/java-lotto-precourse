package domain;

public class LottoGame {

    private PurchaseInput purchase;
    private WinningLottoInput winningLottoInput;
    private WinningLotto winningLotto;

    public LottoGame() {
        purchase = new PurchaseInput();
        winningLottoInput = new WinningLottoInput();
        play();
    }

    private void play() {
        int amountLotto;

        amountLotto = purchase.purchaseLotto();
        winningLotto = winningLottoInput.decideWinningLotto();
    }

}
