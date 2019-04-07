package domain;

public class LottoGameManager {
    private InputLottoInformation inputlottoinformation ;

    private void init() {
        inputlottoinformation = new InputLottoInformation();
    }

    public void lottoPurchase() {
        init();
        int money = inputlottoinformation.getLottoPurchasePrice();
    }
}
