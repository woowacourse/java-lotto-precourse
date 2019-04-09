package domain;

public class LottoGame {

    PurchaseInput purchase;
    WinningLottoInput winningLotto;

    public LottoGame() {
        purchase = new PurchaseInput();
        winningLotto = new WinningLottoInput();
        play();
    }

    private void play() {
        int amountLotto;

        //amountLotto = purchase.purchaseLotto();
        winningLotto.inputWinningLotto();

    }

}
