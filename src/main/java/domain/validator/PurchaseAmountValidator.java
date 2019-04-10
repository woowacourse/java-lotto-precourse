package domain.validator;

import domain.LottoEvent;

public class PurchaseAmountValidator implements Validator {

    String purchaseAmount;

    public PurchaseAmountValidator(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public boolean doesValid() {
        return doesPurchaseAmountInputIsValid()
                && doesChangeNotExist()
                && doesPurchaseAmountCanBuyAtLeastOneLotto();
    }

    boolean doesPurchaseAmountInputIsValid() {
        return new LottoInputValidator(purchaseAmount).doesValid();
    }

    boolean doesChangeNotExist() {
        return (convertStringToInt(purchaseAmount) % LottoEvent.LOTTO_PRICE) == 0;
    }

    boolean doesPurchaseAmountCanBuyAtLeastOneLotto() {
        return (convertStringToInt(purchaseAmount) / LottoEvent.LOTTO_PRICE) > 0;
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
