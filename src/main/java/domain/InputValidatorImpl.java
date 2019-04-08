package domain;

import domain.interfaces.InputValidator;

public class InputValidatorImpl implements InputValidator {

    @Override
    public boolean isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_AFFORDABLE_LOTTO_PURCHASE_AMOUNT) {
            return false;
        }
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            return false;
        }
        if (purchaseAmount % PRICE_PER_LOTTO != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidLotto(int lottoLength) {
        if (lottoLength > MAX_LOTTO_LENGTH) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidBonusNumber(int bonusNo) {
        if (bonusNo<MIN_LOTTO_NUMBER || bonusNo>MAX_LOTTO_NUMBER){
            return false;
        }
        return true;
    }
}
