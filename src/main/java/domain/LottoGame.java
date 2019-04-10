package domain;

public class LottoGame {

    private PurchaseInput purchase;
    private WinningLottoInput winningLottoInput;
    private WinningLotto winningLotto;
    private UserLotto userLotto;
    private WinResult winResult;

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

        winResult = new WinResult(userLotto, winningLotto);
        winResult.checkResult();
    }


}
